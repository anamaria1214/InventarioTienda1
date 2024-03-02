package inventario.model;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tienda {

    private int nit;
    private String nombre;
    private String direccion;
    private HashMap<Integer, String> clientes;
    private TreeSet<Producto> productos ;
    private LinkedList<Venta> ventas;
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

    }

    private void leerProductos() {
        try(Scanner scanner= new Scanner(new File("src/main/resources/archivos/productos.txt"))){
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

    //public void


}
