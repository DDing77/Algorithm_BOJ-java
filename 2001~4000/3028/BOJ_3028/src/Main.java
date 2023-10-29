import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int[] cups;
    String input;

    public void typeA() {
        int temp = cups[0];
        cups[0] = cups[1];
        cups[1] = temp;
    }

    public void typeB() {
        int temp = cups[1];
        cups[1] = cups[2];
        cups[2] = temp;
    }

    public void typeC() {
        int temp = cups[0];
        cups[0] = cups[2];
        cups[2] = temp;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cups = new int[3];
        cups[0] = 1;

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char op = input.charAt(i);
            if (op == 'A') {
                typeA();
            } else if (op == 'B') {
                typeB();
            } else {
                typeC();
            }
        }

        for (int i = 0; i < cups.length; i++) {
            if (cups[i] == 1) {
                System.out.println(i + 1);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
