import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int A = arr[0]*arr[0] + arr[1]*arr[1] + arr[2]*arr[2] + arr[3]*arr[3] + arr[4]*arr[4];
        int B = A%10;
        System.out.println(B);
    }
}
