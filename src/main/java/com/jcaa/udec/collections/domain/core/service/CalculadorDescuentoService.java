package com.jcaa.udec.collections.domain.core.service;

import java.math.BigDecimal;

import com.jcaa.udec.collections.domain.core.model.VentaAggregate;
import com.jcaa.udec.collections.domain.core.valueobject.Money;

public class CalculadorDescuentoService {
   public Money aplicarDescuentoEspecial(VentaAggregate venta, BigDecimal porcentajeDescuento) {
        if (venta == null || porcentajeDescuento == null) {
            throw new IllegalArgumentException("La venta y el porcentaje de descuento son obligatorios.");
        }

        if (porcentajeDescuento.compareTo(BigDecimal.ZERO) < 0 || porcentajeDescuento.compareTo(new BigDecimal("100")) > 0) {
            throw new IllegalArgumentException("El porcentaje de descuento debe estar entre 0 y 100.");
        }

        BigDecimal montoActual = venta.getVehiculo().getPrecioBase().getAmount();
        BigDecimal descuento = montoActual.multiply(porcentajeDescuento).divide(new BigDecimal("100"));
        BigDecimal montoFinal = montoActual.subtract(descuento);

        return new Money(montoFinal, venta.getVehiculo().getPrecioBase().getCurrency());
    }
}
