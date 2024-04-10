package com.github.aliasbretaud.mojibox;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Kanji implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String literal;

    private Misc misc;

    @JsonDeserialize(as = HashMap.class)
    private Map<ReadingType, List<String>> readings;

    @JsonDeserialize(as = HashMap.class)
    private Map<Language, List<String>> meanings;

    private List<String> nanori;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Misc implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
        private Integer grade;
        private Integer strokeCount;
        private Integer freq;
        private Integer jlpt;
    }
}
