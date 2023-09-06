import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    char[] input;
    int happyCnt;
    int sadCnt;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toCharArray();

        happyCnt = 0;
        sadCnt = 0;

        for (int i = 0; i < input.length - 2; i++) {
            if (input[i] == ':' && input[i + 1] == '-') {
                if (input[i + 2] == ')') {
                    happyCnt++;
                }
                if (input[i + 2] == '(') {
                    sadCnt++;
                }
            }
        }

        if (happyCnt == 0 && sadCnt == 0) {
            System.out.println("none");
        } else if (happyCnt == sadCnt) {
            System.out.println("unsure");
        } else if (happyCnt > sadCnt) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
