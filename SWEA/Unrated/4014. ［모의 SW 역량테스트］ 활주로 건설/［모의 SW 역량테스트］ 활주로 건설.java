import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, X; // 활주로 크기, 경사로 길이 
	static int road_count; // 지을 수 있는 활주로 개수 
	static int map[][]; // 현재 활주로 정보 저장 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 저장 
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 활주로 크기
			X = Integer.parseInt(st.nextToken()); // 경사로 길이
			map = new int[N][N]; // 활주로 맵
			road_count = 0; // 활주로 개수 초기화
			
			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int y = 0; y < N; y++) 
					map[x][y] = Integer.parseInt(st.nextToken()); // 맵 정보 저장
			}
			
			for (int x = 0; x < N; x++) // 활주로 건설 (가로) 
				build_road(map[x].clone());
			
			for (int y = 0; y < N; y++) {
				int temp[] = new int[N];
				for (int x = 0; x < N; x++) {
					temp[x] = map[x][y];
				}
				build_road(temp);
			}
			
			
//			for (int y = 0; y < N; y++) {
//				build_road(0, y, false); // 활주로 건설 (세로)
//				}
			
			sb.append("#" + test_case + " " + road_count + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void build_road(int road[]) {
		
		int prev_node = road[0];
		int dong_count = 0;
		
		for (int i = 0; i < road.length; i++) {
			
			if (prev_node == road[i]) { // 같으면 dong_count 추가
				dong_count++;
			} else if (Math.abs(prev_node - road[i]) > 1) { // 차이가 1 초과면 못해
				return;
			} else if (prev_node < road[i]) { // 높으면? dong_count 이용! 
				if (dong_count >= X) // 더 많으면? 통과임! 
					dong_count = 1;
				else // 못함
					return; 
			} else if (prev_node > road[i]) { // 낮으면? 전진 탐색 시작 
				if (is_possible(i, road)) {
					dong_count = 0;
					i += X-1;
				}
				else // 못함
					return; 
			}
			
			prev_node = road[i];
		}
		
//		System.out.println("possible : " + Arrays.toString(road));
		
		road_count++;
	}
	
	public static boolean is_possible(int index, int road[]) {
				
		int select = road[index]; // 목표노드 (이게 반복되야함)
		int count = 0; // 목표 노드 개수 
		for (int i = index; i < index+X && i < N; i++) {
			if (road[i] == select)
				count++;
		}
		if (count >= X) {
			return true;
		}
		else
			return false;
	}
}