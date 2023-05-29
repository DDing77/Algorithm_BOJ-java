import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N  = Integer.parseInt(br.readLine());


        double temp = N * 0.2;

        temp = temp * 0.22;

        sb.append((int)(N * 0.78)).append(' ').append((int)(N - temp));
        System.out.println(sb);

    }
}
