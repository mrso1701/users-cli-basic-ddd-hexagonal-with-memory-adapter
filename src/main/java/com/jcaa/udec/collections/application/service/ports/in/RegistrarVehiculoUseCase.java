package com.jcaa.udec.collections.application.service.ports.in;

import java.math.BigDecimal;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public interface RegistrarVehiculoUseCase {
    Vehiculo registrar(String vinText, BigDecimal precio, String moneda);
}
