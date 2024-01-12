import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (620 <= N && N <= 780) {
            System.out.println("Red");
        }
        if (590 <= N && N < 620) {
            System.out.println("Orange");
        }
        if (570 <= N && N < 590) {
            System.out.println("Yellow");
        }
        if (495 <= N && N < 570) {
            System.out.println("Green");
        }
        if (450 <= N && N < 495) {
            System.out.println("Blue");
        }
        if (425 <= N && N < 450) {
            System.out.println("Indigo");
        }
        if (380 <= N && N < 425) {
            System.out.println("Violet");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
