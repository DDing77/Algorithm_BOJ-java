import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    int N;
    HashSet<String> dance;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dance = new HashSet<>();
        dance.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String left = st.nextToken();
            String right = st.nextToken();

            if(dance.contains(left) || dance.contains(right)) {
                dance.add(left);
                dance.add(right);
            }
        }

        System.out.println(dance.size());
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
