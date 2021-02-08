package com.ankoki.pastebinapi.api;

import com.ankoki.pastebinapi.enums.PasteExpiry;
import com.ankoki.pastebinapi.enums.PasteVisibility;

public interface Paste {
    public String getTitle();
    public String getText();
    public PasteVisibility getVisibility();
    public PasteExpiry getExpiry();
    public String getFormat();
    public String getDeveloperKey();
}
