package sb.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.backend.modelo.CE_Producto;
import sb.backend.repositorio.CE_ProductoRepositorio;

import java.util.List;

@Service
public class CE_ProductoServicio implements ICE_ProductoServicio {

    @Autowired
    private CE_ProductoRepositorio productoRepositorio;

    @Override
    public List<CE_Producto> listarProductos() {
        return this.productoRepositorio.findAll();
    }

    @Override
    public CE_Producto buscarProductoPorId(Integer id) {
        return this.productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public CE_Producto guardarProducto(CE_Producto producto) {
        return this.productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProductoPorId(Integer id) {
        this.productoRepositorio.deleteById(id);
    }
}

