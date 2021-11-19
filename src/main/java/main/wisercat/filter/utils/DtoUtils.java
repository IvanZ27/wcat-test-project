package main.wisercat.filter.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import main.wisercat.filter.rest.dto.DtoEntity;
import java.io.IOException;
import java.time.LocalDate;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

public class DtoUtils {
    private static final ModelMapper MODEL_MAPPER;
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        MODEL_MAPPER = new ModelMapper();

//        SimpleModule module = new SimpleModule();
//        module.addSerializer(LocalDate.class, new LocalDateSerializer());
//        OBJECT_MAPPER.registerModule(module);
    }

    public static <D extends DtoEntity> D convertToDto(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        }
        return MODEL_MAPPER.map(source, destinationType);
    }

//    public static <D> D convertToEntity(DtoEntity source, Class<D> destinationType) {
//        if (source == null) {
//            return null;
//        }
//        return MODEL_MAPPER.map(source, destinationType);
//    }
//
//    public static String convertToJson(Object obj) {
//        try {
//            return OBJECT_MAPPER.writeValueAsString(obj);
//        } catch (JsonProcessingException e) {
//            // ignored
//            return obj == null ? "null" : obj.toString();
//        }
//    }
//
//    private DtoUtils() {}
//
//    private static class LocalDateSerializer extends StdSerializer<LocalDate> {
//
//        public LocalDateSerializer() {
//            this(null);
//        }
//
//        public LocalDateSerializer(Class<LocalDate> t) {
//            super(t);
//        }
//
//        @Override
//        public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
//            if (value == null) {
//                gen.writeNull();
//                return;
//            }
//            gen.writeStartArray();
//            gen.writeNumber(value.getYear());
//            gen.writeNumber(value.getMonthValue());
//            gen.writeNumber(value.getDayOfMonth());
//            gen.writeEndArray();
//        }
//    }
}
