import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int L;
    static String pattern;
    static int[] pi;
    static void failureFunction() {
        pi = new int[pattern.length()];
        int j=0;
        for(int i=1; i<pattern.length(); i++) {
            while(j >0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if( pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        pattern = br.readLine();
        failureFunction();
        System.out.println(L - pi[pattern.length()-1]);
    }
}
