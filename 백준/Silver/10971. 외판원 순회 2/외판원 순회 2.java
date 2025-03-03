import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, answer, map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N]; 
        answer = Integer.MAX_VALUE;

        for (int x = 0; x < N; x++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for (int y = 0; y < N; y++)
        		map[x][y] = Integer.parseInt(st.nextToken());
        }
        
        for (int start = 0; start < N; start++) {
        	boolean visit[] = new boolean[N];
        	backTracking(start, 0, 0, visit, start);
        }
  
        sb.append(answer).append("\n");
        System.out.println(sb.toString());
    }
    
    public static void backTracking (int vertex, int length, int cost, boolean visit[], int start) {
    	
    	if (answer < cost)
    		return;
    	
    	if (length == N  && vertex == start) {
    		if (cost < answer)
    			answer = cost;
    	}
    	
    	for (int i = 0; i < N; i++) {

    		if (!visit[i] && map[vertex][i] != 0) {
    			visit[i] = true;
    			backTracking(i, length+1, cost+map[vertex][i], visit, start);
    			visit[i] = false;
    		}
    		
    	}
    }
} 


