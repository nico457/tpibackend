package utn.k7.grupo13.tpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.k7.grupo13.tpi.domain.Estacion;
@Repository
public interface EstacionRepository extends JpaRepository<Estacion,Long> {
}
