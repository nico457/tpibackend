package utn.k7.grupo13.tpi.service;


import org.springframework.stereotype.Service;
import utn.k7.grupo13.tpi.domain.Alquiler;
import utn.k7.grupo13.tpi.domain.Tarifa;
import utn.k7.grupo13.tpi.repository.TarifaRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
@Service
public class TarifaServiceImpl implements TarifaService{
    private TarifaRepository tarifaRepository;


    public TarifaServiceImpl(TarifaRepository tarifaRepository) {
        this.tarifaRepository = tarifaRepository;
    }


    public Tarifa getTarifa(){
        LocalDateTime fecha_actual = LocalDateTime.now();
        //Obtener tarifa segun si es normal o con descuento
        Optional<Tarifa> optionalTarifa =tarifaRepository.getTarifaByDiaMesAndMesAndAnio(fecha_actual.getDayOfMonth()
                ,fecha_actual.getMonth().getValue(),fecha_actual.getYear());
        if(optionalTarifa.isPresent()){
            return optionalTarifa.get();
        }else {
            return tarifaRepository.getTarifaByDiaSemana(fecha_actual.getDayOfWeek().getValue());

        }
    }
    public double calcularTarifa(Alquiler alquiler, Tarifa tarifa) {
        LocalDateTime fecha_actual = LocalDateTime.now();
        Duration duracion = Duration.between(fecha_actual, alquiler.getFechaHoraRetiro());

       //cantidad de horas y minutos que duro el alquiler
       Long duracion_horas = duracion.toHours();
       Long duracion_minutos = duracion.toMinutes()- (duracion_horas*60);

       //Tarifas
       double tarifa_total = 0;



        //monto fijo
        tarifa_total += tarifa.getMontoFijoAlquiler();

        //monto por hora y minutos
        if(duracion_minutos >= 31 ){
            tarifa_total += tarifa.getMontoHora() * (duracion_horas + 1);


        }else {
            tarifa_total += tarifa.getMontoHora() * duracion_horas;
            tarifa_total += tarifa.getMontoMinutoFraccion() * duracion_minutos;
        }

        //falta calcular el monto por km

        return tarifa_total;
    }


}
