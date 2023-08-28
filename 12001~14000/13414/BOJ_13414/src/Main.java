import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    int K;
    int L;
    Set<String> studentId;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        studentId = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            if (studentId.contains(id)) {
                studentId.remove(id);
            }
            studentId.add(id);
        }

        for (String s : studentId) {
            if (K == 0) {
                break;
            }
            K--;
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
