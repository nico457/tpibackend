package utn.k7.grupo13.tpi.service;

import utn.k7.grupo13.tpi.domain.Estacion;

import java.util.List;
import java.util.Optional;

public interface EstacionService {

    public Optional<List<Estacion>> getAllEstaciones();

    public Optional<Estacion> publicarEstacion(String nombre, double latitud, double longitud);

    public Optional<Estacion> getEstacionById(Long id);

    public double calcularDistancia(double lat1, double lon1, double lat2, double lon2);
}
