package com.jcaa.udec.collections.domain.core.valueobject;

import java.util.Objects;

import com.jcaa.udec.collections.domain.core.exception.InvalidVINException;

public final class ChassisVIN {
    private final String value;

    public ChassisVIN(String value) {
        if (value == null || value.trim().length() != 17) {
            throw new InvalidVINException("El número de bastidor (VIN) debe tener exactamente 17 caracteres.");
        }
        this.value = value.trim().toUpperCase();
    }

    public String getValue() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChassisVIN that = (ChassisVIN) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }
}
