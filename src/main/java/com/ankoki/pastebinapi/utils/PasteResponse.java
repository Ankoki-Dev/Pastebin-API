package com.ankoki.pastebinapi.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Collectors;

public class PasteResponse implements Response<String> {

    private String input = "<none>";
    private String stackTrace = "<none>";
    private boolean error;
    public PasteResponse(Optional<InputStream> optional) {
        optional.ifPresent(inputStream -> input = readInputStream(inputStream));
    }

    public PasteResponse(String input) {
        this.input = input;
    }

    public PasteResponse(String stackTrace, boolean error) {
        if (stackTrace.startsWith("Server returned HTTP response code: 403 for URL:")) {
            this.stackTrace = "You attempted to access a private paste!";
        } else {
            this.stackTrace = stackTrace;
        }
        this.error = error;
    }

    @Override
    public String get() {
        return input;
    }

    @Override
    public boolean hasError() {
        return error || input.startsWith("Bad API request");
    }

    @Override
    public String getError() {
        return stackTrace;
    }

    private String readInputStream(InputStream stream) {
        return new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
                .lines().collect(Collectors.joining("\n"));
    }
}
