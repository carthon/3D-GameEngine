package org.carthon.utils;

import org.carthon.Main;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Utils {
    public static File loadResourceFile(String path) throws URISyntaxException {
        URL url = Utils.class.getClassLoader().getResource(path);
        assert url != null;
        return new File(url.toURI());
    }
    public static String loadResourceRaw(String path) throws URISyntaxException, IOException {
        File file = loadResourceFile(path);
        StringBuilder rawString = new StringBuilder();
        for (String line : Files.readAllLines(file.toPath(), StandardCharsets.UTF_8)){
            rawString.append(line).append('\n');
        }
        return rawString.toString();
    }
}
