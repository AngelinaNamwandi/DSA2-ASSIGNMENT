import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Decompression {
    public static String decode(List<Integer> encodedText){
        int dictionarySize = 256;
        Map<Integer, String> dictionary = new HashMap<>();
        for(int i = 0; i < dictionarySize; i ++){
            dictionary.put(i, String.valueOf((char) i));
        }

        String characters = String.valueOf((char) encodedText.remove(0).intValue());
        StringBuilder result = new StringBuilder(characters);
        for(int code : encodedText) {
            String entry = dictionary.containsKey(code)
                    ? dictionary.get(code)
                    : characters + characters.charAt(0);
            result.append(entry);
            dictionary.put(dictionarySize++,characters + entry.charAt(0));

        }
        return result.toString();
    }
}
