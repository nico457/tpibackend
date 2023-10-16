package utn.k7.grupo13.tpi.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import utn.k7.grupo13.tpi.domain.Estacion;
import utn.k7.grupo13.tpi.domain.Tarifa;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class AlquilerResponse {
    private Long id;
    private String idCliente;
    private int estado;


    private Long estacionRetiro;

    private Long estacionDevolucion;
    private LocalDateTime fechaHoraRetiro;
    private LocalDateTime fechaHoraDevolucion;
    private double monto;
    private Long idTarifa;
}
