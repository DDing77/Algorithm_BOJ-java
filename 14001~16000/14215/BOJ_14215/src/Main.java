import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] length;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        length = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(length);

        int a = length[0] + length[1];

        if (a > length[2]) {
            System.out.println(a + length[2]);
        } else {
            System.out.println(a + a - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
