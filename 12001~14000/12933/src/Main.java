import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Character> list = new ArrayList<>();
    static String input;
    static String quack = "quack";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input  = br.readLine();
        for(int i=0; i<input.length(); i++) list.add(input.charAt(i));
        int cnt =0;
        while(!list.isEmpty()) {

        }
    }
}
