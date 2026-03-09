import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private String[] numbers;
    private int[] oneCntArr;
    private long res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new String[N];
        oneCntArr = new int[20];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.toBinaryString(Integer.parseInt(br.readLine()));
            for (int j = 0; j < numbers[i].length(); j++) {
                if (numbers[i].charAt(numbers[i].length() - 1 - j) == '1') {
                    oneCntArr[j]++;
                }
            }
        }

        for (int i = 0; i < oneCntArr.length; i++) {
            res += (1L << i) * (long) oneCntArr[i] * (numbers.length - oneCntArr[i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
