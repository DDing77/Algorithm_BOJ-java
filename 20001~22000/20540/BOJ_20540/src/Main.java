import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    char[] input;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        input = br.readLine().toCharArray();
        if (input[0] == 'I') {
            sb.append("E");
        } else if (input[0] == 'E') {
            sb.append("I");
        }

        if (input[1] == 'S') {
            sb.append("N");
        } else if (input[1] == 'N') {
            sb.append("S");
        }

        if (input[2] == 'T') {
            sb.append("F");
        } else if (input[2] == 'F') {
            sb.append("T");
        }

        if (input[3] == 'J') {
            sb.append("P");
        } else if (input[3] == 'P') {
            sb.append("J");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
