package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public class GuardarVehiculoAdapter implements VehiculoRepositoryPort {
    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        VehiculosMemoria.VEHICULOS.removeIf(v -> v.getVin().getValue().equalsIgnoreCase(vehiculo.getVin().getValue()));
        VehiculosMemoria.VEHICULOS.add(vehiculo);
        return vehiculo;
    }
}
