import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new HashMap<>();
        list.put("A+", "4.3");
        list.put("A0", "4.0");
        list.put("A-", "3.7");
        list.put("B+", "3.3");
        list.put("B0", "3.0");
        list.put("B-", "2.7");
        list.put("C+", "2.3");
        list.put("C0", "2.0");
        list.put("C-", "1.7");
        list.put("D+", "1.3");
        list.put("D0", "1.0");
        list.put("D-", "0.7");
        list.put("F", "0.0");

        String input = br.readLine();

        System.out.println(list.get(input));
    }
}
