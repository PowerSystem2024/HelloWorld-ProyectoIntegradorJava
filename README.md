# 🌍 **HelloWorld** 🌍 - Proyecto Integrador Java

## 👥 **Integrantes** 👥
- **Carlos Ariel Diaz Cattoni** 🎓
- **Juan Bisaguirre** 💻
- **Joaquin Peralta Corbellini** 📚
- **Julieta Aguilera** 🔬
- **Danna Martinez** 🧪

## Descripción

Este proyecto es una **aplicación de gestión de vehículos** desarrollada en **Java**, utilizando el **patrón de programación orientada a objetos** y la **librería Swing** para la interfaz gráfica de usuario. La aplicación permite al usuario **agregar y gestionar vehículos** (autos y motos) mediante una interfaz intuitiva y sencilla.

### Descripción del Proyecto

El programa cuenta con una **ventana principal** que facilita la navegación a través de varios menús. Se ha implementado un **CardLayout** para cambiar dinámicamente entre las diferentes secciones de la aplicación:

- **Menú Principal**: Ofrece dos opciones: agregar un nuevo vehículo o visualizar los vehículos almacenados en el garaje.
- **Agregar Vehículo**: Permite al usuario seleccionar el tipo de vehículo (auto o moto) e ingresar sus características (marca, modelo, año, y atributos específicos como número de puertas para autos o tipo de moto).
- **Mostrar Garaje**: Muestra una lista de vehículos previamente agregados y permite al usuario eliminar vehículos seleccionados.

### Funcionalidades Principales

1. **Agregar Vehículo**: 
   - Selección entre autos y motos.
   - Ingreso de atributos específicos según el tipo de vehículo.
   - Almacenamiento en una lista que puede visualizarse posteriormente.

2. **Mostrar Garaje**: 
   - Visualización de los vehículos agregados.
   - Eliminación de vehículos desde la lista.

3. **Interfaz Gráfica**:
   - Uso de **JPanel**, **JButton**, **JComboBox**, **JList**, y **JScrollPane**.
   - Navegación mediante **CardLayout** para cambiar entre los distintos paneles.

### Estructura del Proyecto

El proyecto está dividido en varios archivos:

- **Frame.java**: Clase principal que gestiona la interfaz gráfica y los eventos de usuario.
- **Vehiculo.java**: Clase abstracta que define los atributos comunes para los vehículos.
- **Coche.java** y **Moto.java**: Clases que heredan de `Vehiculo` y añaden atributos específicos.
- **Test.java**: Clase que contiene el método `main` para ejecutar la aplicación.
