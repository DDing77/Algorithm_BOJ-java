import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[2];
        arr[0] = Long.parseLong(st.nextToken());
        arr[1] = Long.parseLong(st.nextToken());

        if((arr[0] %2) == 0  || (arr[1] %2)  == 0) System.out.println(0);
        else System.out.println(Math.min(arr[0], arr[1]));
    }
}
