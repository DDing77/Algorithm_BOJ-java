import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int input;
    int resMin;
    int resMax;

    private void recur(int number, int oddCount) {

        int temp = number;
        int tempCount = 0;
        while (temp > 0) {
            if (temp % 2 == 1) {
                tempCount++;
            }
            temp /= 10;
        }

        //탈출
        if (number / 10 == 0) {
            resMin = Math.min(resMin, oddCount + tempCount);
            resMax = Math.max(resMax, oddCount + tempCount);
            return;
        }

        if (number / 100 == 0) {
            recur(number / 10 + number % 10, oddCount + tempCount);
        } else {
            String numberToString = String.valueOf(number);
            for (int i = 0; i < numberToString.length() - 2; i++) {
                for (int j = i + 1; j < numberToString.length() - 1; j++) {
                    int left = Integer.parseInt(numberToString.substring(0, i + 1));
                    int mid = Integer.parseInt(numberToString.substring(i + 1, j + 1));
                    int right = Integer.parseInt(numberToString.substring(j + 1));

                    int nextNumber = left + mid + right;
                    recur(nextNumber, oddCount + tempCount);
                }
            }
        }

    }

    private void solution() throws IOException {

        input = Integer.parseInt(br.readLine());
        resMin = Integer.MAX_VALUE;
        resMax = Integer.MIN_VALUE;

        recur(input, 0);

        sb.append(resMin).append(" ").append(resMax);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
