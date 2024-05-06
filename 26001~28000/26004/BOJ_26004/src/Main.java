import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private String input;
    private HashMap<Character, Integer> map;
    private int res;

    private void initMap() {

        map = new HashMap<>();
        map.put('H', 0);
        map.put('I', 0);
        map.put('A', 0);
        map.put('R', 0);
        map.put('C', 0);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        initMap();

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            }
        }

        res = Integer.MAX_VALUE;
        for (int value : map.values()) {
            if (value == 0) {
                res = 0;
                break;
            }
            res = Math.min(res, value);
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
