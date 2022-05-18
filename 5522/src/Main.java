import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int sum = 0;
        while(N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
        }
        System.out.println(sum);
    }
}
