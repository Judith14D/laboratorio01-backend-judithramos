package pe.edu.examen.laboratorio01_backend_judithramos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.examen.laboratorio01_backend_judithramos.dto.VehiculosRequestDTO;
import pe.edu.examen.laboratorio01_backend_judithramos.dto.VehiculosResponseDTO;
import pe.edu.examen.laboratorio01_backend_judithramos.service.VehiculosService;

import java.io.IOException;


@RestController
@RequestMapping("/vehiculos")
public class VehiculosController {

    @Autowired
    VehiculosService vehiculoService;

    @PostMapping("/busqueda")
    public VehiculosResponseDTO busqueda(@RequestBody VehiculosRequestDTO vehiculosRequestDTO) {

        try {
            String[] datosVehiculo = vehiculoService.buscarVehiculos(vehiculosRequestDTO);
            if(datosVehiculo == null){
                return new VehiculosResponseDTO("01", "Error: Vehículo no encontrado", "", "", 0, 0.0, "");
            }
            return new VehiculosResponseDTO("00", "", datosVehiculo[0], datosVehiculo[1], Integer.parseInt(datosVehiculo[2]), Double.parseDouble(datosVehiculo[3]), datosVehiculo[4]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new VehiculosResponseDTO("99", "Error: Ocurrió un problema", "", "", 0, 0.0, "");
        }
    }
}