package utn.k7.grupo13.tpi.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.k7.grupo13.tpi.application.ResponseHandler;
import utn.k7.grupo13.tpi.domain.Estacion;
import utn.k7.grupo13.tpi.service.EstacionService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estacion")
public class EstacionController {


    private EstacionService estacionService;

    public EstacionController(EstacionService estacionService) {
        this.estacionService = estacionService;
    }




    @GetMapping
    public ResponseEntity<Object> getAllEstaciones() {

        Optional<List<Estacion>> estaciones = estacionService.getAllEstaciones();
        if (estaciones.isPresent()) {
            return ResponseHandler.success(estaciones.get());
        } else {
            return ResponseHandler.notFound("No se encontraron estaciones");
        }
    }
    @PostMapping
    public ResponseEntity<Object> publicarEstacion(@RequestBody Estacion estacion) {
        Optional<Estacion> estacionPublicada = estacionService.publicarEstacion(estacion);
        if (estacionPublicada.isPresent()) {
            return ResponseHandler.created(estacionPublicada.get());
        } else {
            return ResponseHandler.badRequest("No se pudo publicar la estacion");
        }
    }

}
