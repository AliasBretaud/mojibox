package com.github.aliasbretaud.mojibox;

import java.time.LocalDate;

public record Metadata(int fileVersion, String databaseVersion,
                       LocalDate dateOfCreation) {
}
