package com.jcaa.udec.collections.domain.core.model;

import com.jcaa.udec.collections.domain.core.exception.VehiculoNoDisponibleException;
import com.jcaa.udec.collections.domain.core.valueobject.ChassisVIN;
import com.jcaa.udec.collections.domain.core.valueobject.Money;

public class Vehiculo {
    private final ChassisVIN vin;
    private final Money precioBase;
    private String estado; // "DISPONIBLE", "VENDIDO"

    public Vehiculo(ChassisVIN vin, Money precioBase) {
        if (vin == null || precioBase == null) {
            throw new IllegalArgumentException("El VIN y el precio base son obligatorios.");
        }
        this.vin = vin;
        this.precioBase = precioBase;
        this.estado = "DISPONIBLE";
    }

    public void marcarComoVendido() {
        if ("VENDIDO".equals(this.estado)) {
            throw new VehiculoNoDisponibleException("El vehículo con VIN " + vin.getValue() + " ya ha sido vendido.");
        }
        this.estado = "VENDIDO";
    }

    public ChassisVIN getVin() { return vin; }
    public Money getPrecioBase() { return precioBase; }
    public String getEstado() { return estado; }
}
