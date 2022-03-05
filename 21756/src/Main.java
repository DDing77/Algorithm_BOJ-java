import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++) list.add(i);
        while(list.size() >= 2) {
            for(int i=0; i< list.size(); i++) {
                list.remove(i);
            }
        }
        System.out.println(list.get(0));
    }
}