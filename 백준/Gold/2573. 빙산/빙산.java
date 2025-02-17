import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Point {
	int x, y; 
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]"; 
	}
}

public class Main {
	
	static int N, M, map[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static LinkedList<Point> ice_list;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ice_list = new LinkedList<>();
		
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int y = 0; y < M; y++) {
				map[x][y] = Integer.parseInt(st.nextToken());
				
				if(map[x][y] != 0) 
					ice_list.add(new Point(x, y));
			}
		}
		
		
		int year = 0;
		
		while(!ice_list.isEmpty()) {
			
			if (is_sperate()) 
				break;
			
			LinkedList<Point> temp = (LinkedList<Point>) ice_list.clone();
			int copy_map[][] = new int[N][M];
			for (int i = 0; i < N; i++)
				copy_map[i] = map[i].clone();
			
			for (Point ice : temp) {				
				
				int water_size = 0;
				
				for (int i = 0; i < 4; i++) {
					
					int x = ice.x + dir[i][0];
					int y = ice.y + dir[i][1];
					
					if(is_In(x, y) && map[x][y] == 0)
						water_size++;
				}
				
				
				copy_map[ice.x][ice.y] = Math.max(0, map[ice.x][ice.y] - water_size);
				if (copy_map[ice.x][ice.y] == 0) 
					ice_list.remove(ice);
					
			}
			
			map = copy_map.clone();
			year++;
		}
		
		System.out.println(ice_list.isEmpty() ? 0 : year);
	}
	
	
	public static boolean is_sperate() {
		
		Point point_init = ice_list.peek();	
		ArrayDeque<Point> queue = new ArrayDeque<>();
		queue.add(point_init);
		boolean visit[][] = new boolean[N][M];
		visit[point_init.x][point_init.y] = true;
		
		while(!queue.isEmpty()) {
				
			Point point = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int x = point.x + dir[i][0];
				int y = point.y + dir[i][1];
				
				if (is_In(x, y) && map[x][y] != 0 && !visit[x][y]) {
					queue.add(new Point(x, y));
					visit[x][y] = true;
				}
				
			}
		}
		
		
		for (Point point : ice_list) {
			if (visit[point.x][point.y] == false)
				return true;
		}
		
		return false;
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < M)
			return true;
		return false;
	}
}












