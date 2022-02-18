import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int arr[][];
    static int AB[];
    static int CD[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        arr = new int[4][n];

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            String[] t = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(t[tmp]);
                tmp++;
            }
        }

        AB = new int[n * n];
        CD = new int[n * n];
        int idx_ab = 0;
        int idx_cd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx_ab] = arr[0][i] + arr[1][j];
                CD[idx_cd] = arr[2][i] + arr[3][j];
                idx_ab++;
                idx_cd++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int AB_idx = 0;
        int CD_idx = CD.length - 1;
        long ans = 0;
        while (AB_idx < AB.length && CD_idx >= 0) {
            int AB_sum = AB[AB_idx];
            int CD_sum = CD[CD_idx];
            long AB_cnt = 0;
            long CD_cnt = 0;
            int total = AB_sum + CD_sum;
            if (total == 0) {
                while (AB_idx < AB.length && AB_sum == AB[AB_idx]) {
                    AB_idx++;
                    AB_cnt++;
                }
                while (CD_idx >= 0 && CD_sum == CD[CD_idx]) {
                    CD_idx--;
                    CD_cnt++;
                }
                ans += AB_cnt * CD_cnt;
            } else if (total > 0) {
                CD_idx--;
            } else {
                AB_idx++;
            }
        }
        System.out.println(ans);
    }
}
