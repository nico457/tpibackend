package utn.k7.grupo13.tpi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "alquileres")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String idCliente;
    private int estado;


    @OneToOne
    @JoinColumn(name = "estacion_retiro")
    private Estacion estacionRetiro;


    @OneToOne
    @JoinColumn(name = "estacion_devolucion")
    private Estacion estacionDevolucion;
    private LocalDate fechaHoraRetiro;
    private LocalDate fechaHoraDevolucion;
    private double monto;

    @OneToOne
    @JoinColumn(name = "id_tarifa")
    private Tarifa idTarifa;

    public Alquiler(String idCliente, int estado, Estacion estacionRetiro, Estacion estacionDevolucion, LocalDate fechaHoraRetiro, LocalDate fechaHoraDevolucion, double monto, Tarifa idTarifa) {
        this.idCliente = idCliente;
        this.estado = estado;
        this.estacionRetiro = estacionRetiro;
        this.estacionDevolucion = estacionDevolucion;
        this.fechaHoraRetiro = fechaHoraRetiro;
        this.fechaHoraDevolucion = fechaHoraDevolucion;
        this.monto = monto;
        this.idTarifa = idTarifa;
    }



}
