package io.github.aliasbretaud.mojibox.dictionary;

import io.github.aliasbretaud.mojibox.data.DictionaryData;
import io.github.aliasbretaud.mojibox.data.Kanji;
import io.github.aliasbretaud.mojibox.data.Metadata;
import io.github.aliasbretaud.mojibox.builder.DictionaryBuilder;

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
