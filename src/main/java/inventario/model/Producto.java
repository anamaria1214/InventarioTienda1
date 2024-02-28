package inventario.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {

    private int codProducto;
    private String nombreProducto;
    private double precio;
    private int cantInventario;
}
