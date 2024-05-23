import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String input;
    private int leftCnt;
    private int rightCnt;

    private void solution() throws IOException {

        input = br.readLine();
        String[] splitInput = input.split("0");
        for (int i = 0; i < splitInput[0].length(); i++) {
            if (splitInput[0].charAt(i) == '@') {
                leftCnt++;
            }
        }

        for (int i = 0; i < splitInput[1].length(); i++) {
            if (splitInput[1].charAt(i) == '@') {
                rightCnt++;
            }
        }

        sb.append(leftCnt).append(" ").append(rightCnt);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
