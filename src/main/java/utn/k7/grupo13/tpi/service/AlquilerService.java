package utn.k7.grupo13.tpi.service;

import utn.k7.grupo13.tpi.domain.Alquiler;

import java.util.List;
import java.util.Optional;

public interface AlquilerService {
    public Optional<Alquiler> alquilarBicicleta(Long idEstacion, String idCliente);
    public Optional<Alquiler> devolverBicicleta(Long idEstacion, Long idAlquiler);
    public Optional<List<Alquiler>> getAlquileresEstacion(Long id);


}
