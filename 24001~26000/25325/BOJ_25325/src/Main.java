import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private String[] names;
    private ArrayList<Like> likes;
    private Map<String, Integer> map;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        names = new String[N];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            names[i] = st.nextToken();
            map.put(names[i], 0);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                map.put(name, map.get(name) + 1);
            }
        }

        likes = new ArrayList<>();
        for (String name : names) {
            likes.add(new Like(name, map.get(name)));
        }

        Collections.sort(likes);

        for (Like like : likes) {
            sb.append(like.name).append(" ").append(like.vote).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Like implements Comparable<Like> {

        String name;
        int vote;

        public Like(String name, int vote) {
            this.name = name;
            this.vote = vote;
        }

        @Override
        public int compareTo(Like o) {
            if (this.vote == o.vote) {
                return this.name.compareTo(o.name);
            }
            return o.vote - this.vote;
        }
    }
}
