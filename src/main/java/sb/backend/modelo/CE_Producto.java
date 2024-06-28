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
public class CE_Producto {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer codigoProd;

    private String nombreProd;
    private String marca;
    private String descripcion;
    private String calidadP;
    private Integer cantidadExistencia;
    private Integer precioProd;

    private String categoria;
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "codRequer")
    private CE_Hoja_Requerimientos codRequer;

    @ManyToOne
    @JoinColumn(name = "almacenero")
    private CE_Almacenero almacenero;

    @ManyToOne
    @JoinColumn(name = "num_GuiaInv")
    private CE_Guia_Inventario  num_GuiaInv;

    @ManyToOne
    @JoinColumn(name = "numAlmacen")
    private CE_Almacen  numAlmacen;

    @ManyToOne
    @JoinColumn(name = "id_guiaProd")
    private CE_Guia_Productos    id_guiaProd;

}
