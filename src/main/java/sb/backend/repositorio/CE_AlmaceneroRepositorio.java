package sb.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.backend.modelo.CE_Almacenero;

@Repository
public interface CE_AlmaceneroRepositorio extends JpaRepository<CE_Almacenero, Integer> {
}