package sb.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.backend.modelo.CE_Almacen;
import sb.backend.servicio.CE_AlmacenServicio;
import sb.backend.excepcion.RecursoNoEncontradoExcepcion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gestion_app")
@CrossOrigin(value = "http://localhost:4200")
public class CE_AlmacenControlador {
    private static final Logger logger = LoggerFactory.getLogger(CE_AlmacenControlador.class);

    @Autowired
    private CE_AlmacenServicio almacenServicio;

    @GetMapping("/almacenes")
    public List<CE_Almacen> obtenerAlmacenes() {
        List<CE_Almacen> almacenes = almacenServicio.listarAlmacenes();
        logger.info("Almacenes obtenidos");
        almacenes.forEach(almacen -> logger.info(almacen.toString()));
        return almacenes;
    }

    @PostMapping("/almacenes")
    public CE_Almacen agregarAlmacen(@RequestBody CE_Almacen almacen) {
        logger.info("Almacen a agregar " + almacen);
        return almacenServicio.guardarAlmacen(almacen);
    }

    @GetMapping("/almacenes/{id}")
    public ResponseEntity<CE_Almacen> obtenerAlmacenPorId(@PathVariable int id) {
        CE_Almacen almacen = almacenServicio.buscarAlmacenPorId(id);
        if (almacen != null) {
            return ResponseEntity.ok(almacen);
        } else {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
    }

    @PutMapping("/almacenes/{id}")
    public ResponseEntity<CE_Almacen> actualizarAlmacen(@PathVariable int id, @RequestBody CE_Almacen almacenRecibido) {
        CE_Almacen almacen = almacenServicio.buscarAlmacenPorId(id);
        if (almacen == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
        almacen.setNom_Almacen(almacenRecibido.getNom_Almacen());
        almacen.setUbi_Almacen(almacenRecibido.getUbi_Almacen());
        almacenServicio.guardarAlmacen(almacen);
        return ResponseEntity.ok(almacen);
    }

    @DeleteMapping("/almacenes/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarAlmacen(@PathVariable int id) {
        CE_Almacen almacen = almacenServicio.buscarAlmacenPorId(id);
        if (almacen == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
        almacenServicio.eliminarAlmacenPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}