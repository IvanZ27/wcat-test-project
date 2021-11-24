package main.wisercat.filter.utils;

import org.modelmapper.ModelMapper;

public final class DtoUtils {

    private static final ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ModelMapper();
    }

    public static <T> T convertToDto(Object source, Class<T> destinationType) {
        if (source == null) {
            return null;
        }
        return MODEL_MAPPER.map(source, destinationType);
    }

    private DtoUtils() {
    }

}
