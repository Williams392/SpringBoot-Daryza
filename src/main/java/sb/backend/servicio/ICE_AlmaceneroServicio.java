package sb.backend.servicio;

import sb.backend.modelo.CE_Almacenero;
import java.util.List;

public interface ICE_AlmaceneroServicio {
    public List<CE_Almacenero> listarAlmaceneros();
    public CE_Almacenero buscarAlmaceneroPorId(Integer id);
    public CE_Almacenero guardarAlmacenero(CE_Almacenero almacenero);
    public void eliminarAlmaceneroPorId(Integer id);
}
