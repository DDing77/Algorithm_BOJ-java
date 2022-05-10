import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        cnt = new int[26];

        for (int i = 0; i < input.length(); i++) cnt[input.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) sb.append(cnt[i]).append(' ');

        System.out.println(sb);
    }
}
