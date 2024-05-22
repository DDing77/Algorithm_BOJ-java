import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[] input;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();

        for (int i = N - 2; i >= 0; i--) {
            if (input[i] == 'A') {
                if (input[i + 1] == 'A') {
                    input[i] = 'A';
                } else if (input[i + 1] == 'G') {
                    input[i] = 'C';
                } else if (input[i + 1] == 'C') {
                    input[i] = 'A';
                } else if (input[i + 1] == 'T') {
                    input[i] = 'G';
                }
            } else if (input[i] == 'G') {
                if (input[i + 1] == 'A') {
                    input[i] = 'C';
                } else if (input[i + 1] == 'G') {
                    input[i] = 'G';
                } else if (input[i + 1] == 'C') {
                    input[i] = 'T';
                } else if (input[i + 1] == 'T') {
                    input[i] = 'A';
                }
            } else if (input[i] == 'C') {
                if (input[i + 1] == 'A') {
                    input[i] = 'A';
                } else if (input[i + 1] == 'G') {
                    input[i] = 'T';
                } else if (input[i + 1] == 'C') {
                    input[i] = 'C';
                } else if (input[i + 1] == 'T') {
                    input[i] = 'G';
                }
            } else if (input[i] == 'T') {
                if (input[i + 1] == 'A') {
                    input[i] = 'G';
                } else if (input[i + 1] == 'G') {
                    input[i] = 'A';
                } else if (input[i + 1] == 'C') {
                    input[i] = 'G';
                } else if (input[i + 1] == 'T') {
                    input[i] = 'T';
                }
            }
        }
        System.out.println(input[0]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
