package com.ankoki.pastebinapi;

import com.ankoki.pastebinapi.utils.HTTPUtils;
import com.ankoki.pastebinapi.utils.Response;

public class Pastebin {
    private final String key;
    private Response<String> paste = null;
    public Pastebin(String key) {
        this.key = key;
    }

    public Response<String> getPaste() {
        if (paste == null) {
            paste = HTTPUtils.readPaste(key);
        } return paste;
    }
}
