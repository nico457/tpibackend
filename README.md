## Endpoints
localhost:3000

A continuación se enumeran los endpoints disponibles en nuestra API:

| Método | Ruta                                  | Descripción                                                                   |
|--------|---------------------------------------|-------------------------------------------------------------------------------|
| GET    | /api/estacion                         | Obtiene todas las estaciones                                                  |
| POST   | /api/estacion                         | Crea una nueva estación                                                       |
| POST   | /api/estacion/{id}/alquiler           | Regsitra un alquiler para una estacion especifica                             |
| PUT    | /api/estacion/{id}/alquiler/{idAlquiler} | Registra la devolucion de un alquiler                                         |
| GET    | /api/estacion/{id}/alquiler | Muestra los alquileres realizados en una estacion especifica (estacionRetiro) |
##Swagger Documentation
http://localhost:3000/swagger-ui/index.html#