import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;



        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] occurrences = new int[N * 2 - 1];

        // 빈도수 계산
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2 - 1; i++) {
            occurrences[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(occurrences);

        // 결과 출력
        int count = 0;
        for (int i = 0; i < N * 2 - 1; i++) {
            if (i % 2 == 0) {
                sb.append(occurrences[i]).append(" ");
                count++;
            }

            if (count == N) {
                break;
            }
        }

        if (count < N) {
            System.out.println("-1");
            return;
        }

        System.out.println(sb);
    }
}
