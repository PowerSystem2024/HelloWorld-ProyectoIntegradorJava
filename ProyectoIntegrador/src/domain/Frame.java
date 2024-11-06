package domain;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
    
    JButton agregarVehiculoBoton;
    JButton mostrarGarageBoton;
    JPanel menuPrincipal;
    JPanel menuAgregarVehiculo;
    JPanel menuMostrarGarage;
    JButton volverAtrasBotonAgregarVehiculo;
    JButton volverAtrasBotonMostrarGarage;
    CardLayout cardLayout;
    JRadioButton autoOpcion;
    JRadioButton motoOpcion;
    JComboBox marcaOpciones;
    JLabel marcaTexto;
    JPanel marcaPanel;
    JComboBox modeloOpciones;
    JLabel modeloTexto;
    JPanel modeloPanel;
    JComboBox añoOpciones;
    JLabel añoTexto;
    JPanel añoPanel;
    JComboBox numPuertasOpciones;
    JLabel numPuertasTexto;
    JPanel numPuertasPanel;
    JComboBox tipoMotoOpciones;
    JLabel tipoMotoTexto;
    JPanel tipoMotoPanel;
    String[] marcasAutos = {
    "Toyota", "Ford", "Chevrolet", "Honda", "Nissan", "BMW", "Mercedes-Benz"
    };
    String[] marcasMotos = {
    "Harley-Davidson", "Honda", "Yamaha", "Kawasaki", "Suzuki", "Ducati", "BMW"
    };
    String[] modelosAutos = {
    "Corolla", "Civic", "Mustang", "Camaro", "Accord", "Altima", "3 Series",
    "A4", "C-Class", "Model S", "Golf", "Outback", "MX-5 Miata", "RAV4", "CR-V"
};
    String[] modelosMotos = {
    "Sportster", "CBR600RR", "ZX-6R", "Hayabusa", "YZF-R1",
    "390 Duke", "Panigale V2", "Z900", "S1000RR",
    "Road King", "Gold Wing", "V-Strom 650",
    "Rebel 500", "MT-07", "Bonneville"
};
    Integer[] añosVehiculos = {2024, 2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015};
    Integer[] numeroDePuertas = {2, 3, 4, 5};
    JButton guardarVehiculoBoton;
    String[] estilosMotos = {"Deportiva", "Cruiser", "Touring", "Adventure", "Standard", "Dirt"};
    JButton eliminarVehiculoBoton;
    // Lista de Vehículos
    private DefaultListModel<Vehiculo> vehiculos = new DefaultListModel<>();
    JList<Vehiculo> jListVehiculos;
    
    public Frame(){
        
        
        
        
        //----------------Sección de la Ventana del Programa---------------
        
	cardLayout = new CardLayout();
        this.setLayout(cardLayout); // Configura el CardLayout en el JFrame
        
        // Agrega los paneles al CardLayout con nombres únicos
        this.add(menuPrincipal, "MenuPrincipal");
        this.add(menuAgregarVehiculo, "MenuAgregarVehiculo");
        this.add(menuMostrarGarage, "MenuMostrarGarage");
        
        this.setSize(500, 500);
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == agregarVehiculoBoton){
            cardLayout.show(this.getContentPane(), "MenuAgregarVehiculo"); // Muestra menuAgregarVehiculo
        }
        else if(e.getSource() == mostrarGarageBoton){
            cardLayout.show(this.getContentPane(), "MenuMostrarGarage"); // Muestra menuMostrarGarage
        }
        else if(e.getSource() == volverAtrasBotonAgregarVehiculo || e.getSource() == volverAtrasBotonMostrarGarage){
            cardLayout.show(this.getContentPane(), "MenuPrincipal"); // Muestra menuPrincipal
        }
        
        if (e.getSource() == autoOpcion) {
            actualizarOpcionesComboBox(marcaOpciones, marcasAutos);
            actualizarOpcionesComboBox(modeloOpciones, modelosAutos);
            numPuertasPanel.setVisible(true);
            tipoMotoPanel.setVisible(false);
        } else if (e.getSource() == motoOpcion) {
            actualizarOpcionesComboBox(marcaOpciones, marcasMotos);
            actualizarOpcionesComboBox(modeloOpciones, modelosMotos);
            numPuertasPanel.setVisible(false);
            tipoMotoPanel.setVisible(true);
        }
        
        if(e.getSource() == guardarVehiculoBoton){
            String tipo = autoOpcion.isSelected() ? "Auto" : "Moto";
            String marca = (String) marcaOpciones.getSelectedItem();
            String modelo = (String) modeloOpciones.getSelectedItem();
            int año = (Integer) añoOpciones.getSelectedItem();
            Integer numPuertas = autoOpcion.isSelected() ? (Integer) numPuertasOpciones.getSelectedItem() : null;
            String tipoMoto = (String) tipoMotoOpciones.getSelectedItem();
            if(tipo.equals("Auto")){
                vehiculos.addElement(new Coche(numPuertas, marca, modelo, año)); // Agregar el auto a la lista
            }
            else if(tipo.equals("Moto")){
                vehiculos.addElement(new Moto(tipoMoto, marca, modelo, año)); // Agregar el auto a la lista
            }
            JOptionPane.showMessageDialog(null, "Vehículo Guardado");
        }   
        
        if(e.getSource() == eliminarVehiculoBoton){
            Vehiculo seleccionado = jListVehiculos.getSelectedValue(); // Obtener el vehículo seleccionado
    
            if (seleccionado != null) {
                vehiculos.removeElement(seleccionado); // Eliminar del DefaultListModel
                JOptionPane.showMessageDialog(null, "Vehículo eliminado: " + seleccionado.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No hay vehículo seleccionado");
            }
        }
    }
    
    private void actualizarOpcionesComboBox(JComboBox comboBox, String[] opciones) {
        comboBox.removeAllItems(); // Limpia las opciones existentes
        for (String opcion : opciones) {
            comboBox.addItem(opcion); // Añade las nuevas opciones
        }
    }

    
}
