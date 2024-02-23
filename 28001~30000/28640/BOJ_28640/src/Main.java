import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int[] blockA;
    int[] blockB;

    private void count(int[] block) throws IOException {
        String input = br.readLine();

        int idx = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '|') {
                idx++;
                continue;
            }
            block[idx]++;
        }
    }

    private void solution() throws IOException {

        blockA = new int[2];
        count(blockA);
        blockB = new int[2];
        count(blockB);

        if (blockA[0] == blockB[0]
                || blockA[0] == blockB[1]
                || blockA[1] == blockB[0]
                || blockA[1] == blockB[1]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
