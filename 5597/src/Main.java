import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        list = new ArrayList<>();

        for (int i = 1; i <= 30; i++) list.add(i);

        for (int i = 1; i <= 28; i++) {
            int input = Integer.parseInt(br.readLine());
            list.remove(list.indexOf(input));
        }

        sb.append(list.get(0)).append('\n');
        sb.append(list.get(1)).append('\n');

        System.out.print(sb);
    }
}
