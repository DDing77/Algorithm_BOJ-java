import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int[] alpha = {
            3, 2, 1, 2,
            3, 3, 3, 3,
            1, 1, 3, 1,
            3, 3, 1, 2,
            2, 2, 1, 2,
            1, 1, 2, 2,
            2, 1
    };

    private String K;

    private ArrayList<Integer> ex(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();
        if (list.size() <= 1) {
            return list;
        }

        for (int i = 0; i < list.size() - 1; i += 2) {
            newList.add((list.get(i) + list.get(i + 1)) % 10);
        }
        if (list.size() % 2 != 0) {
            newList.add(list.get(list.size() - 1));
        }
        return newList;
    }

    private void solution() throws IOException {
        K = br.readLine();

        ArrayList<Integer> list = new ArrayList<>();
        for (char c : K.toCharArray()) {
            list.add(alpha[c - 'A']);
        }

        list = ex(list);
        while (list.size() > 1) {
            list = ex(list);
        }

        if (list.get(0) % 2 == 0) {
            System.out.println("You're the winner?");
        } else {
            System.out.println("I'm a winner!");
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
