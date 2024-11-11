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
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

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
        
        //-----------Sección del Panel Agregar Vehiculo--------
        
        // Establece botón volver atrás del panel menuAgregarVehiculo
        volverAtrasBotonAgregarVehiculo = new JButton("Volver atrás");
        volverAtrasBotonAgregarVehiculo.addActionListener(this);
        
        // Obtener el tamaño preferido del boton volver atras
        volverAtrasBotonAgregarVehiculo.setSize(volverAtrasBotonAgregarVehiculo.getPreferredSize());
        
        // Colocar el botón en la esquina superior derecha
        volverAtrasBotonAgregarVehiculo.setBounds(
                475 - volverAtrasBotonAgregarVehiculo.getWidth(), 
                10, 
                volverAtrasBotonAgregarVehiculo.getWidth(), 
                volverAtrasBotonAgregarVehiculo.getHeight());
        
        
        autoOpcion = new JRadioButton("Auto");
        motoOpcion = new JRadioButton("Moto");
        ButtonGroup group = new ButtonGroup();
        group.add(autoOpcion);
        group.add(motoOpcion);
        
        // Establecer autoOpcion por default
        autoOpcion.setSelected(true);

        // Agregar listeners
        autoOpcion.addActionListener(this);
        motoOpcion.addActionListener(this);

        // Establecer el tamaño preferido
        autoOpcion.setSize(autoOpcion.getPreferredSize());
        motoOpcion.setSize(motoOpcion.getPreferredSize());

        // Posicionar los JRadioButtons
        autoOpcion.setBounds(10, 10, motoOpcion.getWidth(), autoOpcion.getHeight());
        motoOpcion.setBounds(10, 40, motoOpcion.getWidth(), motoOpcion.getHeight());
        
        // Panel con componentes relacionados a marca
        marcaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        marcaTexto = new JLabel("Marca:");
        marcaPanel.add(marcaTexto);
        marcaOpciones = new JComboBox(marcasAutos);
        marcaPanel.add(marcaOpciones);
        
        
        // Establecer el tamaño preferido
        marcaPanel.setSize(marcaPanel.getPreferredSize());
        
        int posYPanel = 75;
        int posXPanel = 150;
        
        // Posicionar marcaPanel
        marcaPanel.setBounds(
                posXPanel, 
                posYPanel, 
                marcaPanel.getWidth()+100, 
                marcaPanel.getHeight());
        
        // Panel con componentes relacionados al modelo
        modeloPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        modeloTexto = new JLabel("Modelo:");
        modeloPanel.add(modeloTexto);
        modeloOpciones = new JComboBox(modelosAutos);
        modeloPanel.add(modeloOpciones);
        
        // Establecer el tamaño preferido
        modeloPanel.setSize(modeloPanel.getPreferredSize());
        
        posYPanel += 50;
        
        // Posicionar modeloPanel
        modeloPanel.setBounds(
                posXPanel, 
                posYPanel, 
                modeloPanel.getWidth()+75, 
                modeloPanel.getHeight());
        
        // Panel con componentes relacionados al año
        añoPanel = new JPanel();
        añoTexto = new JLabel("Año:");
        añoPanel.add(añoTexto);
        añoOpciones = new JComboBox(añosVehiculos);
        añoPanel.add(añoOpciones);
        
        // Establecer el tamaño preferido
        añoPanel.setSize(añoPanel.getPreferredSize());
        
        posYPanel += 50;
        
        // Posicionar añoPanel
        añoPanel.setBounds(
                posXPanel, 
                posYPanel, 
                añoPanel.getWidth(), 
                añoPanel.getHeight());
        
        // Panel con componentes relacionados al número de puertas
        numPuertasPanel = new JPanel();
        numPuertasTexto = new JLabel("Número de Puertas:");
        numPuertasPanel.add(numPuertasTexto);
        numPuertasOpciones = new JComboBox(numeroDePuertas);
        numPuertasPanel.add(numPuertasOpciones);
        
        // Establecer el tamaño preferido
        numPuertasPanel.setSize(numPuertasPanel.getPreferredSize());
        
        posYPanel += 50;
        
        // Posicionar numPuertasPanel
        numPuertasPanel.setBounds(
                posXPanel, 
                posYPanel, 
                numPuertasPanel.getWidth(), 
                numPuertasPanel.getHeight());
        
        // Panel con componentes relacionados al número de puertas
        tipoMotoPanel = new JPanel();
        tipoMotoTexto = new JLabel("Tipo de Moto:");
        tipoMotoPanel.add(tipoMotoTexto);
        tipoMotoOpciones = new JComboBox(estilosMotos);
        tipoMotoPanel.add(tipoMotoOpciones);
        tipoMotoPanel.setVisible(false);
        
        // Establecer el tamaño preferido
        tipoMotoPanel.setSize(tipoMotoPanel.getPreferredSize());
        
        // Posicionar tipoMotoPanel
        tipoMotoPanel.setBounds(
                posXPanel, 
                posYPanel, 
                tipoMotoPanel.getWidth(), 
                tipoMotoPanel.getHeight());
        
        // Botón de Guardar Vehículo
        guardarVehiculoBoton = new JButton("Guardar");
        guardarVehiculoBoton.addActionListener(this);
        
        // Establecer el tamaño preferido
        guardarVehiculoBoton.setSize(guardarVehiculoBoton.getPreferredSize());
        
        // Posicionar guardarVehiculoBoton
        guardarVehiculoBoton.setBounds(
                240-guardarVehiculoBoton.getWidth()/2, 
                350, 
                guardarVehiculoBoton.getWidth(), 
                guardarVehiculoBoton.getHeight());
        
        // Establece panel de Agregar Vehículo
        menuAgregarVehiculo = new JPanel();
        menuAgregarVehiculo.setLayout(null);

        
        // Agregar Componentes al panel menuAgregarVehiculo
        menuAgregarVehiculo.add(volverAtrasBotonAgregarVehiculo);
        menuAgregarVehiculo.add(autoOpcion);
        menuAgregarVehiculo.add(motoOpcion);
        menuAgregarVehiculo.add(marcaPanel);
        menuAgregarVehiculo.add(modeloPanel);
        menuAgregarVehiculo.add(añoPanel);
        menuAgregarVehiculo.add(numPuertasPanel);
        menuAgregarVehiculo.add(guardarVehiculoBoton);
        menuAgregarVehiculo.add(tipoMotoPanel);
        
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
