package sb.backend.servicio;

import sb.backend.modelo.CE_Producto;
import java.util.List;

public interface ICE_ProductoServicio {

    public List<CE_Producto> listarProductos();
    public CE_Producto buscarProductoPorId(Integer id);
    public CE_Producto guardarProducto(CE_Producto producto);
    public void eliminarProductoPorId(Integer id);

}
