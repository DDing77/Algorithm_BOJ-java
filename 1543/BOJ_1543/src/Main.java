import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static String pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        pattern = br.readLine();

        int startIdx = 0;
        int patternLength = pattern.length();
        int res = 0;
        while (startIdx + patternLength <= input.length()) {
            String temp = input.substring(startIdx, startIdx + patternLength);
            if (temp.equals(pattern)) {
                res++;
                startIdx = startIdx + patternLength;
            } else startIdx++;
        }

        System.out.println(res);
    }
}