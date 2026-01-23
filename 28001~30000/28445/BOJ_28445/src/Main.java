import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private HashSet<String> set = new HashSet<>();
    private List<String> colorList = new ArrayList<>();

    private void solution() throws IOException {
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                set.add(st.nextToken());
            }
        }

        colorList.addAll(set);

        Collections.sort(colorList);
        for (int i = 0; i < colorList.size(); i++) {
            for (int j = 0; j < colorList.size(); j++) {
                sb.append(colorList.get(i)).append(" ").append(colorList.get(j)).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
