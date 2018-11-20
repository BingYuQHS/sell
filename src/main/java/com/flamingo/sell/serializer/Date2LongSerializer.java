package com.flamingo.sell.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Date -> Long
 * 解决后端存的Date(ms)，前端时间戳(s)的问题
 */
public class Date2LongSerializer extends JsonSerializer<Date>{

    /**
     * 复写方法date时间算秒级的时间戳
     * @param date
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        long tsp = date.getTime() / 1000;
        jsonGenerator.writeNumber(tsp);
    }
}
