import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static String S;
    static int[] pi;

    static void failureFunction() {
        pi = new int[S.length()];
        int j = 0;
        for(int i=1; i<S.length(); i++) {
            while(j >0 && S.charAt(i) != S.charAt(j)) {
                j = pi[j-1];
            }
            if(S.charAt(i) == S.charAt(j)) {
                pi[i] = ++j;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();

        failureFunction();
        System.out.println(Arrays.toString(pi));
    }
}

// len - pi