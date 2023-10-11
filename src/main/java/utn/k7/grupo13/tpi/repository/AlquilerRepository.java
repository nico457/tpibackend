package utn.k7.grupo13.tpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.k7.grupo13.tpi.domain.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
}
