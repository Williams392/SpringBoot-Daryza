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
public class CE_Guia_Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_GuiaInv")
    private Integer num_GuiaInv;

    private String descripcionG;
    private String tipoProd;
    private Integer cantProdActual;

    @ManyToOne
    @JoinColumn(name = "num_Almacen")
    private CE_Almacen num_Almacen;

    @ManyToOne
    @JoinColumn(name = "codigoProd")
    @JsonIgnore
    private CE_Producto codigoProd;

}
