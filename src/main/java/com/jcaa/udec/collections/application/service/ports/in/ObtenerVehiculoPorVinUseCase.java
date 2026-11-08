package com.jcaa.udec.collections.application.service.ports.in;

import java.util.Optional;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public interface  ObtenerVehiculoPorVinUseCase {
    Optional<Vehiculo> obtenerPorVin(String vinText);
}
