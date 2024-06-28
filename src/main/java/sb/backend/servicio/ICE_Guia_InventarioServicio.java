package sb.backend.servicio;

import sb.backend.modelo.CE_Guia_Inventario;
import java.util.List;

public interface ICE_Guia_InventarioServicio {
    public List<CE_Guia_Inventario> listarGuiasInventario();
    public CE_Guia_Inventario buscarGuiaInventarioPorId(Integer id);
    public CE_Guia_Inventario guardarGuiaInventario(CE_Guia_Inventario guiaInventario);
    public void eliminarGuiaInventarioPorId(Integer id);
}

