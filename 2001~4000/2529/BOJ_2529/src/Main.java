import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int k;
    private boolean[] isVisited;
    private char[] signs;
    private int[] nums;
    private long min, max;

    public void backTracking(String number, int depth) {
        if (depth == k + 1) {
            min = Math.min(min, Long.parseLong(number));
            max = Math.max(max, Long.parseLong(number));
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!isVisited[i]) {
                if (depth == 0) {
                    isVisited[i] = true;
                    backTracking(String.valueOf(i), depth + 1);
                    isVisited[i] = false;
                } else {
                    int left = number.charAt(depth - 1) - '0';
                    int right = i;
                    char op = signs[depth - 1];
                    String temp = number + i;
                    if (op == '<') {
                        if (left < right) {
                            isVisited[i] = true;
                            backTracking(temp, depth + 1);
                            isVisited[i] = false;
                        }
                    } else {
                        if (left > right) {
                            isVisited[i] = true;
                            backTracking(temp, depth + 1);
                            isVisited[i] = false;
                        }
                    }
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        signs = new char[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            signs[i] = st.nextToken().charAt(0);
        }


        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        isVisited = new boolean[10];
        nums = new int[k + 1];

        backTracking("", 0);

        int maxLength = String.valueOf(max).length();
        while (maxLength < k + 1) {
            sb.append(0);
            maxLength++;
        }
        sb.append(max).append('\n');

        int minLength = String.valueOf(min).length();
        while (minLength < k + 1) {
            sb.append(0);
            minLength++;
        }
        sb.append(min).append('\n');

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
