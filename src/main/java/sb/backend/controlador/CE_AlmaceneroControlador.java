package sb.backend.controlador;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sb.backend.excepcion.RecursoNoEncontradoExcepcion;
import sb.backend.modelo.CE_Almacenero;
import sb.backend.servicio.CE_AlmaceneroServicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("gestion_app")
@CrossOrigin(value = "http://localhost:4200")
public class CE_AlmaceneroControlador {
    private static final Logger logger = LoggerFactory.getLogger(CE_AlmaceneroControlador.class);

    @Autowired
    private CE_AlmaceneroServicio almaceneroServicio;

    @GetMapping("/almaceneros")
    public List<CE_Almacenero> obtenerAlmaceneros() {
        List<CE_Almacenero> almaceneros = almaceneroServicio.listarAlmaceneros();
        logger.info("Almaceneros obtenidos");
        almaceneros.forEach(almacenero -> logger.info(almacenero.toString()));
        return almaceneros;
    }

    @PostMapping("/almaceneros")
    public CE_Almacenero agregarAlmacenero(@RequestBody CE_Almacenero almacenero) {
        logger.info("Almacenero a agregar " + almacenero);
        return almaceneroServicio.guardarAlmacenero(almacenero);
    }

    @GetMapping("/almaceneros/{id}")
    public ResponseEntity<CE_Almacenero> obtenerAlmaceneroPorId(@PathVariable int id) {
        CE_Almacenero almacenero = almaceneroServicio.buscarAlmaceneroPorId(id);
        if (almacenero != null) {
            return ResponseEntity.ok(almacenero);
        } else {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
    }

    @PutMapping("/almaceneros/{id}")
    public ResponseEntity<CE_Almacenero> actualizarAlmacenero(@PathVariable int id, @RequestBody CE_Almacenero almaceneroRecibido) {
        CE_Almacenero almacenero = almaceneroServicio.buscarAlmaceneroPorId(id);
        if (almacenero == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
        almacenero.setNombEmpleado(almaceneroRecibido.getNombEmpleado());
        almacenero.setCargo(almaceneroRecibido.getCargo());
        almaceneroServicio.guardarAlmacenero(almacenero);
        return ResponseEntity.ok(almacenero);
    }

    @DeleteMapping("/almaceneros/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarAlmacenero(@PathVariable int id) {
        CE_Almacenero almacenero = almaceneroServicio.buscarAlmaceneroPorId(id);
        if (almacenero == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
        almaceneroServicio.eliminarAlmaceneroPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

