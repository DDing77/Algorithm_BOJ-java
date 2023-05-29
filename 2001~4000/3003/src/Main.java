import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] pieces = {1, 1, 2, 2, 2, 8};
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        arr = new int[pieces.length];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < pieces.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sb.append(pieces[i] - arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}
