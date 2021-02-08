package com.ankoki.pastebinapi.api;

import com.ankoki.pastebinapi.enums.PasteExpiry;
import com.ankoki.pastebinapi.enums.PasteVisibility;
import com.ankoki.pastebinapi.utils.HTTPUtils;
import com.ankoki.pastebinapi.utils.PasteResponse;
import com.ankoki.pastebinapi.utils.Response;

import java.io.InputStream;
import java.util.Optional;

public class PasteBuilder implements Paste {
    private String title = "New Paste";
    private String rawText = "";
    private PasteVisibility visibility = PasteVisibility.PUBLIC;
    private PasteExpiry expiry = PasteExpiry.NEVER;
    private String format = "";
    private String developerKey = null;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.rawText = text;
    }

    public void setVisibility(PasteVisibility visibility) {
        this.visibility = visibility;
    }

    public void setExpiry(PasteExpiry expiry) {
        this.expiry = expiry;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setDeveloperKey(String developerKey) {
        this.developerKey = developerKey;
    }

    public Response<String> createPaste() {
        try {
            return HTTPUtils.sendPaste(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new PasteResponse(Optional.empty());
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getText() {
        return rawText;
    }

    @Override
    public PasteVisibility getVisibility() {
        return visibility;
    }

    @Override
    public PasteExpiry getExpiry() {
        return expiry;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public String getDeveloperKey() {
        return developerKey;
    }
}
