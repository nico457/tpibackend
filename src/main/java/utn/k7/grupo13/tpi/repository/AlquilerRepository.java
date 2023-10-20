package utn.k7.grupo13.tpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utn.k7.grupo13.tpi.domain.Alquiler;
import utn.k7.grupo13.tpi.domain.EstadoAlquiler;

import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    //metodo para buscar todos los alquileres con una estacion de retiro especifica
    List<Alquiler> findByEstacionRetiroIdAndEstado(Long estacionRetiroId, int estado);
}
