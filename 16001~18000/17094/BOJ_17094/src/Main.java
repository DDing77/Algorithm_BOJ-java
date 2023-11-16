import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int length;
    String input;
    int[] cnt;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        input = br.readLine();

        cnt = new int[2];
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == '2') {
                cnt[0]++;
            } else {
                cnt[1]++;
            }
        }

        if (cnt[0] == cnt[1]) {
            System.out.println("yee");
        } else if (cnt[0] > cnt[1]) {
            System.out.println("2");
        } else {
            System.out.println("e");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
