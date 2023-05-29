import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String str1 = "Hello World, Judge ";
    static String str2 = "!";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append(str1 + i + str2).append('\n');
        }
        System.out.print(sb);
    }
}
