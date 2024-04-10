package com.github.aliasbretaud.mojibox;

import java.io.IOException;

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

    public Kanji searchKanji(String search) {
        if (search == null) {
            return null;
        }
        return this.data.getKanjis().get(search);
    }

    public Metadata getMetadata() {
        return this.data.getMetadata();
    }

    public int getSize() {
        return this.data.getKanjis().size();
    }
}
