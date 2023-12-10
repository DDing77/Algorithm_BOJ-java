import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    String[] input;
    char[][] resBoard;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        input = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];
        int lengthA = A.length();
        int lengthB = B.length();

        resBoard = new char[lengthB][lengthA];
        for (int i = 0; i < resBoard.length; i++) {
            Arrays.fill(resBoard[i], '.');
        }

        boolean isFindPoint = false;
        for (int i = 0; i < lengthA; i++) {
            for (int j = 0; j < lengthB; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    for (int k = 0; k < lengthB; k++) {
                        resBoard[k][i] = B.charAt(k);
                    }
                    for (int k = 0; k < lengthA; k++) {
                        resBoard[j][k] = A.charAt(k);
                    }
                    isFindPoint = true;
                    break;
                }
            }
            if (isFindPoint) {
                break;
            }
        }

        for (int i = 0; i < lengthB; i++) {
            for (int j = 0; j < lengthA; j++) {
                sb.append(resBoard[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
