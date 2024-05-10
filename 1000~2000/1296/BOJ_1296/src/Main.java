import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private String yeondooName;
    private LinkedHashMap<Character, Integer> loveMap;
    private int N;
    private ArrayList<Team> teams;

    private void init() {

        loveMap = new LinkedHashMap<>();
        loveMap.put('L', 0);
        loveMap.put('O', 0);
        loveMap.put('V', 0);
        loveMap.put('E', 0);
    }

    private int[] createCountArray() {

        int[] count = new int[loveMap.size()];
        int idx = 0;
        for (Integer value : loveMap.values()) {
            count[idx++] = value;
        }
        return count;
    }

    private int calculate(int[] count) {

        int sum = 1;
        for (int i = 0; i < count.length - 1; i++) {
            for (int j = i + 1; j < count.length; j++) {
                sum *= (count[i] + count[j]);
            }
        }
        return sum % 100;
    }

    private void solution() throws IOException {

        init();

        yeondooName = br.readLine();
        for (int i = 0; i < yeondooName.length(); i++) {
            char cur = yeondooName.charAt(i);
            if (loveMap.containsKey(cur)) {
                loveMap.put(cur, loveMap.get(cur) + 1);
            }
        }

        teams = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int[] count = createCountArray();

            for (int j = 0; j < teamName.length(); j++) {
                char cur = teamName.charAt(j);
                if (cur == 'L') {
                    count[0]++;
                } else if (cur == 'O') {
                    count[1]++;
                } else if (cur == 'V') {
                    count[2]++;
                } else if (cur == 'E') {
                    count[3]++;
                }
            }

            teams.add(new Team(teamName, calculate(count)));
        }

        Collections.sort(teams);
        System.out.println(teams.get(0).name);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Team implements Comparable<Team> {

        String name;

        int value;

        public Team(String name, int value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public int compareTo(Team o) {
            if (this.value == o.value) {
                return this.name.compareTo(o.name);
            }
            return Integer.compare(o.value, this.value);
        }
    }
}
