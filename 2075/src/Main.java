import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// author : DDing
// solution : 1번. 우선순위큐, 2. 정렬
// tip : 우선순위큐가 더 빠르다

// 우선순위 큐
public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        int res = 0;
        for(int i=0; i<N; i++) {
            res = pq.poll();
        }
        System.out.println(res);
    }
}

//// 정렬
//public class Main {
//    static ArrayList<Integer> list = new ArrayList<>();
//    static int N;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                list.add(Integer.parseInt(st.nextToken()));
//            }
//        }
//        Collections.sort(list, Collections.reverseOrder());
//        int res = list.get(N-1);
//        System.out.println(res);
//    }
//}