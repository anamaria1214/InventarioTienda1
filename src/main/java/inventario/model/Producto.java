package inventario.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Comparable<Producto> {

    private int codProducto;
    private String nombreProducto;
    private double precio;
    private int cantInventario;

    @Override
    public int compareTo(Producto o) {
        return codProducto - o.getCodProducto();
    }
}
