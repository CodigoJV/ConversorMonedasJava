import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public void convertir(String codigoMoneda1, String codigoMoneda2, double cantidad){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/d24f5be30bdda012a83a0f63/pair/" + codigoMoneda1 + "/" + codigoMoneda2 + "/");
        double cantidadConvertida;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            MonedaApi monedaApi = gson.fromJson(response.body(), MonedaApi.class);
            FileWriter escribir = new FileWriter(monedaApi.base_code()+"to" +monedaApi.target_code() + ".json");
            escribir.write(response.body());
            escribir.close();
            Moneda moneda = new Moneda(monedaApi);
            cantidadConvertida = cantidad * (double) moneda.getConversion();

            System.out.printf("%.2f %s es igual a %.2f %s\n\n", cantidad, moneda.getNombre(), cantidadConvertida, moneda.getOtraMoneda() );

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException();
        } catch (NullPointerException e){
            System.out.println("Error al encontrar la divisa, porfavor verifiquela. Solo se admiten claves de divisa");
        }
    }

}
