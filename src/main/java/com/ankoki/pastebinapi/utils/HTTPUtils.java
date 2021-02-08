package com.ankoki.pastebinapi.utils;

import com.ankoki.pastebinapi.api.Paste;
import com.ankoki.pastebinapi.exceptions.EmptyPasteCodeException;
import com.ankoki.pastebinapi.exceptions.NoDeveloperKeyException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;

public final class HTTPUtils {
    private HTTPUtils() {}

    public static Response<String> sendPaste(Paste paste)
            throws NoDeveloperKeyException, EmptyPasteCodeException {
        Map<String, String> pasteArgs = new HashMap<>();
        if (paste.getDeveloperKey() == null) throw new NoDeveloperKeyException("A paste was attempted to be posted without a developer key!");
        pasteArgs.put("api_dev_key", paste.getDeveloperKey());
        pasteArgs.put("api_option", "paste");
        if (paste.getText().isEmpty()) throw new EmptyPasteCodeException();
        pasteArgs.put("api_paste_code", paste.getText());
        pasteArgs.put("api_paste_name", paste.getTitle());
        pasteArgs.put("api_paste_expire_date", paste.getExpiry().getApi());
        pasteArgs.put("api_paste_format", paste.getFormat());
        pasteArgs.put("api_paste_private", paste.getVisibility().getApi());
        try {
            HttpURLConnection http = (HttpURLConnection) new URL("https://pastebin.com/api/api_post.php").openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            StringJoiner joiner = new StringJoiner("&");
            for (Map.Entry<String, String> entry : pasteArgs.entrySet()) {
                joiner.add(URLEncoder.encode(entry.getKey(), "UTF-8") +
                        "=" +
                        URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            byte[] out = joiner.toString().getBytes(StandardCharsets.UTF_8);
            http.setFixedLengthStreamingMode(out.length);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            http.connect();
            try(OutputStream os = http.getOutputStream()) {
                os.write(out);
            }
            http.getInputStream();
            return new PasteResponse(Optional.of(http.getInputStream()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new PasteResponse(Optional.empty());
    }

    public static Response<String> readPaste(String key) {
        try {
            HttpURLConnection http = (HttpURLConnection) new URL("https://pastebin.com/raw/" + key).openConnection();
            http.connect();
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder response = new StringBuilder();
            for (String line; (line = inputReader.readLine()) != null;) {
                response.append(line);
                response.append('\n');
            }
            return new PasteResponse(response.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new PasteResponse(Optional.empty());
    }
}
