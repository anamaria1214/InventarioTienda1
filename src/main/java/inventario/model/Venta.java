package inventario.model;
import lombok.*;

import java.util.ArrayList;

@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Venta {

    private int codigoventa;
    private String fecha;
    private double PrecioTotal;
    private int idCliente;
    private ArrayList<DetalleVenta> detalles;
}
