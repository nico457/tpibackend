package utn.k7.grupo13.tpi.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import utn.k7.grupo13.tpi.domain.Estacion;
import utn.k7.grupo13.tpi.domain.Tarifa;

import java.time.LocalDate;
@Data
@AllArgsConstructor

public class AlquilerResponse {
    private Long id;
    private String idCliente;
    private int estado;


    private Estacion estacionRetiro;

    private Estacion estacionDevolucion;
    private LocalDate fechaHoraRetiro;
    private LocalDate fechaHoraDevolucion;
    private double monto;
    private Tarifa idTarifa;
}
