import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int D, H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        double ratio = Math.pow(D, 2) / (Math.pow(H, 2) + Math.pow(W, 2));
        System.out.println((int) Math.sqrt(ratio * Math.pow(H, 2)) + " " +
                (int) Math.sqrt(ratio * Math.pow(W, 2)));
    }
}
