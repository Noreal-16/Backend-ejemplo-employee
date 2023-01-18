package com.example.pruebarelaciones.Utils;

import org.modelmapper.ModelMapper;

public class Mapper {
    private Mapper() {
        throw new IllegalStateException("Utility Class");
    }

    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
