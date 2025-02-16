import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int N, population[], edge[][];
	static ArrayList<Integer> a_list;
	static ArrayList<Integer> b_list;
	static int a_population, b_population;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1]; // 인구 정보
		edge = new int[N+1][]; // 엣지 정보
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken()); // 인구 저장
		}
		
		answer = Integer.MAX_VALUE;
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()); // 엣지 개수, 엣지 정보
			int edge_size = Integer.parseInt(st.nextToken()); // 엣지 개수 
			edge[i] = new int[edge_size];
			for (int index = 0; index < edge_size; index++)  {
				edge[i][index] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		// 기본적으론, A의 사이즈 크기로
		for (int size = 1; size < N; size++) {
			a_list = new ArrayList<>();
			b_list = new ArrayList<>();
			split_location(0, 0, size);
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
	
	// 지역 나누기 
	public static void split_location(int vertex, int number, int size) {
		
		if (number == size) {
			b_list.clear();
			for (int i = 1; i <= N; i++)
				if(!a_list.contains(i))
					b_list.add(i);
			
			if (check_connection(a_list, true) && check_connection(b_list, false)) {
				
				int cur_temp = Math.abs(a_population - b_population); 
				if (answer > cur_temp)
					answer = cur_temp;
			}
		
			return;
		}
		
		
		for (int i = vertex+1; i <= N; i++) {
			a_list.add(i);
			split_location(i, number+1, size);
			a_list.remove(a_list.size()-1); 
		}
	}
	
	// 모든 지역이 연결되어 있는지, 이때 연결되어 있으면 인구차이도 계산해버리자
	public static boolean check_connection(ArrayList<Integer> list, boolean is_a_list) {
		
		HashSet<Integer> connect_list = new HashSet<>();
		int temp = 0;
		int start = list.get(0);
		
		connections(start, list, connect_list);
		
		// 연결 되어 있으면?
		if (connect_list.containsAll(list)) {
			
			for (int num : list) {
				temp += population[num];
			}
			
			if (is_a_list) 
				a_population = temp;
			else 
				b_population = temp;
			
			return true;
		}
		
		return false;
	}
	
	// 연결 리스트 만들기 
	public static void connections(int cur, ArrayList<Integer> list, HashSet<Integer> connect_list) {
		
		connect_list.add(cur);
		
		for (int link : edge[cur]) {
			
			if (list.contains(link) && !connect_list.contains(link)) {
				connections(link, list, connect_list);
			}
			
		}
	}
}



