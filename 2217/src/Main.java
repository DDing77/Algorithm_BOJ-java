import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static Integer[] lope;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lope = new Integer[N];
        for(int i=0; i<N; i++) {
            lope[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        Arrays.sort(lope, Collections.reverseOrder());
        for(int i=1; i<=N; i++) {
            max = Math.max(max, lope[i-1]*i);
        }
        System.out.println(max);
    }
}
