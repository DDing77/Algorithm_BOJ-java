import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] cards;

    public static void swap(int left, int right) {
        while (left < right) {
            int temp = cards[left];
            cards[left] = cards[right];
            cards[right] = temp;
            left++;
            right--;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        cards = new int[21];
        for (int i = 1; i <= 20; i++) {
            cards[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            swap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= 20; i++) {
            sb.append(cards[i] + " ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
