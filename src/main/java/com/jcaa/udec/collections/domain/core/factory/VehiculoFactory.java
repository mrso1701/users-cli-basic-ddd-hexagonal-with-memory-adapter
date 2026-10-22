package com.jcaa.udec.collections.domain.core.factory;

import java.math.BigDecimal;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;
import com.jcaa.udec.collections.domain.core.valueobject.ChassisVIN;
import com.jcaa.udec.collections.domain.core.valueobject.Money;

public class VehiculoFactory {
    private VehiculoFactory() {}

    public static Vehiculo crearVehiculoNuevo(String vinString, BigDecimal precioBaseMonto, String moneda) {
        ChassisVIN vin = new ChassisVIN(vinString);
        Money precioBase = new Money(precioBaseMonto, moneda);
        
        return new Vehiculo(vin, precioBase);
    }
}
