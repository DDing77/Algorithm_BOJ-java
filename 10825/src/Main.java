import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Elem implements Comparable<Elem> {
        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem o) {
            if (korean != o.korean) return o.korean - korean;
            if (english != o.english) return english - o.english;
            if (math != o.math) return o.math - math;
            return name.compareTo(o.name);
        }
    }

    static int N;
    static Elem[] inst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        inst = new Elem[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inst[i] = new Elem();
            inst[i].name = st.nextToken();
            inst[i].korean = Integer.parseInt(st.nextToken());
            inst[i].english = Integer.parseInt(st.nextToken());
            inst[i].math = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inst);
        for (int i = 0; i < N; i++) {
            sb.append(inst[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }
}