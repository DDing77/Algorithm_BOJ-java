import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        int size = 0;
        while(true){
            String word = br.readLine();

            if(word == null || word.equals("")) break;

            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
            size++;
        }

        Object[] str = map.keySet().toArray();
        Arrays.sort(str);

        for(Object obj:str){
            String key = (String) obj;
            String value = String.format("%.4f", (map.get(key) * 100.0f/ size));

            sb.append(key).append(' ').append(value).append('\n');
        }
        System.out.print(sb);
    }
}