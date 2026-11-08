package com.jcaa.udec.collections.adapter.persistence.memory;

public class EliminarVehiculoAdapter {
    public boolean eliminarPorVin(String vinText) {
        return VehiculosMemoria.VEHICULOS.removeIf(v -> v.getVin().getValue().equalsIgnoreCase(vinText.trim()));
    }
}
