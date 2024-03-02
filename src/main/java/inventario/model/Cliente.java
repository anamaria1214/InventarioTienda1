package inventario.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    private String nombreCliente;
    private int numeroIdentificacion;
    private String direccion;
}
