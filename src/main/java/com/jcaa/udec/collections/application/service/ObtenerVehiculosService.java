package com.jcaa.udec.collections.application.service;

import java.util.List;
import java.util.Optional;

import com.jcaa.udec.collections.adapter.persistence.memory.GuardarVehiculoAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.ObtenerVehiculosAdapter;
import com.jcaa.udec.collections.application.service.ports.in.ListarVehiculosUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerVehiculoPorVinUseCase;
import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public class ObtenerVehiculosService implements ObtenerVehiculoPorVinUseCase, ListarVehiculosUseCase {
    private final GuardarVehiculoAdapter guardarAdapter;
    private final ObtenerVehiculosAdapter obtenerAdapter;

    public ObtenerVehiculosService(GuardarVehiculoAdapter guardarAdapter, ObtenerVehiculosAdapter obtenerAdapter) {
        this.guardarAdapter = guardarAdapter;
        this.obtenerAdapter = obtenerAdapter;
    }

    @Override
    public Optional<Vehiculo> obtenerPorVin(String vinText) {
        return guardarAdapter.buscarPorVin(vinText);
    }

    @Override
    public List<Vehiculo> obtenerTodos() {
        return obtenerAdapter.obtenerTodos();
    }
}
