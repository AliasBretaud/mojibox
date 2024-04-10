package com.github.aliasbretaud.mojibox;

import java.io.IOException;

import static java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;

public class KanjiDictionary {

    private final DictionaryData data;

    public KanjiDictionary() {
        var dictionaryUrl = getClass()
                .getClassLoader()
                .getResource("kanji_dictionary.json");
        try {
            this.data = new DictionaryBuilder(dictionaryUrl).generateData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Kanji searchKanji(Character search) {
        if (search == null ||
                Character.UnicodeBlock.of(search) != CJK_UNIFIED_IDEOGRAPHS) {
            return null;
        }
        return this.data.getKanjis().get(String.valueOf(search));
    }

    public Metadata getMetadata() {
        return this.data.getMetadata();
    }

    public int getSize() {
        return this.data.getKanjis().size();
    }
}
