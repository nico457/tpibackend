package utn.k7.grupo13.tpi.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.k7.grupo13.tpi.application.ResponseHandler;
import utn.k7.grupo13.tpi.application.request.Moneda;
import utn.k7.grupo13.tpi.application.request.PUTAlquilerRequest;
import utn.k7.grupo13.tpi.application.request.PostAlquilerRequest;
import utn.k7.grupo13.tpi.application.response.AlquilerResponse;
import utn.k7.grupo13.tpi.domain.Alquiler;
import utn.k7.grupo13.tpi.service.AlquilerService;


import java.util.List;
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
               request.getIdCliente());
         if(alquiler.isPresent()){
             return ResponseHandler.created(new AlquilerResponse(
                     alquiler.get().getId(),
                     alquiler.get().getIdCliente(),
                     alquiler.get().getEstado(),
                     alquiler.get().getEstacionRetiro().getId(),
                     alquiler.get().getEstacionDevolucion().getId(),
                     alquiler.get().getFechaHoraRetiro(),
                     alquiler.get().getFechaHoraDevolucion(),
                     null,
                     alquiler.get().getIdTarifa().getId()
             ));

         }else {
             return ResponseHandler.badRequest("No se pudo crear el alquiler");
         }
    }
    @PutMapping("/{idAlquiler}")
    public ResponseEntity<Object> devolverBicicleta(@PathVariable Long id, @PathVariable Long idAlquiler, @RequestBody(required = false) PUTAlquilerRequest request) {
        Optional<Alquiler> alquiler = alquilerService.devolverBicicleta(id, idAlquiler);
        if(request == null){
            request = new PUTAlquilerRequest(Moneda.ARS);
        }
        double monto =  alquiler.get().getMonto() * request.getMoneda().getValor();
        monto = Math.round(monto * 100.0) / 100.0;
        if(alquiler.isPresent()){
            return ResponseHandler.success(new AlquilerResponse(
                    alquiler.get().getId(),
                    alquiler.get().getIdCliente(),
                    alquiler.get().getEstado(),
                    alquiler.get().getEstacionRetiro().getId(),
                    alquiler.get().getEstacionDevolucion().getId(),
                    alquiler.get().getFechaHoraRetiro(),
                    alquiler.get().getFechaHoraDevolucion(),
                    String.valueOf(monto) +" "+ request.getMoneda(),
                    alquiler.get().getIdTarifa().getId()
            ));

        }else {
            return ResponseHandler.badRequest("No se pudo devolver la bicicleta");
        }
    }
    @GetMapping()
    public ResponseEntity<Object> getAlquileresEstacion(@PathVariable Long id){
        Optional<List<Alquiler>> alquileres = alquilerService.getAlquileresEstacion(id);
        if(alquileres.isPresent()){
            return ResponseHandler.success(alquileres.get());
    }else {
            return ResponseHandler.notFound("No se pudo obtener los alquileres");
        }
}
}
