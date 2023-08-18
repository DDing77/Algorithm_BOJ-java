import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    int N;
    HashSet<String> set;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        res = 0;
        set = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                res += set.size();
                set.clear();
                continue;
            }
            set.add(input);
        }
        res += set.size();
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
