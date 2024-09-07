package Codility.src.com.mathlogic;

import java.util.LinkedHashMap;
public class SecondsToDuration {
    private static final LinkedHashMap<String, Integer> durationMap = new LinkedHashMap<>();

    static {
        durationMap.put("w", 60 * 60 * 24 * 7);
        durationMap.put("d", 60 * 60 * 24);
        durationMap.put("h", 60 * 60);
        durationMap.put("m", 60);
    }

    private String secondsToWords(int seconds) {
        StringBuilder results = new StringBuilder();
        for (String key : durationMap.keySet()) {
            int duration = seconds / durationMap.get(key);
            if (duration > 0) {
                results.append(duration + "" + key);
            }
            seconds = seconds % durationMap.get(key);
        }
        if (seconds > 0) results.append(seconds + "s");
        return results.toString();
    }
}
