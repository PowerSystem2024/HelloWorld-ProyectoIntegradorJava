package domain;

public class Moto extends Vehiculo { // "extends Vehiculo" simboliza que hereda de la super clase Vehiculo
    
    // atributos propios de Coche
    String tipo_moto;
    
    // constructor de Coche
    public Moto(String tipo_moto, String marca, String modelo, int anio) { // atributos totales de Coche
        super(marca, modelo, anio); // atributos que hereda de Vehiculo
        this.tipo_moto = tipo_moto; // atributo propio de Moto
    }
    
    // getters y setters
    public String getTipo_moto() {
        return tipo_moto;
    }

    public void setTipo_moto(String tipo_moto) {
        this.tipo_moto = tipo_moto;
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
    void arrancar() {
        System.out.println("la moto está encendida");
    }
    
    @Override 
    void detener() {
        System.out.println("la moto está detenida");
    }
   
    @Override 
    void mostrarInfo() {
        
        System.out.println("especificaciones de la moto: ");
        
        System.out.println("tipo de moto: " + tipo_moto);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
        
    }       
}