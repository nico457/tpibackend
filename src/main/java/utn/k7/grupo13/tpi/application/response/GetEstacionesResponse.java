package utn.k7.grupo13.tpi.application.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class GetEstacionesResponse {
    private Long id;
    private String nombre;
    private LocalDate fechaHoraCreacion;
    private double latitud;
    private double longitud;
}
