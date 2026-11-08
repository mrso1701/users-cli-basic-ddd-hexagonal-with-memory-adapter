package com.jcaa.udec.collections.application.service;
import com.jcaa.udec.collections.adapter.persistence.memory.EliminarVehiculoAdapter;
import com.jcaa.udec.collections.application.service.ports.in.EliminarVehiculoUseCase;

public class EliminarVehiculoService implements EliminarVehiculoUseCase {
    private final EliminarVehiculoAdapter eliminarAdapter;

    public EliminarVehiculoService(EliminarVehiculoAdapter eliminarAdapter) {
        this.eliminarAdapter = eliminarAdapter;
    }

    @Override
    public boolean eliminarPorVin(String vinText) {
        return eliminarAdapter.eliminarPorVin(vinText);
    }
}
