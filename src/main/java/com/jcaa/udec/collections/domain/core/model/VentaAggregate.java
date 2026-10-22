package com.jcaa.udec.collections.domain.core.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jcaa.udec.collections.domain.core.exception.VehiculoNoDisponibleException;
import com.jcaa.udec.collections.domain.core.valueobject.Money;

public class VentaAggregate {
    private final String idVenta;
    private final Vehiculo vehiculo;
    private final String nifCliente;
    private final List<Money> extras;
    private Money montoTotal;

    public VentaAggregate(String idVenta, Vehiculo vehiculo, String nifCliente) {
        if ("VENDIDO".equals(vehiculo.getEstado())) {
            throw new VehiculoNoDisponibleException("No se puede iniciar una venta con un vehículo vendido.");
        }
        this.idVenta = idVenta;
        this.vehiculo = vehiculo;
        this.nifCliente = nifCliente;
        this.extras = new ArrayList<>();
        this.montoTotal = vehiculo.getPrecioBase();
    }

    // Método que hace cumplir la invariante (Pregunta 24)
    public void agregarExtra(Money precioExtra) {
        if ("VENDIDO".equals(this.vehiculo.getEstado())) {
            throw new VehiculoNoDisponibleException("No se pueden añadir extras opcionales a un vehículo ya vendido.");
        }
        if (precioExtra == null) {
            throw new IllegalArgumentException("El precio del extra no puede ser nulo.");
        }
        this.extras.add(precioExtra);
        // Recalcula automáticamente para mantener la consistencia financiera
        this.montoTotal = this.montoTotal.add(precioExtra);
    }

    public void finalizarVenta() {
        this.vehiculo.marcarComoVendido();
    }

    public String getIdVenta() { return idVenta; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public Money getMontoTotal() { return montoTotal; }
    public List<Money> getExtras() { return Collections.unmodifiableList(extras); }
}
