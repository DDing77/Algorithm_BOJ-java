import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long x, k;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        arr = new long[3];

        if (7000 * k <= 1000 * x) arr[0] = 7000 * k;
        if (3500 * k <= 1000 * x) arr[1] = 3500 * k;
        if (1750 * k <= 1000 * x) arr[2] = 1750 * k;

        Arrays.sort(arr);

        System.out.println(arr[2]);
    }
}