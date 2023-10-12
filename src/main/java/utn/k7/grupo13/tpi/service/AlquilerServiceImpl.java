package utn.k7.grupo13.tpi.service;

import org.springframework.stereotype.Service;
import utn.k7.grupo13.tpi.domain.Alquiler;
import utn.k7.grupo13.tpi.domain.EstadoAlquiler;
import utn.k7.grupo13.tpi.repository.AlquilerRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlquilerServiceImpl implements AlquilerService{

    private AlquilerRepository alquilerRepository;
    private EstacionService estacionService;
    public AlquilerServiceImpl(AlquilerRepository alquilerRepository, EstacionService estacionService) {
        this.alquilerRepository = alquilerRepository;
        this.estacionService = estacionService;
    }


    @Override
    public Optional<Alquiler> alquilarBicicleta(Long idEstacionRetiro, String idCliente, Long idEstacionDevolucion) {

        Alquiler alquiler = new Alquiler(idCliente,
                EstadoAlquiler.INICIADO.getValor(),
                estacionService.getEstacionById(idEstacionRetiro).get(),
                estacionService.getEstacionById(idEstacionDevolucion).get(),
                LocalDate.now(), null,
                0,
                null);
        return Optional.of(alquilerRepository.save(alquiler));

    }

    @Override
    public Optional<Alquiler> devolverBicicleta(Long idEstacion, Long idAlquiler) {
        Alquiler alquiler = alquilerRepository.findById(idAlquiler).get();
        //alquiler.setEstacionDevolucion(estacionService.getEstacionById(idEstacion).get());
        alquiler.setFechaHoraDevolucion(LocalDate.now());
        alquiler.setEstado(EstadoAlquiler.FINALIZADO.getValor());
        //alquiler.setMonto(calcularMonto(alquiler));
        return Optional.of(alquilerRepository.save(alquiler));
    }

    @Override
    public Optional<List<Alquiler>> getAlquileresEstacion(Long id) {
        return Optional.of(alquilerRepository.findByEstacionRetiroId(id));
    }


}

