package sb.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.backend.excepcion.RecursoNoEncontradoExcepcion;
import sb.backend.modelo.CE_Hoja_Requerimientos;
import sb.backend.servicio.CE_Hoja_RequerimientosServicio;
import sb.backend.servicio.ICE_Hoja_RequerimientosServicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gestion_app")
@CrossOrigin(value = "http://localhost:4200")
public class CE_Hoja_RequerimientosControlador {
    private static final Logger logger = LoggerFactory.getLogger(CE_Hoja_RequerimientosControlador.class);

    @Autowired
    private CE_Hoja_RequerimientosServicio hojaRequerimientosServicio;

    @GetMapping("/hojas_requerimientos")
    public List<CE_Hoja_Requerimientos> obtenerHojasRequerimientos() {
        List<CE_Hoja_Requerimientos> hojas = hojaRequerimientosServicio.listarHojaRequerimientos();
        logger.info("Hojas de requerimientos obtenidas");
        hojas.forEach(hoja -> logger.info(hoja.toString()));
        return hojas;
    }

    @PostMapping("/hojas_requerimientos")
    public CE_Hoja_Requerimientos agregarHojaRequerimientos(@RequestBody CE_Hoja_Requerimientos hoja) {
        logger.info("Hoja de requerimientos a agregar " + hoja);
        return hojaRequerimientosServicio.guardarHojaRequerimientos(hoja);
    }

    @GetMapping("/hojas_requerimientos/{id}")
    public ResponseEntity<CE_Hoja_Requerimientos> obtenerHojaRequerimientosPorId(@PathVariable int id) {
        CE_Hoja_Requerimientos hoja = hojaRequerimientosServicio.buscarHojaRequerimientosPorId(id);
        if (hoja != null) {
            return ResponseEntity.ok(hoja);
        } else {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
    }

    @PutMapping("/hojas_requerimientos/{id}")
    public ResponseEntity<CE_Hoja_Requerimientos> actualizarHojaRequerimientos(@PathVariable int id, @RequestBody CE_Hoja_Requerimientos hojaRecibida) {
        CE_Hoja_Requerimientos hoja = hojaRequerimientosServicio.buscarHojaRequerimientosPorId(id);
        if (hoja == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
        hoja.setDescripcionR(hojaRecibida.getDescripcionR());
        hoja.setCantidadR(hojaRecibida.getCantidadR());
        hoja.setCalidadProd(hojaRecibida.getCalidadProd());
        hoja.setReglas(hojaRecibida.getReglas());
        hoja.setCodigoProd(hojaRecibida.getCodigoProd());
        hojaRequerimientosServicio.guardarHojaRequerimientos(hoja);
        return ResponseEntity.ok(hoja);
    }

    @DeleteMapping("/hojas_requerimientos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarHojaRequerimientos(@PathVariable int id) {
        CE_Hoja_Requerimientos hoja = hojaRequerimientosServicio.buscarHojaRequerimientosPorId(id);
        if (hoja == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
        hojaRequerimientosServicio.eliminarHojaRequerimientosPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

