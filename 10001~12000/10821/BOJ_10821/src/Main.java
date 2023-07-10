import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] input;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().split(",");

        System.out.println(input.length);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
