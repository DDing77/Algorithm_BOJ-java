import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static LinkedList<Character> list;
    static ListIterator<Character> iter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        list = new LinkedList<>();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) list.add(str.charAt(i));

        iter = list.listIterator();
        while (iter.hasNext()) iter.next();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            if (op == 'P') {
                char inject = st.nextToken().charAt(0);
                iter.add(inject);
            } else if (op == 'L') {
                if (iter.hasPrevious()) iter.previous();
            } else if (op == 'D') {
                if (iter.hasNext()) iter.next();
            } else if (op == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }


        for (char c : list) sb.append(c);

        System.out.println(sb);
    }
}