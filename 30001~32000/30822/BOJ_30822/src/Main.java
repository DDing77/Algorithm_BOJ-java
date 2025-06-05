import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[] counts = new int[26];

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for (char c : input.toCharArray()) {
            counts[c - 'a']++;
        }

        int max = N;
        max = Math.min(max, counts['u' - 'a']);
        max = Math.min(max, counts['o' - 'a']);
        max = Math.min(max, counts['s' - 'a']);
        max = Math.min(max, counts['p' - 'a']);
        max = Math.min(max, counts['c' - 'a']);

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
