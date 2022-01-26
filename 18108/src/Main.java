import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int diff = 2541- 1998;
        int N = Integer.parseInt(br.readLine());
        System.out.println(N -diff);
    }
}
