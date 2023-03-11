import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private int N;
    private String input;
    private int sumA, sumB;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sumA = 0;
        sumB = 0;
        N = Integer.parseInt(br.readLine());
        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == 'A') {
                sumA++;
            } else {
                sumB++;
            }
        }

        if (sumA == sumB) {
            System.out.println("Tie");
        } else if (sumA > sumB) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
