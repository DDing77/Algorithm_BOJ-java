import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int n;
    static String input;
    static Set<Character> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = br.readLine().toLowerCase();
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(input.charAt(i));
        }

        if (set.size() == 26) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
