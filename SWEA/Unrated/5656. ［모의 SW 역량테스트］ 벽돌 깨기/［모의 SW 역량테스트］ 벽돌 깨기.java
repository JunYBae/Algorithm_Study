import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, W, H, max, answer;
	static ArrayList<Integer> list[]; // 맵 정보
	static int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 구슬 개수 
			W = Integer.parseInt(st.nextToken()); // 가로 길이
			H = Integer.parseInt(st.nextToken()); // 세로 길이
			max = 0; // 총 부순 블록 (최대)
			answer = Integer.MAX_VALUE; // 남은 블록 개수
			
			list = new ArrayList[W]; // 세로로 생각
			for (int i = 0; i < W; i++) // 초기화
				list[i] = new ArrayList<>();
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int temp = Integer.parseInt(st.nextToken());
					if(temp != 0)
						list[j].add(0, temp);
				}
			}
						
			DFS(0);				
			System.out.println("#" + test_case + " " + (answer == Integer.MAX_VALUE ? 0 : answer));
		}
	}
	
	public static void DFS(int depth) {
		if (depth == N) {		
			int cur_total = 0;
			
			for (ArrayList<Integer> temp : list) {
				cur_total += temp.size();
			}

			if (cur_total < answer) {
				answer = cur_total;
				// 디버깅 코드
//				System.out.println("answer : " + answer);
//				for (int x = 0; x < W; x++) 
//					System.out.println(list[x].toString());
//				System.out.println();		
			}			
			return;
		}
		
		for (int i = 0; i < W; i++) {
			
			if (!list[i].isEmpty()) {
				
				ArrayList<Integer>[] copy_list = new ArrayList[W];
				array_Copy(list, copy_list);
				
				break_block(i, list[i].size()-1, list);	
				for (int index = 0; index < W; index++) 
					list[index].removeIf(num -> num == 0);
				
				
				DFS(depth+1);
				
				array_Copy(copy_list, list);
			}
		}
	}
	
	public static void array_Copy(ArrayList<Integer> src[], ArrayList<Integer> dst[]) {
		
		for (int i = 0; i < src.length; i++) {
			dst[i] = (ArrayList<Integer>) src[i].clone();
		}
	}
	
	public static void break_block(int width, int height, ArrayList<Integer> list[]) {
		
		int block_count = list[width].get(height);
		list[width].set(height, 0); // 0으로 초기화
			
		if (block_count != 1) { // 블록 카운트 1 아니면? 
			
			// 4 방향 만큼 
			for (int i = 0; i < 4; i++) {
			
				for (int index = 1; index < block_count; index++) {
						
					int next_width = width + dir[i][0] * index;
					int next_height = height + dir[i][1] * index;
						
					if (is_In(next_width, next_height, list)) {
						break_block(next_width, next_height, list);
					}
				}				
			}				
		}	
	}
	
	public static boolean is_In(int width, int height, ArrayList<Integer> list[]) {
	
		if (width >= 0 && width < W && height >= 0 && height < list[width].size()
				&& list[width].get(height) != 0) 
			return true;
		return false;
	}
}

