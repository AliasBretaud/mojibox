package com.github.aliasbretaud.mojibox;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KanjiDictionaryTest {

    private final KanjiDictionary kanjiDictionary = new KanjiDictionary();

    @Test
    public void metaDataTest() {
        var metadata = kanjiDictionary.getMetadata();

        assertNotNull(metadata);
        assertEquals(4, metadata.fileVersion());
        assertEquals("2024-100", metadata.databaseVersion());
        assertEquals(LocalDate.of(2024, Month.APRIL, 9), metadata.dateOfCreation());
    }

    @Test
    public void searchTest() {
        var kanji = kanjiDictionary.searchKanji("高");
        assertEquals("高", kanji.getLiteral());
        var misc = kanji.getMisc();
        assertEquals(2, misc.getGrade());
        assertEquals(10, misc.getStrokeCount());
        assertEquals(65, misc.getFreq());
        assertEquals(4, misc.getJlpt());
        var readings = kanji.getReadings();
        assertEquals(List.of("gao1"), readings.get(ReadingType.PINYIN));
        assertEquals(List.of("go"), readings.get(ReadingType.KOREAN_R));
        assertEquals(List.of("고"), readings.get(ReadingType.KOREAN_H));
        assertEquals(List.of("Cao"), readings.get(ReadingType.VIETNAM));
        assertEquals(List.of("コウ"), readings.get(ReadingType.JA_ON));
        assertEquals(List.of("たか.い", "たか", "-だか", "たか.まる", "たか.める"),
                readings.get(ReadingType.JA_KUN));
        var meanings = kanji.getMeanings();
        assertEquals(List.of("tall", "high", "expensive"), meanings.get(Language.EN));
        assertEquals(List.of("haut", "élevé", "grand", "cher"), meanings.get(Language.FR));
        assertEquals(List.of("alto", "caro", "sobresaliente", "elevar", "levantar"), meanings.get(Language.ES));
        assertEquals(List.of("Caro", "alto"), meanings.get(Language.PT));
        var nanori = kanji.getNanori();
        assertEquals(List.of("か", "こ", "じょい", "た", "はか"), nanori);
    }

    @Test
    public void searchNullTest() {
        assertNull(kanjiDictionary.searchKanji(null));
    }

    @Test
    public void searchNotKanjiTest() {
        assertNull(kanjiDictionary.searchKanji("A"));
    }

    @Test
    public void searchUnknownKanjiTest() {
        assertNull(kanjiDictionary.searchKanji("龘"));
    }

    @Test
    public void getSizeTest() {
        assertEquals(13108, kanjiDictionary.getSize());
    }
}
