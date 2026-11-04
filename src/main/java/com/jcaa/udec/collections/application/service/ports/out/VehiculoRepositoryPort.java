package com.jcaa.udec.collections.application.service.ports.out;
import java.util.Optional;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public interface VehiculoRepositoryPort {
    Vehiculo guardar(Vehiculo vehiculo);
    Optional<Vehiculo> buscarPorVin(String vinText);
}
