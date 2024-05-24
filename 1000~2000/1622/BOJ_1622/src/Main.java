import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String a;
    private String b;
    private int[] aCount;
    private int[] bCount;

    private void solution() throws IOException {

        String input;
        while ((input = br.readLine()) != null) {
            a = input;
            b = br.readLine();

            aCount = new int[26];
            bCount = new int[26];

            for (int i = 0; i < a.length(); i++) {
                aCount[a.charAt(i) - 'a']++;
            }

            for (int i = 0; i < b.length(); i++) {
                bCount[b.charAt(i) - 'a']++;
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < aCount.length; i++) {
                if (aCount[i] != 0 && bCount[i] != 0) {
                    for (int j = 0; j < Math.min(aCount[i], bCount[i]); j++) {
                        res.append((char) (i + 'a'));
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
