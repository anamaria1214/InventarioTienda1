package inventario.model;

import lombok.*;

import java.util.HashSet;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarritoDeCompras {

    private int codigoCarrito;
    private HashSet<Producto> productosCarrito;



}
