package Codility.src.com.string.basics;

public class MessageSplitter {
    public static String[] splitMessage(String message) {
        // Find the position of the first colon after the timestamp
        int splitPosition = message.indexOf(':', 20); // Assuming timestamp is always 20 characters

        if (splitPosition != -1) {
            String timestamp = message.substring(0, splitPosition);
            String content = message.substring(splitPosition + 1).trim(); // Remove leading whitespace
            return new String[]{timestamp, content};
        } else {
            // Return null if the message format is incorrect
            return new String[]{null, null};
        }
    }

    public static void main(String[] args) {
        String message = "2024-06-13T07:35:02Z:log 1 msg 1";
        String[] result = splitMessage(message);

        System.out.println("Timestamp: " + result[0]);
        System.out.println("Content: " + result[1]);
    }
}