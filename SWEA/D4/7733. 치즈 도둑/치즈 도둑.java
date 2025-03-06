import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	
	static int N, answer, map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
    public static void main(String[] args) throws IOException {
    	
    	// br, st 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();	
    	
    	int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
    	for (int test_case = 1; test_case <= T; test_case++) {
    		N = Integer.parseInt(br.readLine()); // 맵 크기
    		
    		map = new int[N][N]; // 맵 만들기
    		answer = 0;
    		int max = 0;
    		
    		
    		for (int x = 0; x < N; x++) {
    			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    			for (int y = 0; y < N; y++) {
    				map[x][y] = Integer.parseInt(st.nextToken());
    				if (max < map[x][y])
    					max = map[x][y];
    			}
    		}
    		
    		for (int index = 0; index <= max; index++) {
    			
    			boolean visit[][] = new boolean[N][N];
    			int count = 0;
    			
    			for (int x = 0; x < N; x++) {
    				for (int y = 0; y < N; y++) {
    					if (index < map[x][y] && !visit[x][y]) {
    						visit[x][y] = true;
    						BFS(new Point(x, y), index, visit);
    						count++;
    					}
    				}
    			}
    			
    			if (count > answer)
    				answer = count;
    		}

    		sb.append("#").append(test_case).append(" ").append(answer).append("\n");
    	}
    	// 정답 출력 
    	System.out.println(sb.toString());
    }
    
    public static void BFS(Point start, int index, boolean visit[][]) {
    	
    	ArrayDeque<Point> queue = new ArrayDeque<>();
    	queue.add(start);
    	
    	while(!queue.isEmpty()) {
    		
    		Point point = queue.poll();
    		
    		for (int i = 0; i < dir.length; i++) {
    			int x = point.x + dir[i][0];
    			int y = point.y + dir[i][1];
    			
    			if (is_In(x, y) && index < map[x][y] && !visit[x][y]) {
    				visit[x][y] = true;
    				queue.add(new Point(x, y));
    			}
    		}
    	}
    }

    
    public static boolean is_In(int x, int y) {
    	return x >= 0 && y >= 0 && x < N && y < N;
    }
}

