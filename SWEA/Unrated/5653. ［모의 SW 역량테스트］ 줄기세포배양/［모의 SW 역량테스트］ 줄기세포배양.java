import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Cell implements Comparable<Cell> {
	
	int x, y, life, breeding_time;
	
	Cell(int x, int y, int life, int breeding_time) {
		this.x = x; // x
		this.y = y; // y
		this.life = life; // 생명력
		this.breeding_time = breeding_time; // 번식하는 시간
	}

	@Override
	public int compareTo(Cell other) {
		if(this.breeding_time != other.breeding_time)
			return Integer.compare(this.breeding_time, other.breeding_time); // 먼저 번식하는
		return Integer.compare(this.life, other.life) * -1; // 생명력이 더 쌘 친구
	}
}



public class Solution {
	
	static int N, M, K; 
	static HashMap<String, Integer> map; // x,y -> 죽는 시간
	static int dir[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static PriorityQueue<Cell> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			K = Integer.parseInt(st.nextToken()); // 목표 시간 
			
			map = new HashMap<>(); // 배양틀
			queue = new PriorityQueue<>(); // 줄기세포 넣는 큐
			
			// 값 집어넣음
			// 값 집어넣음
			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < M; y++) {
					int temp = Integer.parseInt(st.nextToken());
					
					if (temp != 0) {
						int dead_time = temp * 2;
						map.put(x + " " + y, dead_time); 
						queue.add(new Cell(x, y, temp, temp+1)); // 번식은 x+1 생명력때함
					}
				}
			}
			
			breeding();
			int count = 0;
			
			Set<String> keys = map.keySet();
			for (String key : keys) {
//				System.out.print(map.get(key));
				if (map.get(key) > K)
					count++;
			}
			
			System.out.println("#" + test_case + " " + count);
		}
	}
	
	public static void breeding() {
		
		int cur_time = 0; //  현재 시간
		
		do {
			
			// 현재 시간이 번식 하는 시간이면?
			while(!queue.isEmpty() && queue.peek().breeding_time == cur_time) {
				
				Cell cell = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int x = cell.x + dir[i][0];
					int y = cell.y + dir[i][1];
					int breeding_time = (cell.life + 1) + cur_time;
					int dead_time = cell.life * 2 + cur_time;
					
					if (is_In(x,y, dead_time)) {
						queue.add(new Cell(x, y, cell.life, breeding_time));
					}
				}
				
			}
			
		} while(cur_time++ != K); // 현재 시간과 같을때까지
		
	}
	
	public static boolean is_In(int x, int y, int dead_time) {
		
		if (map.containsKey(x + " " + y))
			return false;
		
		map.put((x + " " + y), dead_time);
		return true;
	}
	
}












