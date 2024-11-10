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
        
        
        
        //--------------------Sección del Panel Mostrar Garage----------------------

        // Boton de eliminar vehiculo
        eliminarVehiculoBoton = new JButton("Eliminar");
        
        // Establecer el tamaño preferido
        eliminarVehiculoBoton.setSize(eliminarVehiculoBoton.getPreferredSize());

        // Posicionar JButton
        eliminarVehiculoBoton.setBounds(10, 10, eliminarVehiculoBoton.getWidth(), eliminarVehiculoBoton.getHeight());
        
        // Agregar Action Listener al boton
        eliminarVehiculoBoton.addActionListener(this);
        
        // Crear el JList y configurarlo para selección simple
        jListVehiculos = new JList<>(vehiculos);
        jListVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Agregar el JList al JScrollPane
        JScrollPane garageScrollPane = new JScrollPane(jListVehiculos);
        
        // Establecer tamaño y limites de garageScrollPane
        garageScrollPane.setSize(450, 400);
        garageScrollPane.setBounds(10, 50, 450, 400);
        
        // Boton volver atrás del panel mostrarGarage
        volverAtrasBotonMostrarGarage = new JButton("Volver atrás");
        volverAtrasBotonMostrarGarage.addActionListener(this);
        
        // Obtener el tamaño preferido del boton volver atras
        volverAtrasBotonMostrarGarage.setSize(volverAtrasBotonMostrarGarage.getPreferredSize());
        
        // Colocar el botón en la esquina superior derecha
        volverAtrasBotonMostrarGarage.setBounds(
                475 - volverAtrasBotonMostrarGarage.getWidth(), 
                10, 
                volverAtrasBotonMostrarGarage.getWidth(), 
                volverAtrasBotonMostrarGarage.getHeight());
        
        
        // Establece panel de Mostrar Garage
        menuMostrarGarage = new JPanel();
        menuMostrarGarage.setLayout(null);
        
        // Agregar Componentes al panel menuMostrarGarage
        menuMostrarGarage.add(volverAtrasBotonMostrarGarage);
        menuMostrarGarage.add(garageScrollPane);
        menuMostrarGarage.add(eliminarVehiculoBoton);
        
        //------------------Sección del panel del Menu Principal-----------------------
        
        // Crear el panel principal con BorderLayout
        menuPrincipal = new JPanel();
        menuPrincipal.setLayout(null);

        // Crear los botones
        mostrarGarageBoton = new JButton("Mostrar Garage");
        agregarVehiculoBoton = new JButton("Agregar Vehículo");

        // Agregar botones al panel menuPrincipal
        menuPrincipal.add(mostrarGarageBoton);
        menuPrincipal.add(agregarVehiculoBoton);
        
        // Establecer el tamaño de los botones
        mostrarGarageBoton.setSize(mostrarGarageBoton.getPreferredSize());
        agregarVehiculoBoton.setSize(agregarVehiculoBoton.getPreferredSize());
        
        // Posiciona los botones en menuPrincipal
        mostrarGarageBoton.setBounds(
                100, 
                200, 
                mostrarGarageBoton.getWidth(), 
                mostrarGarageBoton.getHeight());
        agregarVehiculoBoton.setBounds(
                100+mostrarGarageBoton.getWidth()+50, 
                200, 
                agregarVehiculoBoton.getWidth(), 
                agregarVehiculoBoton.getHeight());
        
        // Agrega un ActionListener al botón para manejar eventos de acción
        agregarVehiculoBoton.addActionListener(this);
        mostrarGarageBoton.addActionListener(this);
        
        // Desactiva el enfoque visual de los botones
        agregarVehiculoBoton.setFocusable(false);        
        mostrarGarageBoton.setFocusable(false);
        
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
