package com.jcaa.udec.collections.application.service.ports.in;

import com.jcaa.udec.collections.domain.core.model.VentaAggregate;

public interface ConsolidarVentaUseCase {
    VentaAggregate ejecutarVenta(String idVenta, String vinText, String clienteNif);
}
