import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int res;
    static int[][] gear;
    static boolean[] isRotate;

    static int getScore() {
        int sum = 0;

        // 1st gear
        if (gear[0][0] == 1) sum += 1;
        // 2st gear
        if (gear[1][0] == 1) sum += 2;
        // 3st gear
        if (gear[2][0] == 1) sum += 4;
        // 4st gear
        if (gear[3][0] == 1) sum += 8;

        return sum;
    }

    static void changeSN(int gearNum, int dir) {
        int temp = gear[gearNum][0];

        if (dir == -1) { // 반시계 방향 회전
            gear[gearNum][0] = gear[gearNum][1];
            gear[gearNum][1] = gear[gearNum][2];
            gear[gearNum][2] = gear[gearNum][3];
            gear[gearNum][3] = gear[gearNum][4];
            gear[gearNum][4] = gear[gearNum][5];
            gear[gearNum][5] = gear[gearNum][6];
            gear[gearNum][6] = gear[gearNum][7];
            gear[gearNum][7] = temp;
        } else { // 시계 방향 회전
            gear[gearNum][0] = gear[gearNum][7];
            gear[gearNum][7] = gear[gearNum][6];
            gear[gearNum][6] = gear[gearNum][5];
            gear[gearNum][5] = gear[gearNum][4];
            gear[gearNum][4] = gear[gearNum][3];
            gear[gearNum][3] = gear[gearNum][2];
            gear[gearNum][2] = gear[gearNum][1];
            gear[gearNum][1] = temp;
        }
    }

    static void rotate(int target, int dir) {
        // 톱니바퀴 0 ~ 3
        // 오른쪽 톱니 2, 왼쪽 톱니 6
        if (target < 0 || target > 3) return;

        isRotate[target] = true;

        // 왼쪽이랑 다름
        if (target - 1 >= 0 && gear[target - 1][2] != gear[target][6]) {
            if (!isRotate[target - 1]) rotate(target - 1, -dir);
        }
        // 오른쪽이랑 다름
        if (target + 1 < 4 && gear[target][2] != gear[target + 1][6]) {
            if (!isRotate[target + 1]) rotate(target + 1, -dir);
        }
        // 회전
        changeSN(target, dir);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gear = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNumber = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            isRotate = new boolean[4];
            rotate(gearNumber - 1, dir);
        }

        res = getScore();
        System.out.println(res);
    }
}