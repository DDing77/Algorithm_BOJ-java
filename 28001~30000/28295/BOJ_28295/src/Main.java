import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int dir = 0;

    private void solution() throws IOException {
        for (int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 1) {
                dir++;
            }
            if(input == 2) {
                dir += 2;
            }
            if(input == 3) {
                if(dir == 0) {
                    dir = 3;
                } else {
                    dir--;
                }
            }
        }

        dir %= 4;
        if(dir == 0) {
            System.out.println("N");
        }
        if(dir == 1) {
            System.out.println("E");
        }
        if(dir == 2) {
            System.out.println("S");
        }
        if(dir == 3) {
            System.out.println("W");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
