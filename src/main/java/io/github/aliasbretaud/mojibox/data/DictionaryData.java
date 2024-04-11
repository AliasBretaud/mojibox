package io.github.aliasbretaud.mojibox.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DictionaryData {

    private Metadata metadata;

    @JsonDeserialize(as = HashMap.class)
    private Map<String, Kanji> kanjis;

}
