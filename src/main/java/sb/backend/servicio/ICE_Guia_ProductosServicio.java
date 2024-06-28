package sb.backend.servicio;

import sb.backend.modelo.CE_Guia_Productos;

import java.util.List;

public interface ICE_Guia_ProductosServicio {
    public List<CE_Guia_Productos> listarGuiasProductos();
    public CE_Guia_Productos buscarGuiaProductosPorId(Integer id);
    public CE_Guia_Productos guardarGuiaProductos(CE_Guia_Productos guiaProductos);
    public void eliminarGuiaProductosPorId(Integer id);
}