package inventario.model;

import lombok.*;

import java.util.*;

@ToString
@Getter
@Setter
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


}
