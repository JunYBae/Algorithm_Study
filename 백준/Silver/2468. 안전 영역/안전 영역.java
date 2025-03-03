import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
    static int N, answer, map[][];
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N]; 
        
        int max = 0;
        
        for (int x = 0; x < N; x++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for (int y = 0; y < N; y++) {
        		map[x][y] = Integer.parseInt(st.nextToken());
        		if(map[x][y] > max)
        			max = map[x][y];
        	}
        }
        
        
        for (int i = 0; i <= max; i++) {
        	
        	boolean visit[][] = new boolean[N][N];
        	int temp = 0;
        	
        	for (int x = 0; x < N; x++) { 
        		for(int y = 0; y < N; y++) {
        			if (map[x][y] > i && !visit[x][y])  {
        				visit[x][y] = true;
        				BFS(new Point(x, y), i, visit);
        				temp++;
        			}
        		}
        	}
        	
//        	for (int x = 0; x < N; x++) {
//        		for (int y = 0; y < N; y++)
//        			System.out.print(visit[x][y] ? 0 + " ": 1 + " ");
//        		System.out.println();
//        	}
//        	System.out.println();
        	
        	if (answer < temp)
        		answer = temp;
        }
        
        sb.append(answer).append("\n");
        System.out.println(sb.toString());
    }
    
    public static void BFS(Point start, int i, boolean visit[][]) {
    	
    	ArrayDeque<Point> queue = new ArrayDeque<Point>();
    	queue.add(start);
    	
    	while(!queue.isEmpty()) {
    		
    		Point point = queue.poll();
    		
    		for (int index = 0; index < dir.length; index++) {
    			
    			int x = point.x + dir[index][0];
    			int y = point.y + dir[index][1];
    			
    			if (is_In(x, y) && !visit[x][y] && map[x][y] > i) {
    				visit[x][y] = true;
    				queue.add(new Point(x, y));
    			}
    		}
    		
    	}	
    }
    
    public static boolean is_In (int x, int y) {
    	return x >= 0 && y >= 0 && x < N && y < N;
    }
}
