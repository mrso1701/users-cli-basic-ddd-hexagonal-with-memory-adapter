package com.jcaa.udec.collections.domain.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;
import com.jcaa.udec.collections.domain.core.model.VentaAggregate;
import com.jcaa.udec.collections.domain.core.valueobject.ChassisVIN;
import com.jcaa.udec.collections.domain.core.valueobject.Money;
import com.jcaa.udec.collections.domain.core.service.CalculadorDescuentoService;

class CalculadorDescuentoServiceTest {
    @Test
    void debeCalcularCorrectamenteElMontoFinalConDescuento() {
        ChassisVIN vin = new ChassisVIN("1FA6P8CF0H5500000");
        Money precioBase = new Money(new BigDecimal("100000000"), "COP");
        Vehiculo vehiculo = new Vehiculo(vin, precioBase);
        VentaAggregate venta = new VentaAggregate("V-001", vehiculo, "123456789");

        CalculadorDescuentoService servicio = new CalculadorDescuentoService();
        
        // Aplica un 10% de descuento sobre 100,000,000 COP
        Money montoFinal = servicio.aplicarDescuentoEspecial(venta, new BigDecimal("10"));

        assertEquals(0, new BigDecimal("90000000.00").compareTo(montoFinal.getAmount()));
    }
}
