import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    HashMap<String, String> map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new HashMap<>();
        map.put("SONGDO", "HIGHSCHOOL");
        map.put("CODE", "MASTER");
        map.put("2023", "0611");
        map.put("ALGORITHM", "CONTEST");

        System.out.println(map.get(br.readLine()));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
