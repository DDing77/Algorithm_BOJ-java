import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;
    int[] wordBit;
    long count;

    private void makeTestSentence(int idx, int temp) {

        if (Integer.bitCount(temp) == 26) {
            count++;
        }

        for (int i = idx; i < wordBit.length; i++) {
            makeTestSentence(i + 1, temp | wordBit[i]);
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        wordBit = new int[N];
        int checkAllBit = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                wordBit[i] |= 1 << (word.charAt(j) - 'a');
            }
            checkAllBit |= wordBit[i];
        }

        if (Integer.bitCount(checkAllBit) != 26) {
            System.out.println(0);
            return;
        }

        count = 0L;
        makeTestSentence(0, 0);

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
