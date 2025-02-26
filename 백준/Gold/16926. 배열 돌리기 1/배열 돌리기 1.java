import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, R, arr[][];
	static ArrayList<ArrayDeque<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		R = Integer.parseInt(st.nextToken()); // 회전 횟수
		arr = new int[N][M]; // 숫자 저장할 배열 생성 
		
		list = new ArrayList<>(); // ArrayDeque 들 저장할 list 생성
		
		for (int i = 0; i < Math.min(N/2, M/2); i++) { 
			// ArrayDeque 저장 
			list.add(new ArrayDeque<Integer>());
		}
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		insert_Deque();		
		
		for (int i = 0; i < R; i++) {			
			for (ArrayDeque<Integer> temp : list)
				temp.addFirst(temp.removeLast());
		}
		
		repair_array();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		
	}
	
	public static void repair_array() {
		 int direction = 0, cur_box = 0;
		 int cur_N = N, cur_M = M;
		 int cur_x = 0, cur_y = 0;
		 
		 while (cur_box < Math.min(N/2, M/2)) {
			 
			 ArrayDeque<Integer> box = list.get(cur_box);
			 
			 direction = 0;
			 
			 for (int count = 0; count < (cur_N*2) + Math.max(0, cur_M-2)*2; count++) {
				 
				 switch(direction) {
				 case 0:
					 if (cur_x+1 == N || arr[cur_x+1][cur_y] != 0) {
						 arr[cur_x][cur_y++] = box.removeFirst();
						 direction = (direction + 1) % 4;
					 } 
					 else {
						 arr[cur_x++][cur_y] = box.removeFirst();
					 }
					 break;
					 
				 case 1:
					 if (cur_y+1 == M || arr[cur_x][cur_y+1] != 0) {
						 arr[cur_x--][cur_y] = box.removeFirst();
						 direction = (direction + 1) % 4;
					 } 
					 else {
						 list.get(cur_box).add(arr[cur_x][cur_y]);
						 arr[cur_x][cur_y++] = box.removeFirst();
					 }
					 break;
					 
				 case 2:
					 if (cur_x == 0 || arr[cur_x-1][cur_y] != 0) {
						 arr[cur_x][cur_y--] = box.removeFirst();
						 direction = (direction + 1) % 4;
					 } 
					 else { 
						 arr[cur_x--][cur_y] = box.removeFirst();
					 }
					 break;
					 
				 case 3:
					arr[cur_x][cur_y--] = box.removeFirst();
					 break;
				 }
				 
			 }
			 
			 cur_N -= 2;
			 cur_M -= 2;
			 cur_x += 1;
			 cur_y += 1;
			 cur_box++;
		 }
	}

	
	public static void insert_Deque() {
			
		 int direction = 0, cur_box = 0;
		 int cur_N = N, cur_M = M;
		 int cur_x = 0, cur_y = 0;
		 
		 while (cur_box < Math.min(N/2, M/2)) {
			 
			 direction = 0;
			 
			 for (int count = 0; count < (cur_N*2) + Math.max(0, cur_M-2)*2; count++) {
				 
				 switch(direction) {
				 case 0:
					 if (cur_x+1 == N || arr[cur_x+1][cur_y] == 0) {
						 list.get(cur_box).add(arr[cur_x][cur_y]);
						 arr[cur_x][cur_y++] = 0;
						 direction = (direction + 1) % 4;
					 } 
					 else {
						 list.get(cur_box).add(arr[cur_x][cur_y]);
						 arr[cur_x++][cur_y] = 0;
					 }
					 break;
					 
				 case 1:
					 if (cur_y+1 == M || arr[cur_x][cur_y+1] == 0) {
						 list.get(cur_box).add(arr[cur_x][cur_y]);
						 arr[cur_x--][cur_y] = 0;
						 direction = (direction + 1) % 4;
					 } 
					 else {
						 list.get(cur_box).add(arr[cur_x][cur_y]);
						 arr[cur_x][cur_y++] = 0;
					 }
					 break;
					 
				 case 2:
					 if (cur_x == 0 || arr[cur_x-1][cur_y] == 0) {
						 list.get(cur_box).add(arr[cur_x][cur_y]);
						 arr[cur_x][cur_y--] = 0;
						 direction = (direction + 1) % 4;
					 } 
					 else { 
						 list.get(cur_box).add(arr[cur_x][cur_y]);
						 arr[cur_x--][cur_y] = 0;
					 }
					 break;
					 
				 case 3:
					list.get(cur_box).add(arr[cur_x][cur_y]);
					arr[cur_x][cur_y--] = 0;
					 break;
				 }
				 
			 }
			 
			 cur_N -= 2;
			 cur_M -= 2;
			 cur_x += 1;
			 cur_y += 1;
			 cur_box++;
		 }
	}
}



