package inventario.model;

import lombok.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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
        this.ventas= new LinkedList<>();

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

                this.productos.add(new Producto(Integer.parseInt(valores[0]), valores[1], Double.parseDouble(valores[2]), Integer.parseInt(valores[3])));
            }
        }catch(IOException e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }

    }

    public void agregarCliente(Cliente cliente){
        if(obtenerCliente(cliente.getNumeroIdentificacion())==null){
            clientes.put(cliente.getNumeroIdentificacion(), cliente);
        }else{
            JOptionPane.showMessageDialog(null, "El cliente ya se encuentra registrado");
        }

    }

    public void actualizarCliente(Cliente cliente, int id) {
        if (clientes.containsKey(id)) {
            clientes.put(id, cliente);
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con el Numero de identificación proporcionado.");
        }
    }

    public boolean verificarProducto(String id) {
        for (Producto producto: productos) {
            if(producto.getCodProducto() == Integer.parseInt(id)){
                return true;
            }
        }
        return false;
    }

    public Producto obtenerProducto(String id) {
        Producto productoNuevo = new Producto();
        for (Producto producto: productos) {
            if(producto.getCodProducto() == Integer.parseInt(id)){
                productoNuevo = producto;
                return productoNuevo;
            }
        }
        return null;
    }
    public void restarInventario(Producto producto, int cantidad){
        if (cantidad>=producto.getCantInventario()){
            JOptionPane.showMessageDialog(null, "No se puede realizar la venta " +
                    "porque no hay suficientes unidades en el inventario del producto seleccionado");
        }else{
            producto.setCantInventario(producto.getCantInventario()-cantidad);

        }

    }

    public Venta crearVenta(ArrayList<DetalleVenta> productos, int idCliente) {
        Venta venta = new Venta();
        Cliente cliente = obtenerCliente(idCliente);
        if(cliente!=null){
            Random rand = new Random();
            int codigo = rand.nextInt(1000);
            LocalDate fechaActual = LocalDate.now();
            String fecha = fechaActual.toString();
            double precioTotal = calcularPrecioTotalCarrito2(productos);

            venta.setIdCliente(cliente.getNumeroIdentificacion());
            venta.setCodigoventa(codigo);
            venta.setFecha(fecha);
            venta.setPrecioTotal(precioTotal);
            venta.setDetalles(productos);
        }else{
            JOptionPane.showMessageDialog(null,"El cliente no se encuentra registrado, se debe agregar primero");
        }
        return venta;
    }
    public void agregarVenta(Venta venta){
        ventas.add(venta);
    }

    public Cliente obtenerCliente(int idCliente) {
        Cliente cliente = new Cliente();
        if(clientes.containsKey(idCliente)){
            cliente = clientes.get(idCliente);
            return cliente;
        }else{
            return null;
        }

    }
    public void eliminarCliente(int id) {
        if (clientes.containsKey(id)) {
            clientes.remove(id);
        }
    }

    private double calcularPrecioTotalCarrito2(ArrayList<DetalleVenta> productos) {
        double precioTotal = 0;
        for (DetalleVenta detalle: productos) {
            precioTotal += (detalle.getSubTotal());
        }
        return  precioTotal;
    }

    public void actualizarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getNumeroIdentificacion())) {
            clientes.put(cliente.getNumeroIdentificacion(), cliente);
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún cliente con el Numero de identificación proporcionado.");
        }
    }
}
