package pe.edu.examen.laboratorio01_backend_judithramos.service;

import pe.edu.examen.laboratorio01_backend_judithramos.dto.VehiculosRequestDTO;
import pe.edu.examen.laboratorio01_backend_judithramos.dto.VehiculosResponseDTO;

import java.io.IOException;

public interface VehiculosService {
    String[] buscarVehiculos(VehiculosRequestDTO vehiculosRequestDTO) throws IOException;
}