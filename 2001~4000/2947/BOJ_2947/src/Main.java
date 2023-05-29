import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    static void makeString() {
        for (int i = 0; i < 5; i++) {
            sb.append(arr[i] + " ");
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) arr[i] = Integer.parseInt(st.nextToken());

        while (!check()) {
            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    makeString();
                }
            }
        }
        System.out.print(sb);
    }
}
