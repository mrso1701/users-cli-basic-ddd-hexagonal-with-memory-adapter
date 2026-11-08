package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;

import java.util.Optional;

import com.jcaa.udec.collections.application.service.ports.out.VehiculoRepositoryPort;

public class GuardarVehiculoAdapter implements VehiculoRepositoryPort {
    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        VehiculosMemoria.VEHICULOS.removeIf(v -> v.getVin().getValue().equalsIgnoreCase(vehiculo.getVin().getValue()));
        VehiculosMemoria.VEHICULOS.add(vehiculo);
        return vehiculo;
    }

    @Override
    public Optional<Vehiculo> buscarPorVin(String vinText) {
        return VehiculosMemoria.VEHICULOS.stream()
                .filter(v -> v.getVin().getValue().equalsIgnoreCase(vinText.trim()))
                .findFirst();
    }
}
