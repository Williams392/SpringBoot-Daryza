package sb.backend.servicio;

import sb.backend.modelo.CE_Almacen;

import java.util.List;

public interface ICE_AlmacenServicio {
    public List<CE_Almacen> listarAlmacenes();
    public CE_Almacen buscarAlmacenPorId(Integer id);
    public CE_Almacen guardarAlmacen(CE_Almacen almacen);
    public void eliminarAlmacenPorId(Integer id);
}