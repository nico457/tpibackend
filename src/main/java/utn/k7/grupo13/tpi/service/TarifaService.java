package utn.k7.grupo13.tpi.service;

import utn.k7.grupo13.tpi.domain.Alquiler;
import utn.k7.grupo13.tpi.domain.Tarifa;

import java.util.Map;

public interface TarifaService {
    public double calcularTarifa(Alquiler alquiler, Tarifa tarifa);
    public Tarifa getTarifa();
}
