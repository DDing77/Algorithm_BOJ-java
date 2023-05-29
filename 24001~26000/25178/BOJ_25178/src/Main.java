import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int N;
    private String[] input;
    private int[] alphaA, alphaB;

    public boolean isAEIOU(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public boolean isSame() {
        for (int i = 0; i < 26; i++) {
            if (alphaA[i] != alphaB[i]) {
                return false;
            }
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        alphaA = new int[26];
        alphaB = new int[26];

        input = new String[2];
        input[0] = br.readLine();
        input[1] = br.readLine();

        StringBuilder aTemp = new StringBuilder();
        StringBuilder bTemp = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char chA = input[0].charAt(i);
            char chB = input[1].charAt(i);

            alphaA[chA - 'a']++;
            alphaB[chB - 'a']++;

            if (i == 0 || i == N - 1) {
                aTemp.append(input[0].charAt(i));
                bTemp.append(input[1].charAt(i));
                continue;
            }

            if (!isAEIOU(chA)) {
                aTemp.append(chA);
            }

            if (!isAEIOU(chB)) {
                bTemp.append(chB);
            }
        }

        if (aTemp.toString().equals(bTemp.toString()) && isSame()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
