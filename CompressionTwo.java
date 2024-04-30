import java.util.HashMap;

public class CompressionTwo {

//    Run-length encoding or RLE algorithm
//    RLE is the most straightforward data compression algorithm, especially useful when many of the same characters are repeated.
//    However in cases where many unique characters are used, the compressed sting can take up even more space than the original string

    public static StringBuilder rleCompression(String text){

        StringBuilder theText = new StringBuilder();
        int textLength = text.length();


//        TIME COMPLEXITY
//        ------------------
//        The amount of itterations of this outer loop is linearly dependent on the size of the original array.
//        Therefore it is f = 0(n)
//        The outer loop is f = 0(n-1) as it will 1 less time than the outerloop
//        The overal time complexity is f = 0(n) + 0(n-1) is 0(n)
//        Hence the time complexity is still 0(n)

        for (int i = 0; i < textLength; i++) {
            int count = 1;
            while(i < textLength - 1 && text.charAt(i) == text.charAt(i + 1)){
                count ++;
                i++;
            }
//            System.out.println(text.charAt(i) + "" + count);
            theText.append(text.charAt(i) + "" + count);
//            System.out.println("This is the value of theText:" + theText);

        }
        return theText;
    }

}
