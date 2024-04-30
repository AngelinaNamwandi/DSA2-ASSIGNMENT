import java.util.regex.Pattern;

public class DecompressionTwo {

    public static StringBuilder rleDecompression(StringBuilder text){
        int textLength = text.length();
        StringBuilder returnText = new StringBuilder();

        Pattern pattern = Pattern.compile("([a-zA-Z])([0-9]*)");
        pattern.matcher(text).results().forEach(result -> {
            int counter= Integer.parseInt(result.group(2));
            returnText.append(result.group(1).repeat(counter));

        });
        return returnText;

    }

}
