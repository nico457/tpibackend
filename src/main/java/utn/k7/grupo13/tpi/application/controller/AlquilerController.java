package utn.k7.grupo13.tpi.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.k7.grupo13.tpi.application.ResponseHandler;
import utn.k7.grupo13.tpi.application.request.PostAlquilerRequest;
import utn.k7.grupo13.tpi.domain.Alquiler;
import utn.k7.grupo13.tpi.service.AlquilerService;
import utn.k7.grupo13.tpi.service.EstacionService;

import java.util.Optional;

@RestController
@RequestMapping("/api/estacion/{id}/alquiler")
public class AlquilerController {
    private AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @PostMapping
    public ResponseEntity<Object> alquilarBicicleta(@PathVariable Long id, @RequestBody PostAlquilerRequest request) {
       Optional<Alquiler> alquiler = alquilerService.alquilarBicicleta(id,
               request.getIdCliente(),
               request.getIdEstacionDevolucion());
         if(alquiler.isPresent()){
             return ResponseHandler.created(alquiler.get());

         }else {
             return ResponseHandler.badRequest("No se pudo crear el alquiler");
         }
    }
}
