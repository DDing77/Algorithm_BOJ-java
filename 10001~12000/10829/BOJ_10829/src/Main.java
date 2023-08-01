import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Long.toBinaryString(Long.parseLong(br.readLine())));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
