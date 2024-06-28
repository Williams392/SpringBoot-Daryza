package sb.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.backend.modelo.CE_Producto;

@Repository
public interface CE_ProductoRepositorio extends JpaRepository<CE_Producto, Integer> {
}
