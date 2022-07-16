import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            int N = S.charAt(i) - '0';
            if (N >= 4) {
                sb.append(1);
                N -= 4;
            } else {
                sb.append(0);
            }
            if (N >= 2) {
                sb.append(1);
                N -= 2;
            } else {
                sb.append(0);
            }
            if (N == 1) {
                sb.append(1);
                N -= 1;
            } else {
                sb.append(0);
            }
        }

        if (S.charAt(0) == '1') {
            sb.delete(0, 2);
        } else if (S.charAt(0) == '2' || S.charAt(0) == '3') {
            sb.deleteCharAt(0);
        } else if (S.charAt(0) == '0') {
            sb.delete(0, 2);
        }
        System.out.println(sb);
    }
}