package io.github.aliasbretaud.mojibox.data;

import java.time.LocalDate;

public record Metadata(int fileVersion, String databaseVersion,
                       LocalDate dateOfCreation) {
}
