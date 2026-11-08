package com.jcaa.udec.collections.entrypoint.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.jcaa.udec.collections.application.service.EliminarVehiculoService;
import com.jcaa.udec.collections.application.service.ObtenerVehiculosService;
import com.jcaa.udec.collections.application.service.RegistrarVehiculoService;
import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public class VehiculoControlador {
    private final RegistrarVehiculoService registrarService;
    private final ObtenerVehiculosService obtenerService;
    private final EliminarVehiculoService eliminarService;

    public VehiculoControlador(RegistrarVehiculoService registrarService,
                               ObtenerVehiculosService obtenerService,
                               EliminarVehiculoService eliminarService) {
        this.registrarService = registrarService;
        this.obtenerService = obtenerService;
        this.eliminarService = eliminarService;
    }

    public Vehiculo registrar(String vin, BigDecimal precio, String moneda) {
        return registrarService.registrar(vin, precio, moneda);
    }

    public Optional<Vehiculo> buscarPorVin(String vin) {
        return obtenerService.obtenerPorVin(vin);
    }

    public List<Vehiculo> obtenerTodos() {
        return obtenerService.obtenerTodos();
    }

    public boolean eliminarPorVin(String vin) {
        return eliminarService.eliminarPorVin(vin);
    }
}
