package utn.k7.grupo13.tpi.service;

import org.springframework.stereotype.Service;
import utn.k7.grupo13.tpi.domain.Alquiler;
import utn.k7.grupo13.tpi.domain.EstadoAlquiler;
import utn.k7.grupo13.tpi.domain.Tarifa;
import utn.k7.grupo13.tpi.repository.AlquilerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AlquilerServiceImpl implements AlquilerService{

    private AlquilerRepository alquilerRepository;
    private EstacionService estacionService;
    private TarifaService tarifaService;
    public AlquilerServiceImpl(AlquilerRepository alquilerRepository, EstacionService estacionService,TarifaService tarifaService){
        this.alquilerRepository = alquilerRepository;
        this.estacionService = estacionService;
        this.tarifaService = tarifaService;
    }


    @Override
    public Optional<Alquiler> alquilarBicicleta(Long idEstacionRetiro, String idCliente) {

        Alquiler alquiler = new Alquiler(idCliente,
                EstadoAlquiler.INICIADO.getValor(),
                estacionService.getEstacionById(idEstacionRetiro).get(),
                LocalDateTime.now(), null,
                0,
                null);
        return Optional.of(alquilerRepository.save(alquiler));

    }

    @Override
    public Optional<Alquiler> devolverBicicleta(Long idEstacion, Long idAlquiler) {
        Tarifa tarifa = tarifaService.getTarifa();
        Alquiler alquiler = alquilerRepository.findById(idAlquiler).get();
        alquiler.setEstacionDevolucion(estacionService.getEstacionById(idEstacion).get());
        alquiler.setFechaHoraDevolucion(LocalDateTime.now());
        alquiler.setEstado(EstadoAlquiler.FINALIZADO.getValor());
        alquiler.setMonto(tarifaService.calcularTarifa(alquiler,tarifa));
        alquiler.setIdTarifa(tarifa);
        return Optional.of(alquilerRepository.save(alquiler));
    }

    @Override
    public Optional<List<Alquiler>> getAlquileresEstacion(Long id) {
        return Optional.of(alquilerRepository.findByEstacionRetiroId(id));
    }


}

