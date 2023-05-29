import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 3; i++) arr[Integer.parseInt(st.nextToken())]++;

        int res = arr[1] > arr[2] ? 1 : 2;

        System.out.println(res);
    }
}