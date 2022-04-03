import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String parent = "";
    static String pattern = "";
    static String temp;
    static int[] pi;
    static int cnt;

    static void failureFunction() {
        pi = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    static void KMP() {
        failureFunction();
        cnt = 0;
        int j = 0;
        for (int i = 0; i < N * 2 - 1; i++) {
            while (j > 0 && temp.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (temp.charAt(i) == pattern.charAt(j)) {
                if (pattern.length() - 1 == j) {
                    cnt++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }

    static int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(st.nextToken());
        }
        parent = sb.toString();

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(st.nextToken());
        }
        pattern = sb.toString();

        temp = parent+parent;

        KMP();
//        System.out.println(parent);
//        System.out.println(temp);
        int up = cnt;
        int bottom = parent.length();
        int gcd = getGCD(up, bottom);
        System.out.println((up/gcd) +"/" + (bottom/gcd));
    }
}
