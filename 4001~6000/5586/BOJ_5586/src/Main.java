import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String input;
    int cntJOI;
    int cntIOI;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        cntIOI = 0;
        cntJOI = 0;

        input = br.readLine();
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.startsWith("JOI", i)) {
                cntJOI++;
            } else if (input.startsWith("IOI", i)) {
                cntIOI++;
            }
        }

        sb.append(cntJOI).append('\n').append(cntIOI);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
