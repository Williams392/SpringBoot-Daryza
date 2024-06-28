package sb.backend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.backend.excepcion.RecursoNoEncontradoExcepcion;
import sb.backend.modelo.CE_Producto;
import sb.backend.servicio.CE_ProductoServicio;
import sb.backend.servicio.ICE_ProductoServicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gestion_app")
@CrossOrigin(value = "http://localhost:4200")
public class CE_ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(CE_ProductoControlador.class);

    @Autowired
    private CE_ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<CE_Producto> obtenerProductos() {
        List<CE_Producto> productos = productoServicio.listarProductos();
        logger.info("Productos obtenidos");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping("/productos")
    public CE_Producto agregarProducto(@RequestBody CE_Producto producto) {
        logger.info("Producto a agregar " + producto);
        return productoServicio.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<CE_Producto> obtenerProductoPorId(@PathVariable int id) {
        CE_Producto producto = productoServicio.buscarProductoPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<CE_Producto> actualizarProducto(@PathVariable int id, @RequestBody CE_Producto productoRecibido) {
        CE_Producto producto = productoServicio.buscarProductoPorId(id);
        if (producto == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
        producto.setNombreProd(productoRecibido.getNombreProd());
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setCantidadExistencia(productoRecibido.getCantidadExistencia());
        producto.setPrecioProd(productoRecibido.getPrecioProd());
        producto.setCalidadP(productoRecibido.getCalidadP());
        producto.setCodRequer(productoRecibido.getCodRequer());
        producto.setAlmacenero(productoRecibido.getAlmacenero());
        producto.setCategoria(productoRecibido.getCategoria());
        producto.setUbicacion(productoRecibido.getUbicacion());
        productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id) {
        CE_Producto producto = productoServicio.buscarProductoPorId(id);
        if (producto == null) {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        }
        productoServicio.eliminarProductoPorId(id);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
