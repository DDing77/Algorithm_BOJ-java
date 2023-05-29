import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                if (arr[i] >= 'N') arr[i] -= 13;
                else arr[i] += 13;
            } else if (arr[i] >= 'a' && arr[i] <= 'z') {
                if (arr[i] >= 'n') arr[i] -= 13;
                else arr[i] += 13;
            }
        }

        for (char i : arr) sb.append(i);

        System.out.println(sb);
    }
}