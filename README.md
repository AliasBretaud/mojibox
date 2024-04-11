# Mojibox

Mojibox is a Java library for working with a Kanji dictionary. It provides functionality to search through Kanji data efficiently.

## Installation

You can include Mojibox in your Maven project by adding the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.aliasbretaud</groupId>
    <artifactId>mojibox</artifactId>
    <version>0.0.4</version>
</dependency>
```

## Usage

To use Mojibox in your Java project, you can follow these steps:

1. **Include Dependency**: Make sure Mojibox is included in your project's dependencies as shown above.

2. **Instantiate KanjiDictionary**: Create an instance of `KanjiDictionary` to access Kanji data.

3. **Search Kanji**: Use the `searchKanji()` method to search for a specific Kanji by its literal.

```java
KanjiDictionary kanjiDictionary = new KanjiDictionary();
KanjiEntry kanji = kanjiDictionary.searchKanji("漢");
```

4. **Access Kanji Data**: Once you have a Kanji object, you can access its readings, meanings, and other information.

```java
import io.github.aliasbretaud.mojibox.enums.MeaningLanguage;
import io.github.aliasbretaud.mojibox.enums.ReadingType;

String literal = kanji.getLiteral();
List<String> readings = kanji.getReadings().get(ReadingType.JA_ON);
List<String> meanings = kanji.getMeanings().get(MeaningLanguage.EN);
```

## About KANJIDIC

Mojibox utilizes a simplified version of the [KANJIDIC](http://www.edrdg.org/wiki/index.php/KANJIDIC_Project) dictionary. KANJIDIC is a project focused on providing comprehensive data about Kanji characters.

For more information about Mojibox and its usage, please refer to the [documentation](#) (coming soon).

## License

This project is licensed under the [MIT License](LICENSE).
