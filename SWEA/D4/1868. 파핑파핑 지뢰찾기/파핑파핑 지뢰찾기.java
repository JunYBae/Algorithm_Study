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
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

public class Solution {
	
	static int N, answer, map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
	
    public static void main(String[] args) throws IOException {
    	
    	// br, st 
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();	
    	
    	int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 
    	for (int test_case = 1; test_case <= T; test_case++) {
    		N = Integer.parseInt(br.readLine()); // 맵 크기
    		
    		map = new int[N][N]; // 맵 만들기
    		answer = 0;
    		
    		for (int x = 0; x < N; x++) { // 값 저장 
    			String str = br.readLine(); 
    			for (int y = 0; y < N; y++) {
    				if(str.charAt(y) == '.') 
    					map[x][y] = 0;
    				else
    					map[x][y] = 1;
    			}
    		}
    		
    		for (int x = 0; x < N; x++) {
    			for (int y = 0; y < N; y++) {
    			
    				if (map[x][y] != 0)
    					continue;
    				
    				boolean is_empty = true;
    				
    				for (int i = 0; i < dir.length; i++) {
    					int cur_x = x + dir[i][0];
    					int cur_y = y + dir[i][1];
    					
    					if (is_In(cur_x, cur_y) && map[cur_x][cur_y] == 1) {
    						is_empty = false;
    						break;
    					}
    				}
    				
    				if (is_empty) {
    					BFS(new Point(x, y));
    					answer++;
    				}				
    			}
    		}
    		
    		for (int x = 0; x < N; x++) {
    			for (int y = 0; y < N; y++)
    				if (map[x][y] == 0)
    					answer++;
    		}

    		
    		sb.append("#").append(test_case).append(" ").append(answer).append("\n");
    	}
    	// 정답 출력 
    	System.out.println(sb.toString());
    }
    
    public static void BFS(Point start) {
    	
    	ArrayDeque<Point> queue = new ArrayDeque<>();
    	queue.add(start);
    	map[start.x][start.y] = 2;
    	
    	while(!queue.isEmpty()) {
    		
    		Point point = queue.poll();
    		map[point.x][point.y] = 2; 
    		ArrayList<Point> list = new ArrayList<Point>();
    		boolean is_empty = true;
    		
    		for (int i = 0; i < dir.length; i++) {
    			int x = point.x + dir[i][0];
    			int y = point.y + dir[i][1];
    			
    			if (is_In(x, y)) {
    				
    				if (map[x][y] == 1) {
    					is_empty = false;
    				}
    				
    				else if (map[x][y] == 0){
    					list.add(new Point(x, y));
    				}
    				
    			}	
    		}
    		
    		if (is_empty) {
    			for (Point temp : list)
					map[temp.x][temp.y] = 2;
    			queue.addAll(list);
    		}
    		
    	}
    	
    }
    
    
    public static boolean is_In(int x, int y) {
    	return x >= 0 && y >= 0 && x < N && y < N;
    }
}

