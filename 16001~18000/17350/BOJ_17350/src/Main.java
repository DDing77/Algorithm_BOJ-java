import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    String name;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            name = br.readLine();
            if (name.equals("anj")) {
                System.out.println("뭐야;");
                return;
            }
        }

        System.out.println("뭐야?");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
