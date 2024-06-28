package sb.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.backend.modelo.CE_Guia_Productos;

import sb.backend.excepcion.RecursoNoEncontradoExcepcion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sb.backend.servicio.CE_Guia_ProductosServicio;
import sb.backend.servicio.CE_ProductoServicio;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gestion_app")
@CrossOrigin(value = "http://localhost:4200")
public class CE_Guia_ProductosControlador {

    private static final Logger logger = LoggerFactory.getLogger(CE_Guia_ProductosControlador.class);

    @Autowired
    private CE_Guia_ProductosServicio guiaProductosServicio;

    @GetMapping("/guia_productos")
    public ResponseEntity<List<CE_Guia_Productos>> obtenerGuiasProductos() {
        List<CE_Guia_Productos> guiasProductos = guiaProductosServicio.listarGuiasProductos();
        return ResponseEntity.ok(guiasProductos);
    }

    @PostMapping("/guia_productos")
    public ResponseEntity<CE_Guia_Productos> agregarGuiaProductos(@RequestBody CE_Guia_Productos guiaProductos) {
        CE_Guia_Productos nuevaGuiaProductos = guiaProductosServicio.guardarGuiaProductos(guiaProductos);
        return ResponseEntity.ok(nuevaGuiaProductos);
    }

    @GetMapping("/guia_productos/{id}")
    public ResponseEntity<CE_Guia_Productos> obtenerGuiaProductosPorId(@PathVariable Integer id) {
        CE_Guia_Productos guiaProductos = guiaProductosServicio.buscarGuiaProductosPorId(id);
        if (guiaProductos != null) {
            return ResponseEntity.ok(guiaProductos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/guia_productos/{id}")
    public ResponseEntity<CE_Guia_Productos> actualizarGuiaProductos(@PathVariable Integer id, @RequestBody CE_Guia_Productos guiaProductosRecibido) {
        CE_Guia_Productos guiaProductos = guiaProductosServicio.buscarGuiaProductosPorId(id);
        if (guiaProductos == null) {
            return ResponseEntity.notFound().build();
        }
        guiaProductos.setDetalleProd(guiaProductosRecibido.getDetalleProd());
        guiaProductos.setNombreProd(guiaProductosRecibido.getNombreProd());
        CE_Guia_Productos guiaActualizada = guiaProductosServicio.guardarGuiaProductos(guiaProductos);
        return ResponseEntity.ok(guiaActualizada);
    }

    @DeleteMapping("/guia_productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarGuiaProductos(@PathVariable Integer id) {
        guiaProductosServicio.eliminarGuiaProductosPorId(id);
        Map<String, Boolean> respuesta = Map.of("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

