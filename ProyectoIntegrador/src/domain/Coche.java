package domain;

public class Coche extends Vehiculo { // "extends Vehiculo" simboliza que hereda de la super clase Vehiculo

    // atributos propios de Coche
    int num_puertas;

    // constructor de Coche
    public Coche(int num_puertas, String marca, String modelo, int anio) { // atributos totales de Coche
        super(marca, modelo, anio); // atributos que hereda de Vehiculo
        this.num_puertas = num_puertas; // atributo propio de coche
    }

    // getters y setters

    public int getNum_puertas() {
        return num_puertas;
    }

    public void setNum_puertas(int num_puertas) {
        this.num_puertas = num_puertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return anio;
    }

    public void setAño(int año) {
        this.anio = año;
    }

    // inicializar los metodos abstractos
    @Override // señala que se esta sobreescribiendo un metodo abstracto
    String mostrarInfo() {
        return "===== Coche =====\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Año: " + anio + "\n" +
                "Número de Puertas: " + num_puertas + "\n" +
                "==================";
    }

    @Override
    public String toString() {
        return "Coche: " + marca + " " + modelo + " " + anio + " con " + num_puertas + " puertas";
    }

}