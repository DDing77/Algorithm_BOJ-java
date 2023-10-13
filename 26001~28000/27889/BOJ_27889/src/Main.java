import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> map = new HashMap<>();
        map.put("NLCS", "North London Collegiate School");
        map.put("BHA", "Branksome Hall Asia");
        map.put("KIS", "Korea International School");
        map.put("SJA", "St. Johnsbury Academy");

        System.out.println(map.get(br.readLine()));
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
