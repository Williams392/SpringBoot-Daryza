package sb.backend.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CE_Almacenero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEmpleado;

    private String nombEmpleado;
    private String apellEmpleado;
    private String dni;
    private String cargo;

}
