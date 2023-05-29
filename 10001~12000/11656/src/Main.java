import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static String input;
    static ArrayList<String> suffix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine();
        suffix = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            String temp = input.substring(i, input.length());
            suffix.add(temp);
        }

        Collections.sort(suffix);

        for (String str : suffix) sb.append(str).append('\n');

        System.out.print(sb);
    }
}