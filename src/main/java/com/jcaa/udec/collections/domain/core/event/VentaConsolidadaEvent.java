package com.jcaa.udec.collections.domain.core.event;

import java.time.Instant;

public class VentaConsolidadaEvent {
    private final String idVenta;
    private final String vinVehiculo;
    private final String nifCliente;
    private final Instant fechaOcurrencia;

    public VentaConsolidadaEvent(String idVenta, String vinVehiculo, String nifCliente) {
        this.idVenta = idVenta;
        this.vinVehiculo = vinVehiculo;
        this.nifCliente = nifCliente;
        this.fechaOcurrencia = Instant.now();
    }

    public String getIdVenta() { return idVenta; }
    public String getVinVehiculo() { return vinVehiculo; }
    public String getNifCliente() { return nifCliente; }
    public Instant getFechaOcurrencia() { return fechaOcurrencia; }
}
