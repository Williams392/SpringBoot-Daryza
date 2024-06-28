package sb.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.backend.modelo.CE_Hoja_Requerimientos;

@Repository
public interface CE_Hoja_RequerimientosRepositorio extends JpaRepository<CE_Hoja_Requerimientos, Integer> {
}