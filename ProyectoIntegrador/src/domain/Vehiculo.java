package domain;

abstract class Vehiculo {


    String marca;
    String modelo;
    int anio;


    public Vehiculo(String marca, String modelo, int anio) {

        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;

    }


    abstract String mostrarInfo();
}

