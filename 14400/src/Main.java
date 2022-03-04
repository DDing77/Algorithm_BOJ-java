import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] X;
    static int[] Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        X = new int[n];
        Y = new int[n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            X[i] = x;
            Y[i] = y;
        }
        Arrays.sort(X);
        Arrays.sort(Y);

        int tempX = X[n/2];
        int tempY = Y[n/2];

        long sum = 0;
        for(int i=0; i<n; i++) {
            sum += Math.abs(tempX - X[i]) + Math.abs(tempY - Y[i]);
        }
        System.out.println(sum);
    }
}
