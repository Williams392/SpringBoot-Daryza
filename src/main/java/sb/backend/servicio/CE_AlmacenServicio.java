package sb.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.backend.modelo.CE_Almacen;
import sb.backend.repositorio.CE_AlmacenRepositorio;

import java.util.List;

@Service
public class CE_AlmacenServicio implements ICE_AlmacenServicio {

    @Autowired
    private CE_AlmacenRepositorio almacenRepositorio;

    @Override
    public List<CE_Almacen> listarAlmacenes() {
        return this.almacenRepositorio.findAll();
    }

    @Override
    public CE_Almacen buscarAlmacenPorId(Integer id) {
        return this.almacenRepositorio.findById(id).orElse(null);
    }

    @Override
    public CE_Almacen guardarAlmacen(CE_Almacen almacen) {
        return this.almacenRepositorio.save(almacen);
    }

    @Override
    public void eliminarAlmacenPorId(Integer id) {
        this.almacenRepositorio.deleteById(id);
    }
}