import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BC implements Comparable<BC>{
	int x, y, range, power;
	BC(int x, int y, int range, int power) {
		this.x = x;
		this.y = y;
		this.range = range;
		this.power = power;
	}
	@Override
	public int compareTo(BC o) {
		return Integer.compare(this.power, o.power) * -1;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}
	
	@Override
	public int hashCode() {
		return (x +  " " + y).hashCode();
	}
	
}

public class Solution {
	
	static int M, A;
	static int persons_move[][]; // 사용자들 움직임 저장
	static BC bc_tower[]; // 충전소 정보 저장
	// 이동 X, 상, 우, 하, 좌
	static int dir[][] = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // 총 이동 시간 
			A = Integer.parseInt(st.nextToken()); // BC(충전소) 개수
			
			persons_move = new int[M+1][2]; // 사용자들 움직임 저장 
			persons_move[0][0] = 0; // 초기
			persons_move[0][1] = 0; // 초기
			
			for (int x = 0; x < 2; x++) {
				st = new StringTokenizer(br.readLine());
				for (int y = 1; y <= M; y++) 
					persons_move[y][x] = Integer.parseInt(st.nextToken());
			}
			
			bc_tower = new BC[A]; // 충전소 정보 저장
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				
				bc_tower[i] = new BC(x, y, range, power);
			}
			

			int total_charge = simulation_Move();
			System.out.println("#" + test_case + " " + total_charge);
			
		}	
	}
	
	public static int simulation_Move() {
		
		int total_charge = 0; // 총 충전량
		int per1_x = 1, per1_y = 1, per2_x = 10, per2_y = 10; // 사람 좌표
		
		for (int i = 0; i <= M; i++) {
			// 좌표 움직임 
			per1_x += dir[persons_move[i][0]][0];
			per1_y += dir[persons_move[i][0]][1];
			per2_x += dir[persons_move[i][1]][0];
			per2_y += dir[persons_move[i][1]][1];
			
//			System.out.println("person 1 : " + per1_x + " " + per1_y);
//			System.out.println("person 2 : " + per2_x + " " + per2_y);
//			System.out.println();
			
			PriorityQueue<BC> per1_towers = calcul_BC(per1_x, per1_y); // 사용자 1의 주변 BC 충전소 
			PriorityQueue<BC> per2_towers = calcul_BC(per2_x, per2_y); // 사용자 2의 주변 BC 충전소
			
			if (per1_towers.isEmpty() && per2_towers.isEmpty())
				continue;
			
			total_charge += select_tower(new ArrayList<BC>(per1_towers), new ArrayList<BC>(per2_towers));
		}
		
		return total_charge;
	}
	
	
	public static PriorityQueue<BC> calcul_BC(int x, int y) {
		
		PriorityQueue<BC> list = new PriorityQueue<>();
		
		for (BC tower : bc_tower) {	
			boolean touch = ((Math.abs(tower.x-x) + Math.abs(tower.y-y)) <= tower.range);
			if (touch)
				list.add(tower);
		}
		
		return list;
	}
	
	public static int select_tower(ArrayList<BC> per1, ArrayList<BC> per2) {
		
		int max_charge = 0;
		
		if(per1.isEmpty())
			return per2.get(0).power;
		else if (per2.isEmpty())
			return per1.get(0).power;
		
		for (int i = 0; i < per1.size(); i++) {			
			for (int j = 0; j < per2.size(); j++) {
				
				int temp_sum = 0;
				
				BC test1 = per1.get(i);
				BC test2 = per2.get(j);
				
				if (test1.equals(test2)) 
					temp_sum = test1.power;
				
				else
					temp_sum += test1.power + test2.power;
				
				if (temp_sum > max_charge)
					max_charge = temp_sum;
				
			}
		}
		
		return max_charge;
	}
}
