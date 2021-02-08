package com.ankoki.pastebinapi.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Collectors;

public class PasteResponse implements Response<String> {

    private final String input;
    public PasteResponse(Optional<InputStream> optional) {
        if (optional.isPresent()) {
            input = readInputStream(optional.get());
        } else {
            input = "NOT PRESENT";
        }
    }

    public PasteResponse(String input) {
        this.input = input;
    }

    @Override
    public String get() {
        return input;
    }

    @Override
    public boolean hasError() {
        return input.startsWith("Bad API request");
    }

    @Override
    public String getError() {
        return input;
    }

    private String readInputStream(InputStream stream) {
        return new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
                .lines().collect(Collectors.joining("\n"));
    }
}
