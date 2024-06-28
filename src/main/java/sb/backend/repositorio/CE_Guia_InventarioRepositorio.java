package sb.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.backend.modelo.CE_Guia_Inventario;

@Repository
public interface CE_Guia_InventarioRepositorio extends JpaRepository<CE_Guia_Inventario, Integer> {
}