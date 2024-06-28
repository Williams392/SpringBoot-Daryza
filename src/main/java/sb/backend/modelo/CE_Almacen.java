package sb.backend.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CE_Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num_Almacen;
    private String nom_Almacen;
    private String  ubi_Almacen; // Considera cambiar 'Object' por el tipo de datos correcto para la columna GEOGRAPHY
}