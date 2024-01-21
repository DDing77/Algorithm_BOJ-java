import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static final Map<String, String> type = new HashMap<>();

    String input;

    private void init() {
        type.put("fdsajkl;", "in-out");
        type.put("jkl;fdsa", "in-out");
        type.put("asdf;lkj", "out-in");
        type.put(";lkjasdf", "out-in");
        type.put("asdfjkl;", "stairs");
        type.put(";lkjfdsa", "reverse");
    }

    private void solution() throws IOException {
        input = br.readLine();

        if (type.containsKey(input)) {
            System.out.println(type.get(input));
            return;
        }

        System.out.println("molu");
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.init();
        main.solution();
    }
}
