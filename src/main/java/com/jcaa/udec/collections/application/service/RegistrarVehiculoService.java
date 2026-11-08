package com.jcaa.udec.collections.application.service;

import java.math.BigDecimal;

import com.jcaa.udec.collections.application.service.ports.in.RegistrarVehiculoUseCase;
import com.jcaa.udec.collections.application.service.ports.out.VehiculoRepositoryPort;
import com.jcaa.udec.collections.domain.core.model.Vehiculo;
import com.jcaa.udec.collections.domain.core.valueobject.ChassisVIN;
import com.jcaa.udec.collections.domain.core.valueobject.Money;

public class RegistrarVehiculoService implements RegistrarVehiculoUseCase{
    private final VehiculoRepositoryPort repositoryPort;

    public RegistrarVehiculoService(VehiculoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Vehiculo registrar(String vinText, BigDecimal precio, String moneda) {
        Vehiculo vehiculo = new Vehiculo(new ChassisVIN(vinText), new Money(precio, moneda));
        return repositoryPort.guardar(vehiculo);
    }
}
