package inventario.model;

import lombok.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Tienda {
    @Getter
    private int nit;
    @Getter
    private String nombre;
    @Getter
    private String direccion;
    @Getter
    private HashMap<Integer, Cliente> clientes;
    @Getter
    private TreeSet<Producto> productos;
    @Getter
    private LinkedList<Venta> ventas;
    @Getter
    private HashSet<CarritoDeCompras> carritosDeCompras;

    private static Tienda Tienda;
    private static final Logger LOGGER = Logger.getLogger(Tienda.class.getName());

    private Tienda() {
        try {
            FileHandler fh = new FileHandler("logs.log", true);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            LOGGER.log(Level.INFO, "Archivo no encontrado");
            LOGGER.log(Level.INFO, "Archivo no encontrado");
        }
        LOGGER.log(Level.INFO, "Se creó una nueva instancia");

        this.productos =  new TreeSet<>();
        leerProductos();
        this.clientes= new HashMap<>();

    }

    public static Tienda getInstance(){
        if(Tienda == null){
            Tienda = new Tienda();
        }

        return Tienda;
    }

    private void leerProductos() {
        try(Scanner scanner= new Scanner(new File("src/main/resources/archivos/productos"))){
            while(scanner.hasNextLine()){
                String linea= scanner.nextLine();
                String [] valores= linea.split(";");
                this.productos.add(new Producto(Integer.parseInt(valores[0]), valores[1],
                        Double.parseDouble(valores[2]), Integer.parseInt(valores[3])));
            }
        }catch(IOException e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }

    }

    public void agregarCliente(Cliente cliente){
        clientes.put(cliente.getNumeroIdentificacion(), cliente);
        JOptionPane.showMessageDialog(null,"Se registró correctamente");

    }


}
