import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int T;
    private ArrayList<int[]> list = new ArrayList<>();

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            list.clear();
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    list.add(new int[]{i, num / i});
                }
            }

            boolean flg = false;
            int size = list.size();
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    int[] left = list.get(i);
                    int[] right = list.get(j);
                    if (Math.abs(left[0] - left[1]) == Math.abs(right[0] + right[1])) {
                        flg = true;
                        break;
                    }
                }
            }

            sb.append(num).append(" is ");
            if (!flg) {
                sb.append("not nasty");
            } else {
                sb.append("nasty");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
