import java.io.*;
import java.util.*;

public class Main {
    static int N , max;
    static int[] time, pretime, indegree;
    static ArrayList<Integer>[] list;
    static void solution(StringBuilder sb){
        Deque<Integer> dq = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                dq.add(i);
                pretime[i] = time[i];
            }
        }
        while(!dq.isEmpty()) {
            int X = dq.poll();
            max = 0;
            for(int Y : list[X]) {
                indegree[Y]--;
                if(indegree[Y] == 0) dq.add(Y);
                pretime[Y] = Math.max(pretime[Y], pretime[X] + time[Y] );
            }
        }
        for(int i=1; i<=N; i++) {
            sb.append(pretime[i]).append('\n');
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }

        time = new int[N + 1];
        pretime = new int[N+1];
        indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split(" ");
            if (str.length == 2) {
                time[i] = Integer.parseInt(str[0]);
            } else {
                time[i] = Integer.parseInt(str[0]);
                for(int j= 1; j<str.length-1; j++){
                    indegree[i]++;
                    list[Integer.parseInt(str[j])].add(i);
                }
            }
        }

        solution(sb);
//        for(int i=1; i<=N; i++) {
//            System.out.println(indegree[i]);
//        }
//        for(int i=1; i<=N; i++) {
//            for(int j=0; j<list[i].size(); j++) {
//                System.out.print(list[i].get(j));
//            }
//            System.out.println('\n');
//        }
    }
}