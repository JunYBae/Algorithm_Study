import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person {

	int num;
	ArrayList<Integer> like_person;
	
	Person(int num, ArrayList<Integer> like_person) {
		this.num = num;
		this.like_person = like_person;
	}
	
	
}


public class Main {
	
	static int N, dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Person person_list[], map[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		 map = new Person[N][N]; // 학생 맵
		 person_list = new Person[N*N]; // 학생 리스트 
		 
		 for (int i = 0; i < N*N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 
			 int num = Integer.parseInt(st.nextToken());
			 ArrayList<Integer> like_person = new ArrayList<>();
			 
			 for (int j = 0; j < 4; j++)
				 like_person.add(Integer.parseInt(st.nextToken()));
			 
			 person_list[i] = new Person(num, like_person);
		 }
		
		 
		 simulation(); // 시뮬레이션
		 answer_calcaulate();  // 정답 계산
	
		System.out.println(sb.toString()); // 정답 출력 
	}
	
	
	public static void answer_calcaulate() {
		
		long sum = 0;
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				
				Person person = map[x][y];
				int count = 0;
				
				for (int index = 0; index < 4; index++) {
					
					int cur_x = x + dir[index][0];
					int cur_y = y + dir[index][1];
					
					if (is_In(cur_x, cur_y) && person.like_person.contains(map[cur_x][cur_y].num)) 
						count++;
					
				}
				
				switch(count) {
				case 0:
					sum += 0;
					break;
				case 1:
					sum += 1;
					break;
				case 2:
					sum += 10;
					break;
				case 3:
					sum += 100;
					break;
				case 4:
					sum += 1000;
					break;
				}
			}
		}
		
		sb.append(sum);
	}
	
	public static void simulation() {
		
		
		for (int i = 0; i < N*N; i++) {
			
			int cost[][][] = new int[N][N][2];		
			calculate_cost(person_list[i], cost);
			select_map(person_list[i], cost);
			
		}
		
	}
	
	public static void select_map(Person person, int cost[][][]) {
		
		int sel_x = -1, sel_y = -1;
		int sel_person = -1, sel_null = -1;
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				
				if (map[x][y] == null) {
				
					if (sel_person < cost[x][y][0] || (sel_person == cost[x][y][0] &&
							sel_null < cost[x][y][1])) {
						sel_x = x;
						sel_y = y;
						sel_person = cost[x][y][0]; 
						sel_null = cost[x][y][1];
					}
				
				}
			}
		}
		
		map[sel_x][sel_y] = person;
		
	}
	
	public static void calculate_cost(Person person, int cost[][][]) {
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				
				for (int index = 0; index < 4; index++) {
					
					int cur_x = x + dir[index][0];
					int cur_y = y + dir[index][1];
					
					if (is_In(cur_x, cur_y)) {
						
						if (map[cur_x][cur_y] == null) {
							cost[x][y][1]++;
						}
						else if (person.like_person.contains(map[cur_x][cur_y].num)) {
							cost[x][y][0]++;
						}
						
					}
				}
			}
		}
		
	}
	
	public static boolean is_In(int x, int y) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		return false;
	}
}
























