package com.jcaa.udec.collections.domain.core.specification;

import java.math.BigDecimal;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public class VehiculoAptoParaVentaSpecification {
    public boolean isSatisfiedBy(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return false;
        }
        
        boolean esDisponible = "DISPONIBLE".equalsIgnoreCase(vehiculo.getEstado());
        boolean tienePrecioValido = vehiculo.getPrecioBase() != null 
                && vehiculo.getPrecioBase().getAmount().compareTo(BigDecimal.ZERO) > 0;

        return esDisponible && tienePrecioValido;
    }
}
