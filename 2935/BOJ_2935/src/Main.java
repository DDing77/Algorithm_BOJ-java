import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String A, B;
    static String op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        A = br.readLine();
        op = br.readLine();
        B = br.readLine();

        int cntA = A.length() - 1;
        int cntB = B.length() - 1;

        if (op.equals("*")) {
            sb.append("1");
            for (int i = 0; i < cntA + cntB; i++) {
                sb.append("0");
            }
        } else {
            if (cntA == cntB) {
                sb.append("2");
                for (int i = 0; i < cntA; i++) {
                    sb.append("0");
                }
            } else if (cntA > cntB) {
                sb.append("1");
                for (int i = 0; i < cntA - cntB - 1; i++) {
                    sb.append("0");
                }
                sb.append(B);
            } else {
                sb.append("1");
                for (int i = 0; i < cntB - cntA - 1; i++) {
                    sb.append("0");
                }
                sb.append(A);
            }
        }
        System.out.println(sb);
    }
}
