package sb.backend.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CE_Hoja_Requerimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codRequer;
    private String descripcionR;
    private Integer cantidadR;
    private String calidadProd;
    private String reglas;

    @ManyToOne
    @JoinColumn(name = "codigoProd")
    @JsonIgnore
    private CE_Producto codigoProd;

}
