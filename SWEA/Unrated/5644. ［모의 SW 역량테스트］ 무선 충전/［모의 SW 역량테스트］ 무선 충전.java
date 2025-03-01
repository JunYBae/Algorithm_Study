import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

class Station extends Point implements Comparable<Station> {
	int range, power;

	public Station(int x, int y, int range, int power) {
		super(x, y);
		this.range = range;
		this.power = power;
	}

	@Override
	public int compareTo(Station o) {
		return Integer.compare(this.power, o.power) * -1;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}
	
	@Override
	public int hashCode() {
		return (x + " " + y).hashCode();
	}
	
}

public class Solution {
	
	static int M, A, answer;
	static int move[][];
	static ArrayList<Station> station_list;
	// X, 상, 우, 하, 좌
	static int dir[][] = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 움직인 횟수 
			A = Integer.parseInt(st.nextToken()); // 스테이션 개수
			answer = 0;
			station_list = new ArrayList<Station>();
			move = new int[M+1][2];
			move[0][1] = 0; move[0][0] = 0; // 처음엔 안움직임
					
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) // A 플레이어
				move[i][0] = Integer.parseInt(st.nextToken());
					
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) // B 플레이어 
				move[i][1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());
				station_list.add(new Station(x, y, range, power));
			}
			
			simulation();
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void simulation() {
		
		Point player_a = new Point(1, 1);
		Point player_b = new Point(10, 10);
		
		for (int i = 0; i <= M; i++) {
			player_a.x += dir[move[i][0]][0];
			player_a.y += dir[move[i][0]][1];
			player_b.x += dir[move[i][1]][0];
			player_b.y += dir[move[i][1]][1];
			
			PriorityQueue<Station> station_a = check_station(player_a);
			PriorityQueue<Station> station_b = check_station(player_b);
			
			if (station_a.size() == 0 && station_b.size() == 0)
				continue;
			
			answer += calculate(new ArrayList<Station>(station_a), new ArrayList<Station>(station_b));
		}
	}
	
	public static int calculate(ArrayList<Station> station_a, ArrayList<Station> station_b) {
		
		int max = 0;
		
		if (station_a.size() == 0)
			return station_b.get(0).power;
		
		else if (station_b.size() == 0)
			return station_a.get(0).power;
		
		for (Station a : station_a) {
			for (Station b : station_b) {				
				int sum = 0;
				
				if(a.equals(b))
					sum = a.power;			
				else
					sum = a.power + b.power;
				
				if (max < sum)
					max = sum;
			}
		}	
		
		return max;
	}
	
	public static PriorityQueue<Station> check_station(Point player) {
		
		PriorityQueue<Station> list = new PriorityQueue<Station>();
		
		for (Station station : station_list) {
			int distance = Math.abs(player.x - station.x) + Math.abs(player.y - station.y);
			if(station.range >= distance)
				list.add(station);
		}
		
		return list;
	}
}



