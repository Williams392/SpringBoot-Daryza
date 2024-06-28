package sb.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.backend.modelo.CE_Hoja_Requerimientos;
import sb.backend.repositorio.CE_Hoja_RequerimientosRepositorio;

import java.util.List;

@Service
public class CE_Hoja_RequerimientosServicio implements ICE_Hoja_RequerimientosServicio {

    @Autowired
    private CE_Hoja_RequerimientosRepositorio hojaRequerimientosRepositorio;

    @Override
    public List<CE_Hoja_Requerimientos> listarHojaRequerimientos() {
        return this.hojaRequerimientosRepositorio.findAll();
    }

    @Override
    public CE_Hoja_Requerimientos buscarHojaRequerimientosPorId(Integer id) {
        return this.hojaRequerimientosRepositorio.findById(id).orElse(null);
    }

    @Override
    public CE_Hoja_Requerimientos guardarHojaRequerimientos(CE_Hoja_Requerimientos hojaRequerimientos) {
        return this.hojaRequerimientosRepositorio.save(hojaRequerimientos);
    }

    @Override
    public void eliminarHojaRequerimientosPorId(Integer id) {
        this.hojaRequerimientosRepositorio.deleteById(id);
    }
}
