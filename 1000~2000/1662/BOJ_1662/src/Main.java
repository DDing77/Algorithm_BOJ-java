import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;
    int res;
    boolean[] isVisited;

    public int recursion(int idx) {
        int cnt = 0;
        for (int i = idx; i < input.length(); i++) {
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            char cur = input.charAt(i);

            if (cur == '(') {
                cnt += (input.charAt(i - 1) - '0') * recursion(idx + 1) - 1;
            } else if (cur == ')') {
                return cnt;
            } else {
                cnt++;
            }
        }

        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        res = 0;
        isVisited = new boolean[input.length()];

        System.out.println(recursion(0));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
