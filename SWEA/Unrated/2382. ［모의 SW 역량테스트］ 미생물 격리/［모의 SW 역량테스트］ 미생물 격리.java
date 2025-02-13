import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Cell {
	
	int x, y, num, dir;
	
	Cell (int x, int y, int num, int dir) {
		this.x = x;
		this.y = y;
		this.num = num;
		this.dir = dir;
	}
	
}


public class Solution {
	
	static int N, M, K;
	// 상 : 0, 좌 : 1, 하 : 2, 우 : 3
	static int dir[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // 위치 정보
	static HashMap<String, Cell> map; // 정보를 저장하고 있는 맵 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 답 저장
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 셀의 개수 (크기)
			M = Integer.parseInt(st.nextToken()); // 격리 시간 
			K = Integer.parseInt(st.nextToken()); // 미생물 군집 개수
			
			map = new HashMap<>(); // 맵 초기화
			
			for (int count = 0; count < K; count++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken()); // 미생물 세로
				int y = Integer.parseInt(st.nextToken()); // 미생물 가로
				int num = Integer.parseInt(st.nextToken()); // 미생물 수
				int dir = Integer.parseInt(st.nextToken()); // 이동방향

				if (dir == 2)
					dir = 3;
				else if (dir == 3)
					dir = 2;
				
				dir--; // 배열 인덱스에 맞추도록 빼줌
				
				Cell cell = new Cell(x, y, num, dir);
				map.put(x + " " + y, cell);
			}
			
			simulation_Progress(); // 시뮬레이션 시작
			long total_cell = 0; // 총 미생물 개수 
			
			Set<String> key_set = map.keySet(); // 키 셋 가져오기
			for (String key : key_set)  {
//				System.out.println(key + " : " + map.get(key).num);
				total_cell += map.get(key).num; // 합 저장
			}
			
			sb.append("#" + test_case + " " + total_cell + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void simulation_Progress() {
		
		int cur_time = 0; // 현재 격리 시간 
		HashMap<String, Cell> new_map; // 새로운 맵 변수
		HashMap<String, Integer> gub_save; // 겹치는 놈들 총 미생물 저장 
		
		do {
			new_map = new HashMap<String, Cell>(); // 새로운 맵 생성
			gub_save = new HashMap<String, Integer>(); // 겹치는 놈들 총 미생물 저장 
			
			Set<String> key_set = map.keySet(); // 이전 맵 키 가져오기
			
			
			// 테스트 코드
//			System.out.println("cur_time : " + cur_time);
//			for (String key : key_set)  {
//				System.out.println(key + " : " + map.get(key).num);
//			}
//			System.out.println();
			//
			
			for (String key : key_set) {
				Cell cell = map.get(key);
				
				// 새로운 위치로 이동 
				cell.x = cell.x + dir[cell.dir][0];
				cell.y = cell.y + dir[cell.dir][1];
				 
				if (is_touch(cell)) { // 벽에 닿았으면? /2 하고 위치 변경
					cell.num /= 2;
					cell.dir = (cell.dir+2) % 4; 
					
					if(cell.num != 0) { // 미생물이 아직도 남아있을 때
						new_map.put(cell.x +" " +cell.y, cell); // 새로운 맵에 넣음
						continue;
					}
				}
				
				else if (new_map.containsKey(cell.x + " " + cell.y)) { 
					// 옮긴 위치에 미생물 있으면?
					// 이전 미생물, 현재 미생물 수 비교해서 합치고 거리 설정
					Cell prev_cell = new_map.get(cell.x + " " + cell.y);
					
					
					
					if(gub_save.containsKey(cell.x + " " + cell.y)) { // 이전에 있으면?
						int prev_save = gub_save.get(cell.x + " " + cell.y);
						gub_save.put(cell.x + " " + cell.y, prev_save + cell.num);
					}
					else 	
						gub_save.put(cell.x + " " + cell.y, prev_cell.num + cell.num); // 따로 저장 
					
					if (prev_cell.num < cell.num) { // 현재 셀이 더 많으면?
						new_map.put(cell.x + " " + cell.y, cell); // 현재 셀 맵에 넣기
					} else { // 이전 셀이 더 많으면?
						// 뭐 안해줘도 됨
					}
				} 
				
				else { // 벽에 닿지도, 이전 셀이 있지도 않을 때
					new_map.put(cell.x + " " + cell.y, cell); // 위치만 바꾸고 넣음
				}
			}
			
			// 합쳐진 애들 이제 총 미생물 수로 업데이트 해줌 
			Set<String> gub_key_set = gub_save.keySet();
			for (String key : gub_key_set) {
				new_map.get(key).num = gub_save.get(key);
			}
					
			map = new_map; // 새로운 맵으로 교체
			
		} while(++cur_time != M && !map.isEmpty()); 
		// 시간이 아직안됫거나, 맵이 비어있으면
		
	}
	
	public static boolean is_touch(Cell cell) {
		if (cell.x == 0 || cell.y == 0 || cell.x == N-1 || cell.y == N-1)
			return true;
		return false;
	}
}
















