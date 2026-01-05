import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[] mappingTable = {
            3, 2, 1, 2, 4,
            3, 1, 3, 1, 1,
            3, 1, 3, 2, 1,
            2, 2, 2, 1, 2,
            1, 1, 1, 2, 2, 1
    };

    private int N;
    private String A;
    private int M;
    private String B;


    private List<Integer> calculate(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            int sum = numbers.get(i - 1) + numbers.get(i);
            result.add(sum % 10);
        }
        return result;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        int idx = 0;
        int arrIdx = 0;
        char[] tempArr = new char[N + M];
        while (idx < N && idx < M) {
            tempArr[arrIdx++] = A.charAt(idx);
            tempArr[arrIdx++] = B.charAt(idx++);
        }

        while (idx < N) {
            tempArr[arrIdx++] = A.charAt(idx++);
        }

        while (idx < M) {
            tempArr[arrIdx++] = B.charAt(idx++);
        }

        List<Integer> numbers = new ArrayList<>();
        for (char c : tempArr) {
            numbers.add(mappingTable[c - 'A']);
        }

        while (numbers.size() > 2) {
            numbers = calculate(numbers);
        }

        int res = numbers.get(0) * 10 + numbers.get(1);
        System.out.println(res + "%");
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
