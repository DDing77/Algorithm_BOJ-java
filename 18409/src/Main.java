import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N;
    static Set<Character> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        N = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        int res = 0;
        for (char cur : c) {
            if (set.contains(cur)) res++;
        }

        System.out.println(res);
    }
}