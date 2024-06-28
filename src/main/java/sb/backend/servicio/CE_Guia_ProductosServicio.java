package sb.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.backend.modelo.CE_Guia_Productos;
import sb.backend.repositorio.CE_Guia_ProductosRepositorio;

import java.util.List;

@Service
public class CE_Guia_ProductosServicio implements ICE_Guia_ProductosServicio {

    @Autowired
    private CE_Guia_ProductosRepositorio guiaProductosRepositorio;

    @Override
    public List<CE_Guia_Productos> listarGuiasProductos() {
        return this.guiaProductosRepositorio.findAll();
    }

    @Override
    public CE_Guia_Productos buscarGuiaProductosPorId(Integer id) {
        return this.guiaProductosRepositorio.findById(id).orElse(null);
    }

    @Override
    public CE_Guia_Productos guardarGuiaProductos(CE_Guia_Productos guiaProductos) {
        return this.guiaProductosRepositorio.save(guiaProductos);
    }

    @Override
    public void eliminarGuiaProductosPorId(Integer id) {
        this.guiaProductosRepositorio.deleteById(id);
    }
}
