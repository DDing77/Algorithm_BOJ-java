import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*author : dding77*/

public class Main {

    private final String[] works = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
    private HashMap<String, Integer> worksMap;

    public void makeWorks() {
        worksMap = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            worksMap.put(works[i], 0);
        }
    }

    public String getResult(double total) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%s %d %.2f", works[i], worksMap.get(works[i]), worksMap.get(works[i]) / total)).append('\n');
        }
        sb.append("Total ").append((int) total).append(" 1.00").append('\n');

        return sb.toString();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        makeWorks();
        double total = 0;

        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                total++;
                String cur = st.nextToken();
                if (worksMap.containsKey(cur)) {
                    worksMap.put(cur, worksMap.get(cur) + 1);
                }
            }
        }

        System.out.print(getResult(total));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
