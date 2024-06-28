package sb.backend.servicio;

import sb.backend.modelo.CE_Hoja_Requerimientos;
import java.util.List;

public interface ICE_Hoja_RequerimientosServicio {
    public List<CE_Hoja_Requerimientos> listarHojaRequerimientos();
    public CE_Hoja_Requerimientos buscarHojaRequerimientosPorId(Integer id);
    public CE_Hoja_Requerimientos guardarHojaRequerimientos(CE_Hoja_Requerimientos hojaRequerimientos);
    public void eliminarHojaRequerimientosPorId(Integer id);
}
