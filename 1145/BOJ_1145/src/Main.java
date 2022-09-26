import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[5];

        for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());

        int num = 1;
        int count = 0;

        while (true) {
            for (int k = 0; k < 5; k++) {
                if (num % arr[k] == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(num);
                return;
            }
            count = 0;
            num++;
        }

    }
}