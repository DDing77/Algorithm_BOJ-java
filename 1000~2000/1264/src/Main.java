import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Character> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        set = new HashSet<>();

        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');

        while (true) {
            int cnt = 0;
            String input = br.readLine();
            if (input.charAt(0) == '#') break;

            for (int i = 0; i < input.length(); i++) {
                if (set.contains(input.charAt(i))) cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
