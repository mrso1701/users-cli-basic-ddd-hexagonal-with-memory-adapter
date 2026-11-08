package com.jcaa.udec.collections.adapter.persistence.memory;

import java.util.ArrayList;
import java.util.List;

import com.jcaa.udec.collections.domain.core.model.Vehiculo;

public class ObtenerVehiculosAdapter {
    public List<Vehiculo> obtenerTodos() {
        return new ArrayList<>(VehiculosMemoria.VEHICULOS);
    }
}
