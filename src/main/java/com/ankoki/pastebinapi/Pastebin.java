package com.ankoki.pastebinapi;

import com.ankoki.pastebinapi.utils.HTTPUtils;
import com.ankoki.pastebinapi.utils.Response;

public class Pastebin {
    private final String key;
    public Pastebin(String key) {
        this.key = key;
    }

    public String getPaste() {
        Response<String> response = HTTPUtils.readPaste(key);
        if (response.hasError()) return response.getError();
        return response.get();
    }
}
