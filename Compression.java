import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {

//    Lempel-Ziv-Welch or LZW compression algorithm
//    More versatile than the RLE algorithm however more complex and takes up more space since a HashMap is used.
    public static List<Integer> encode(String text){
        int dictionarySize = 256;

//        dictionary is a hashmap with the character representation as the key and integer as the value
        Map<String, Integer> dictionary = new HashMap<>();
//        This loop runs 256 times, it is a fixed amount that will not change regardless of the text input.


        for(int i =0; i < dictionarySize; i++){

//            String.valueOf((char) i ) converts the integer into it's character representation
//            The char representation is the key and the integer itself is the value, this is being placed in the hashmap

            dictionary.put(String.valueOf((char) i), i);
        }
        String foundChars = "";
//        The result array will contain an array where each character is in it's compressed form.
        List<Integer> result = new ArrayList<>();


//      Loop through the text given in the argument of this method. encode is the name of the method
//      You are trying to see if the characters from the given text exist in the hashmap.
//      Because this is the LZW algo, you are checking a single character and the character after it,
//      hence why the empty string foundChars is used.



        for(char character : text.toCharArray()){
            String charsToAdd = foundChars + character;
            if (dictionary.containsKey(charsToAdd)){
//                If the character exists in the hashmap, add that char to the foundChar string variable
                foundChars = charsToAdd;
            }else{
//                Once a character that does not exist is found,
//                store the integer values of found chars in a variable.
                int integerValuesOfFoundChars = dictionary.get(foundChars);

//                Add those integer values to the array that will be returned
                result.add(integerValuesOfFoundChars);
//                The character that does not exist should be added to the hashmap
                dictionary.put(charsToAdd, dictionarySize++);
//                Reset the foundChars variable to the current character
                foundChars = String.valueOf(character);
            }
        }
        if(!foundChars.isEmpty()){
            result.add(dictionary.get(foundChars));
        }
        return result;
    }
}
