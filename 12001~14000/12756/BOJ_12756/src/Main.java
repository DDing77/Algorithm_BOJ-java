import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int aAttack;
    int aHp;
    int bAttack;
    int bHp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        aAttack = Integer.parseInt(st.nextToken());
        aHp = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        bAttack = Integer.parseInt(st.nextToken());
        bHp = Integer.parseInt(st.nextToken());

        while (aHp > 0 && bHp > 0) {
            aHp -= bAttack;
            bHp -= aAttack;
        }

        if (aHp <= 0 && bHp <= 0) {
            System.out.println("DRAW");
        } else if (aHp > 0 && bHp <= 0) {
            System.out.println("PLAYER A");
        } else if (aHp <= 0 && bHp > 0) {
            System.out.println("PLAYER B");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
