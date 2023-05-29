import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] vote;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        vote = new int[2];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            vote[num]++;
        }

        if (vote[0] > vote[1]) System.out.println("Junhee is not cute!");
        else System.out.println("Junhee is cute!");
    }
}