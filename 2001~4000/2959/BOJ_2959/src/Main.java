import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] lengths;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        lengths = new int[4];
        for (int i = 0; i < 4; i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lengths);

        System.out.println(lengths[0] * lengths[2]);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
