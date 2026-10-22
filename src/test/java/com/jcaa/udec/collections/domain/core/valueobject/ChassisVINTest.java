package com.jcaa.udec.collections.domain.core.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.jcaa.udec.collections.domain.core.exception.InvalidVINException;

class ChassisVINTest {
    @Test
    void debeLanzarExcepcionSiElVINNoTieneExactamente17Caracteres() {
        assertThrows(InvalidVINException.class, () -> new ChassisVIN("VIN_CORTO_123"));
    }

    @Test
    void debeCrearInstanciaValidaYConvertirAMayusculas() {
        ChassisVIN vin = new ChassisVIN("1fa6p8cf0h5500000");
        assertEquals("1FA6P8CF0H5500000", vin.getValue());
    }
}
