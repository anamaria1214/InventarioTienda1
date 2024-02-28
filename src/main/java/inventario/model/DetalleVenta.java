package inventario.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalleVenta {

    private int cantidad;
    private int subTotal;
    private Producto producto;


}
