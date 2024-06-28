package sb.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.backend.modelo.CE_Guia_Inventario;
import sb.backend.repositorio.CE_Guia_InventarioRepositorio;

import java.util.List;

@Service
public class CE_Guia_InventarioServicio implements ICE_Guia_InventarioServicio {

    @Autowired
    private CE_Guia_InventarioRepositorio guiaInventarioRepositorio;

    @Override
    public List<CE_Guia_Inventario> listarGuiasInventario() {
        return this.guiaInventarioRepositorio.findAll();
    }

    @Override
    public CE_Guia_Inventario buscarGuiaInventarioPorId(Integer id) {
        return this.guiaInventarioRepositorio.findById(id).orElse(null);
    }

    @Override
    public CE_Guia_Inventario guardarGuiaInventario(CE_Guia_Inventario guiaInventario) {
        return this.guiaInventarioRepositorio.save(guiaInventario);
    }

    @Override
    public void eliminarGuiaInventarioPorId(Integer id) {
        this.guiaInventarioRepositorio.deleteById(id);
    }
}
