import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int[] even = new int[50];
    int[] odd = new int[50];

    int N;
    int res;

    private void solution() throws IOException {

        int number = 1;
        for (int i = 0; i < even.length; i++) {
            odd[i] = number;
            even[i] = odd[i] + 1;
            number += 2;
        }

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            if (N % 2 == 0) {
                int count = 0;
                int left = -1;
                int right = even.length;
                while (left + 1 < right) {
                    int mid = (left + right) >> 1;
                    count++;
                    if (even[mid] > N) {
                        right = mid;
                    } else if (even[mid] == N) {
                        break;
                    } else {
                        left = mid;
                    }
                }
                System.out.println(count);
            } else {
                int count = 1;
                int left = -1;
                int right = odd.length;
                while (left + 1 < right) {
                    int mid = (left + right) >> 1;
                    count++;
                    if (odd[mid] == N) {
                        break;
                    } else if (odd[mid] < N) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                System.out.println(count);
            }


        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
