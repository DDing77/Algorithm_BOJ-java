import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String A, B;
    static String minA, maxA;
    static String minB, maxB;
    static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        boolean isPass;

        minA = "";
        maxA = "";
        for (int i = 0; i < A.length(); i++) {
            isPass = false;
            char ch = A.charAt(i);
            if (ch == '5' || ch == '6') {
                minA += "5";
                maxA += "6";
                isPass = true;
            }
            if (!isPass) {
                minA += ch;
                maxA += ch;
            }
        }

        minB = "";
        maxB = "";
        for (int i = 0; i < B.length(); i++) {
            isPass = false;
            char ch = B.charAt(i);
            if (ch == '5' || ch == '6') {
                minB += "5";
                maxB += "6";
                isPass = true;
            }
            if (!isPass) {
                minB += ch;
                maxB += ch;
            }
        }

        min = Integer.parseInt(minA) + Integer.parseInt(minB);
        max = Integer.parseInt(maxA) + Integer.parseInt(maxB);

        System.out.println(min + " " + max);
    }
}
