package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] cache = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
	        long power = i *i;
	        long start = min %power == 0 ? min / power : (min / power) + 1;
	        for(long j = start; power *j <=max; j++){
	            cache[(int)((j*power) - min)] = true;
            }
        }

        int count = 0;
        for(int i= 0 ; i <= max - min; i++) {
            if(!cache[i]) count++;
        }
        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
