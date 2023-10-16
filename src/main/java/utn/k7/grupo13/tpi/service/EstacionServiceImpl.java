package utn.k7.grupo13.tpi.service;

import org.springframework.stereotype.Service;
import utn.k7.grupo13.tpi.domain.Estacion;
import utn.k7.grupo13.tpi.repository.EstacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionServiceImpl implements EstacionService{
    private EstacionRepository estacionRepository;

    public EstacionServiceImpl(EstacionRepository estacionRepository) {
        this.estacionRepository = estacionRepository;
    }

    public Optional<List<Estacion>> getAllEstaciones() {
        System.out.println(estacionRepository.findAll());
        return Optional.of(estacionRepository.findAll());

    }

    @Override
    public Optional<Estacion>publicarEstacion(String nombre, double latitud, double longitud) {
        Estacion estacion = new Estacion(nombre, latitud, longitud);
        return Optional.of(estacionRepository.save(estacion));
    }

    @Override
    public Optional<Estacion> getEstacionById(Long id) {
        return Optional.of(estacionRepository.findById(id).get());
    }

    @Override
    public double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        //distancia euclidea
        return Math.sqrt(Math.pow(lat2-lat1,2)+Math.pow(lon2-lon1,2));
    }

}
