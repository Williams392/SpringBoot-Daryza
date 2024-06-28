package sb.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.backend.modelo.CE_Almacen;

@Repository
public interface CE_AlmacenRepositorio extends JpaRepository<CE_Almacen, Integer> {
}