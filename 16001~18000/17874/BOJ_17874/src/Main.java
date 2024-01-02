import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int n;
    int h;
    int v;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // 가로와 세로 각각의 최대 조각 찾기
        int maxHorizontal = Math.max(h, n - h);
        int maxVertical = Math.max(v, n - v);

        // 최대 조각의 부피 계산
        int volume = 4 * maxHorizontal * maxVertical;

        // 결과 출력
        System.out.println(volume);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
