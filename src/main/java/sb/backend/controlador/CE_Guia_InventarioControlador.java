package sb.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.backend.modelo.CE_Guia_Inventario;
import sb.backend.servicio.CE_Guia_InventarioServicio;
import sb.backend.excepcion.RecursoNoEncontradoExcepcion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gestion_app")
@CrossOrigin(value = "http://localhost:4200")
public class CE_Guia_InventarioControlador {

    private static final Logger logger = LoggerFactory.getLogger(CE_Guia_InventarioControlador.class);

    @Autowired
    private CE_Guia_InventarioServicio guiaInventarioServicio;

    @GetMapping("/guia_inventario")
    public ResponseEntity<List<CE_Guia_Inventario>> obtenerGuiasInventario() {
        List<CE_Guia_Inventario> guiasInventario = guiaInventarioServicio.listarGuiasInventario();
        return ResponseEntity.ok(guiasInventario);
    }

    @PostMapping("/guia_inventario")
    public ResponseEntity<CE_Guia_Inventario> agregarGuiaInventario(@RequestBody CE_Guia_Inventario guiaInventario) {
        CE_Guia_Inventario nuevaGuiaInventario = guiaInventarioServicio.guardarGuiaInventario(guiaInventario);
        return ResponseEntity.ok(nuevaGuiaInventario);
    }

    @GetMapping("/guia_inventario/{id}")
    public ResponseEntity<CE_Guia_Inventario> obtenerGuiaInventarioPorId(@PathVariable Integer id) {
        CE_Guia_Inventario guiaInventario = guiaInventarioServicio.buscarGuiaInventarioPorId(id);
        if (guiaInventario != null) {
            return ResponseEntity.ok(guiaInventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/guia_inventario/{id}")
    public ResponseEntity<CE_Guia_Inventario> actualizarGuiaInventario(@PathVariable Integer id, @RequestBody CE_Guia_Inventario guiaInventarioRecibido) {
        CE_Guia_Inventario guiaInventario = guiaInventarioServicio.buscarGuiaInventarioPorId(id);
        if (guiaInventario == null) {
            return ResponseEntity.notFound().build();
        }
        guiaInventario.setDescripcionG(guiaInventarioRecibido.getDescripcionG());
        guiaInventario.setTipoProd(guiaInventarioRecibido.getTipoProd());
        guiaInventario.setCantProdActual(guiaInventarioRecibido.getCantProdActual());
        guiaInventario.setNum_Almacen(guiaInventarioRecibido.getNum_Almacen());
        guiaInventario.setCodigoProd(guiaInventarioRecibido.getCodigoProd());
        CE_Guia_Inventario guiaActualizada = guiaInventarioServicio.guardarGuiaInventario(guiaInventario);
        return ResponseEntity.ok(guiaActualizada);
    }

    @DeleteMapping("/guia_inventario/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarGuiaInventario(@PathVariable Integer id) {
        guiaInventarioServicio.eliminarGuiaInventarioPorId(id);
        Map<String, Boolean> respuesta = Map.of("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

