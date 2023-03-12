import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private String input;
    private ArrayList<String> strings;

    public String reversString(String str) {
        StringBuilder sb = new StringBuilder();
        return sb.append(str).reverse().toString();
    }


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        input = br.readLine();
        int length = input.length();
        strings = new ArrayList<>();

        for (int i = 1; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                sb = new StringBuilder();
                sb.append(reversString(input.substring(0, i))).append(
                        reversString(input.substring(i, j + 1))).append(
                        reversString(input.substring(j + 1, length)));
                strings.add(sb.toString());
            }
        }

        Collections.sort(strings);

        System.out.println(strings.get(0));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
