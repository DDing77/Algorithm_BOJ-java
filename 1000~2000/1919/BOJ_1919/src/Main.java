import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String pattern1;
    static String pattern2;
    static int[] alpha1;
    static int[] alpha2;
    static int res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pattern1 = br.readLine();
        alpha1 = new int[26];
        for (int i = 0; i < pattern1.length(); i++) {
            alpha1[pattern1.charAt(i) - 'a']++;
        }

        pattern2 = br.readLine();
        alpha2 = new int[26];
        for (int i = 0; i < pattern2.length(); i++) {
            alpha2[pattern2.charAt(i) - 'a']++;
        }

        res = 0;
        for (int i = 0; i < alpha1.length; i++) {
            res += Math.abs(alpha1[i] - alpha2[i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
