import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    static String input;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine();
        list = new ArrayList<>();

        int N = input.length();
        for (int i = 1; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                String first = sb.append(input.substring(0, i)).reverse().toString();
                sb.delete(0, sb.length());
                String second = sb.append(input.substring(i, j)).reverse().toString();
                sb.delete(0, sb.length());
                String third = sb.append(input.substring(j, N)).reverse().toString();
                sb.delete(0, sb.length());

                list.add(first + second + third);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
