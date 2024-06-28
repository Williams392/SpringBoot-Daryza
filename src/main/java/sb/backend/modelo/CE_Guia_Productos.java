package sb.backend.modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CE_Guia_Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guiaProd")
    private Integer id_guiaProd;

    private String detalleProd;

    @ManyToOne
    @JoinColumn(name = "nombreProd")
    @JsonIgnore
    private CE_Producto nombreProd;
}