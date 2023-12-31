import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    final HashMap<String, String> clubs = new HashMap<>();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        clubs.put("M", "MatKor");
        clubs.put("W", "WiCys");
        clubs.put("C", "CyKor");
        clubs.put("A", "AlKor");
        clubs.put("$", "$clear");

        System.out.println(clubs.get(br.readLine()));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
