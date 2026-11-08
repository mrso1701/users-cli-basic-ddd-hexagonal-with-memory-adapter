package com.jcaa.udec.collections.application.service.ports.in;

import java.util.List;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public interface ListarVehiculosUseCase {
    List<Vehiculo> obtenerTodos();
}
