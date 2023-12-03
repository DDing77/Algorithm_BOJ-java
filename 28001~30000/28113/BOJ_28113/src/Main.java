import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int A;
    int B;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int busTime = A;
        int trainTime = N;
        if (N > B) {
            System.out.println("Bus");
            return;
        }

        if (N == B) {
            trainTime = N;
        } else {
            trainTime = B;
        }

        if (busTime == trainTime) {
            System.out.println("Anything");
        } else if (busTime < trainTime) {
            System.out.println("Bus");
        } else {
            System.out.println("Subway");
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
