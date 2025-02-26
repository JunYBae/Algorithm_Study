import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, R, arr[][];
	static ArrayList<ArrayDeque<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
		
		// 배열에 값 저장 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		// 회전하는 애들끼리 모아서 deque에 저장 
		insert_Deque();		
		
		// R번 회전 시킴 deque 에 있는 마지막 원소를 빼서 첫번째에 넣음 			
		for (ArrayDeque<Integer> temp : list) {
			int last = R % temp.size();
			for (int i = 0; i < last; i++)
				temp.addFirst(temp.removeLast());
		}
		
		// array에 deque에 있는 것들 다시 복귀 시킴
		repair_array();
		
		// 결과 출력 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(arr[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
	// deque 에 있는 것들 -> array 로
	public static void repair_array() {
		 int direction = 0, cur_box = 0;
		 int cur_N = N, cur_M = M;
		 int cur_x = 0, cur_y = 0;
		 
		 // 사각형 개수 만큼 반복 
		 while (cur_box < Math.min(N/2, M/2)) {
			 // N번째 해당하는 박스 가져오기
			 ArrayDeque<Integer> box = list.get(cur_box);
			 // 방향 변수 
			 direction = 0;
			 // 박스에 들어갈 원소 개수 까지 반복 
			 for (int count = 0; count < (cur_N*2) + Math.max(0, cur_M-2)*2; count++) {
				 
				 // 방향에 따른 처리 
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
		 
		// 사각형 개수 만큼 반복 
		 while (cur_box < Math.min(N/2, M/2)) {
			 // 방향 변수 
			 direction = 0;
			 // 박스에 들어갈 원소 개수 까지 반복 
			 for (int count = 0; count < (cur_N*2) + Math.max(0, cur_M-2)*2; count++) {
				 // 방향에 따른 처리 
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












