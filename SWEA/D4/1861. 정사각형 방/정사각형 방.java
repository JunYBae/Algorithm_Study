import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, map[][], max_move, max_room_num;
	static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine()); // 방 크기
			map = new int[N][N]; 
			max_move = 0; // 최대 이동 수 
			max_room_num = Integer.MAX_VALUE; // 최대 
			
			for (int x = 0; x < N; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++)
					map[x][y] = Integer.parseInt(st.nextToken());
			}
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					int move_count = BFS(x, y);
					
					if (max_move < move_count) {
						max_move = move_count;
						max_room_num = map[x][y];
					} else if (max_move == move_count && max_room_num > map[x][y]) {
						max_room_num = map[x][y];
					}
						
					
				}
			}
			
			sb.append("#" + test_case + " " + max_room_num + " " + max_move + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int BFS(int start_x, int start_y) {
		
		ArrayDeque<String> queue = new ArrayDeque<>();
		queue.add(start_x + " " + start_y);
		int move_count = 0; // 움직인 횟수 
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				
				String temp[] = queue.poll().split(" ");
				int cur_x = Integer.parseInt(temp[0]);
				int cur_y = Integer.parseInt(temp[1]);
				
				for (int index = 0; index < dir.length; index++) {
					
					int new_x = cur_x + dir[index][0];
					int new_y = cur_y + dir[index][1];
					
					if (is_In(new_x, new_y) && map[cur_x][cur_y] + 1 == map[new_x][new_y])
						queue.add(new_x + " " + new_y);
				}
				
			}
			move_count++;
		}
		
		return move_count;
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}







