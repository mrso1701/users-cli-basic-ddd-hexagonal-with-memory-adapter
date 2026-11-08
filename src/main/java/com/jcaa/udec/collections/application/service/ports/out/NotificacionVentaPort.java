package com.jcaa.udec.collections.application.service.ports.out;

public interface NotificacionVentaPort {
    void enviarComprobante(String clienteNif, String idVenta);
}
