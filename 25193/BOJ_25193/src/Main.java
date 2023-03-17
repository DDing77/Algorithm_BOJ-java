import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private int N;
    private String input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();

        int cCnt = 0;
        int other = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'C') {
                cCnt++;
            }
        }

        other = input.length() - cCnt;

        System.out.println(input.length() / (other + 1));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
