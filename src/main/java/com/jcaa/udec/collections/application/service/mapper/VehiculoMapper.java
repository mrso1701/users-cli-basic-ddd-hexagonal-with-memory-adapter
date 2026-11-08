package com.jcaa.udec.collections.application.service.mapper;

import java.math.BigDecimal;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;
import com.jcaa.udec.collections.domain.core.valueobject.ChassisVIN;
import com.jcaa.udec.collections.domain.core.valueobject.Money;

public class VehiculoMapper {
    public static Vehiculo toDomain(String vinText, BigDecimal precio, String moneda) {
        return new Vehiculo(
            new ChassisVIN(vinText),
            new Money(precio, moneda)
        );
    }
}
