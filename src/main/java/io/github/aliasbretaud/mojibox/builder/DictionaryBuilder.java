package io.github.aliasbretaud.mojibox.builder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.aliasbretaud.mojibox.data.DictionaryData;

import java.io.IOException;
import java.net.URL;

public class DictionaryBuilder {

    private final URL dictionary;

    private final ObjectMapper objectMapper;

    public DictionaryBuilder(URL dictionary) {
        this.dictionary = dictionary;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public DictionaryData generateData() throws IOException {
        return this.objectMapper.readValue(this.dictionary, DictionaryData.class);
    }
}
