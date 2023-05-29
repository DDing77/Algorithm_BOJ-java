import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, B, W;
    static char[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        map = input.toCharArray();

        int L = 0;
        int R = 0;
        int bCnt = 0;
        int wCnt = 0;
        int max = 0;
        int length = 0;
//        if (map[0] == 'B') bCnt++;
//        else wCnt++;
        while (R < N && L <= R) {
            if (bCnt <= B) {
                if (map[R] == 'B') {
                    bCnt++;
                } else {
                    wCnt++;
                }
                R++;
                length++;
            } else if (bCnt > B) {
//                System.out.println(" down -> L : " + L + " R : " + R);
                if (map[L] == 'B') {
                    bCnt--;
                } else {
                    wCnt--;
                }
                L++;
                length--;
            }
            if (bCnt <= B && wCnt >= W) max = Math.max(max, length);
        }
//        if(max- B < W) System.out.println(0);
        System.out.println(max);
    }
}
