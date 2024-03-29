import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    long heroAttack;
    int[][] rooms;

    private boolean check(long heroHp) {

        long copyHeroHp = heroHp;
        long copyHeroAttack = heroAttack;

        boolean isClear = true;
        for (int i = 0; i < N; i++) {
            if (copyHeroHp == 0) {
                isClear = false;
                break;
            }

            if (rooms[i][0] == 2) {
                copyHeroAttack += rooms[i][1];
                copyHeroHp = Math.min(copyHeroHp + rooms[i][2], heroHp);
            } else {
                long heroAttackCount = (rooms[i][2] + (copyHeroAttack - 1)) / copyHeroAttack;
                long dragonAttackCount = (copyHeroHp + rooms[i][1] - 1) / rooms[i][1];

                if (heroAttackCount <= dragonAttackCount) {
                    copyHeroHp -= (heroAttackCount - 1) * rooms[i][1];
                } else {
                    isClear = false;
                    break;
                }
            }
        }

        return isClear;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        heroAttack = Long.parseLong(st.nextToken());

        rooms = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
            rooms[i][2] = Integer.parseInt(st.nextToken());
        }

        long left = 0;
        long right = Long.MAX_VALUE - 1;
        while (left + 1 < right) {
            long mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
