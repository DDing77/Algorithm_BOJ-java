import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    int N;
    String[] studentId;
    int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        studentId = new String[N];
        for (int i = 0; i < N; i++) {
            studentId[i] = br.readLine();
        }

        res = studentId[0].length();
        HashSet<String> set;
        boolean isContain;
        for (int i = 0; i < studentId[0].length(); i++) {
            set = new HashSet<>();
            isContain = false;
            for (int j = 0; j < N; j++) {
                String sub = studentId[j].substring(studentId[j].length() - 1 - i);
                if (!set.contains(sub)) {
                    set.add(sub);
                } else {
                    isContain = true;
                    break;
                }
            }

            if (!isContain) {
                res = i + 1;
                break;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
