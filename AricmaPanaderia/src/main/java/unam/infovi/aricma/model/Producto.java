
package unam.infovi.aricma.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author rodrigo
 */

@Data // Framework de Lombok genera el codigo necesario para hacerlo un JavaBean
@Entity // La convertimos en una clase de entidad
@Table(name = "producto") // Para indicar el nombre exacto de la tabla en la base de datos (relacion)
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L; // Con esto se implementa la interfaz de serializable

    // Mapeo de la llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    // Agregamos las notaciones dentro de la clase de entidad para indicar que no
    // son validos los valores nulos

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String codigo;

    @NotEmpty
    double precio;
}
