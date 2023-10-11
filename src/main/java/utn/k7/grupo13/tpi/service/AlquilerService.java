package utn.k7.grupo13.tpi.service;

import utn.k7.grupo13.tpi.domain.Alquiler;

import java.util.Optional;

public interface AlquilerService {
    public Optional<Alquiler> alquilarBicicleta(Long idEstacion, String idCliente, Long idEstacionDevolucion);
}
