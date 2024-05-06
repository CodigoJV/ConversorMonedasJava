public class Moneda {
    private String nombre;
    private String otraMoneda;
    private Object conversion;

    public Moneda(MonedaApi monedaApi){
        this.nombre = monedaApi.base_code();
        this.otraMoneda = monedaApi.target_code();
        this.conversion = monedaApi.conversion_rate();
    }

    public String getOtraMoneda() {
        return otraMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public Object getConversion() {
        return conversion;
    }

//    public double conversionA(String otraMoneda){
//        return conversiones.getMember();
//    }


    @Override
    public String toString() {
        return "Moneda{" +
                "Nombre='" + nombre + '\'' +
                ", Conversiones=" + conversion +
                '}';
    }
}




