import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[] fruits;
    private HashSet<Integer> fruitSet;
    private HashMap<Integer, Integer> fruitMap;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        fruits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        fruitSet = new HashSet<>();
        fruitMap = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < N) {
            fruitSet.add(fruits[right]);
            fruitMap.put(fruits[right], fruitMap.getOrDefault(fruits[right], 0) + 1);
            right++;
            while (fruitSet.size() > 2) {
                fruitMap.put(fruits[left], fruitMap.get(fruits[left]) - 1);
                if (fruitMap.get(fruits[left]) == 0) {
                    fruitSet.remove(fruits[left]);
                    fruitMap.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
