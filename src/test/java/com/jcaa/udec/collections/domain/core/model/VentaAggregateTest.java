package com.jcaa.udec.collections.domain.core.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.jcaa.udec.collections.domain.core.exception.VehiculoNoDisponibleException;
import com.jcaa.udec.collections.domain.core.valueobject.ChassisVIN;
import com.jcaa.udec.collections.domain.core.valueobject.Money;

 class VentaAggregateTest {
    @Test
    void noDebePermitirIniciarUnaVentaSiElVehiculoYaEstaVendido() {
        ChassisVIN vin = new ChassisVIN("1FA6P8CF0H5500000");
        Money precioBase = new Money(new BigDecimal("50000000"), "COP");
        Vehiculo vehiculo = new Vehiculo(vin, precioBase);

        // Se marca previamente el vehículo como vendido
        vehiculo.marcarComoVendido();

        // Verifica que la Raíz de Agregado proteja la invariante lanzando la excepción de dominio
        assertThrows(VehiculoNoDisponibleException.class, () -> 
            new VentaAggregate("V-001", vehiculo, "123456789")
        );
    }
}
