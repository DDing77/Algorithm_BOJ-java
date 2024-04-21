import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    public static final HashMap<String, int[]> directions = new HashMap<>();

    private void init() {

        directions.put("R", new int[]{0, 1});
        directions.put("L", new int[]{0, -1});
        directions.put("B", new int[]{-1, 0});
        directions.put("T", new int[]{1, 0});
        directions.put("RT", new int[]{1, 1});
        directions.put("LT", new int[]{1, -1});
        directions.put("RB", new int[]{-1, 1});
        directions.put("LB", new int[]{-1, -1});
    }

    private int[] getCoordinate(String input) {

        int y = input.charAt(0) - 'A';
        int x = input.charAt(1) - '0' - 1;
        return new int[]{x, y};
    }

    private boolean isRangeIn(int x, int y) {

        return x < 0 || x >= 8 || y < 0 || y >= 8;
    }

    private void solution() throws IOException {

        init();
        st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int[] kingCoordinate = getCoordinate(king);
        int[] stoneCoordinate = getCoordinate(stone);

        for (int i = 0; i < N; i++) {
            String dir = br.readLine();
            int[] nextDirInfo = directions.get(dir);
            int nextKingX = kingCoordinate[0] + nextDirInfo[0];
            int nextKingY = kingCoordinate[1] + nextDirInfo[1];

            if (isRangeIn(nextKingX, nextKingY)) {
                continue;
            }
            if (nextKingX == stoneCoordinate[0] && nextKingY == stoneCoordinate[1]) {
                int nextStoneX = stoneCoordinate[0] + nextDirInfo[0];
                int nextStoneY = stoneCoordinate[1] + nextDirInfo[1];
                if (isRangeIn(nextStoneX, nextStoneY)) {
                    continue;
                }
                stoneCoordinate[0] = nextStoneX;
                stoneCoordinate[1] = nextStoneY;
            }
            kingCoordinate[0] = nextKingX;
            kingCoordinate[1] = nextKingY;
        }

        sb.append((char) (kingCoordinate[1] + 'A')).append(kingCoordinate[0] + 1).append("\n");
        sb.append((char) (stoneCoordinate[1] + 'A')).append(stoneCoordinate[0] + 1).append("\n");
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
