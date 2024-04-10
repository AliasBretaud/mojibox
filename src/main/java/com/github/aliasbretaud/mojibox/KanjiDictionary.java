package com.github.aliasbretaud.mojibox;

import lombok.Getter;

import java.io.IOException;
import java.util.Map;

import static java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;

public class KanjiDictionary {

    @Getter
    private final Metadata metadata;

    private final Map<String, Kanji> kanjis;

    public KanjiDictionary() {
        var dictionaryUrl = getClass()
                .getClassLoader()
                .getResource("kanji_dictionary.json");
        try {
            var data = new DictionaryBuilder(dictionaryUrl).generateData();
            this.metadata = data.getMetadata();
            this.kanjis = data.getKanjis();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Kanji searchKanji(Character search) {
        if (search == null ||
                Character.UnicodeBlock.of(search) != CJK_UNIFIED_IDEOGRAPHS) {
            return null;
        }
        return this.kanjis.get(String.valueOf(search));
    }

    public int getSize() {
        return this.kanjis.size();
    }
}
