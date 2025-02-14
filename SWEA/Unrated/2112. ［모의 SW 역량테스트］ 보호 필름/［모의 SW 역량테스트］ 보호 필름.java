import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int d, w, k, result;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= tc; test++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[d][w];
			result = Integer.MAX_VALUE;
			
			for(int r = 0; r < d; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, -1, map);
			
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int depth, int row, int[][] map) {
		if(depth >= result) {
			return;
		}
		
		if(isPossible(map)) {
			result = Math.min(result, depth);
			return;
		}
		
		int[][] copy;
		for(int r = row + 1; r < d; r++) {
			
			copy = copyMap(map);
			injectionDrug(0, r, copy);
			dfs(depth + 1, r, copy);
			
			copy = copyMap(map);
			injectionDrug(1, r, copy);
			dfs(depth + 1, r, copy);
		}
	}
	
	private static void injectionDrug(int drug, int row, int[][] map) {
		for(int c = 0; c < w; c++) {
			map[row][c] = drug;
		}
	}
	
	private static boolean isPossible(int[][] map) {
		boolean flag = false;
		for(int c = 0; c < w; c++) {
			int count = 1;
			int temp = 0;
			flag = false;
			
			for(int r = 0; r < d; r++) {
				if(r == 0) {
					temp = map[r][c];
					continue;
				}
				
				if(temp == map[r][c]) {
					count++;
				} else {
					temp = map[r][c];
					count = 1;
				}
				
				if(count == k) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				return flag;
			}
		}
		
		return flag;
	}
	
	
	private static int[][] copyMap(int[][] map) {
		int[][] copy = new int[d][w];
		
		for(int r = 0; r < d; r++) {
			copy[r] = map[r].clone();
		}
		
		return copy;
	}

}
