import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private HashMap<String, String> keyMap;

    public void makeKeyMap() {
        keyMap = new HashMap<>();
        keyMap.put("1", "`");
        keyMap.put("2", "1");
        keyMap.put("3", "2");
        keyMap.put("4", "3");
        keyMap.put("5", "4");
        keyMap.put("6", "5");
        keyMap.put("7", "6");
        keyMap.put("8", "7");
        keyMap.put("9", "8");
        keyMap.put("0", "9");
        keyMap.put("-", "0");
        keyMap.put("=", "-");
        keyMap.put("W", "Q");
        keyMap.put("E", "W");
        keyMap.put("R", "E");
        keyMap.put("T", "R");
        keyMap.put("Y", "T");
        keyMap.put("U", "Y");
        keyMap.put("I", "U");
        keyMap.put("O", "I");
        keyMap.put("P", "O");
        keyMap.put("[", "P");
        keyMap.put("]", "[");
        keyMap.put("\\", "]");
        keyMap.put("S", "A");
        keyMap.put("D", "S");
        keyMap.put("F", "D");
        keyMap.put("G", "F");
        keyMap.put("H", "G");
        keyMap.put("J", "H");
        keyMap.put("K", "J");
        keyMap.put("L", "K");
        keyMap.put(";", "L");
        keyMap.put("'", ";");
        keyMap.put("X", "Z");
        keyMap.put("C", "X");
        keyMap.put("V", "C");
        keyMap.put("B", "V");
        keyMap.put("N", "B");
        keyMap.put("M", "N");
        keyMap.put(",", "M");
        keyMap.put(".", ",");
        keyMap.put("/", ".");
        keyMap.put(" ", " ");
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        makeKeyMap();

        String input;
        while ((input = br.readLine()) != null) {
            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                sb.append(keyMap.get(String.valueOf(cur)));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
