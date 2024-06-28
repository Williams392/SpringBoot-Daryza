package sb.backend.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.backend.modelo.CE_Almacenero;
import sb.backend.repositorio.CE_AlmaceneroRepositorio;

import java.util.List;

@Service
public class CE_AlmaceneroServicio implements ICE_AlmaceneroServicio {

    @Autowired
    private CE_AlmaceneroRepositorio almaceneroRepositorio;

    @Override
    public List<CE_Almacenero> listarAlmaceneros() {
        return this.almaceneroRepositorio.findAll();
    }

    @Override
    public CE_Almacenero buscarAlmaceneroPorId(Integer id) {
        return this.almaceneroRepositorio.findById(id).orElse(null);
    }

    @Override
    public CE_Almacenero guardarAlmacenero(CE_Almacenero almacenero) {
        return this.almaceneroRepositorio.save(almacenero);
    }

    @Override
    public void eliminarAlmaceneroPorId(Integer id) {
        this.almaceneroRepositorio.deleteById(id);
    }
}

