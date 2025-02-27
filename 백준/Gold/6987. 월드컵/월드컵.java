import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Dajun {
	int country_a, country_b;
	Dajun(int country_a, int country_b) {
		this.country_a = country_a;
		this.country_b = country_b;
	}
}

public class Main {
	
	static ArrayList<Dajun> list;
	static int con_list[][];
	static boolean success;;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 4; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			con_list = new int[6][3];
			list = new ArrayList<>();
			
			for (int i = 0; i < 6; i++) {
				con_list[i][0] = Integer.parseInt(st.nextToken());
				con_list[i][1] = Integer.parseInt(st.nextToken());
				con_list[i][2] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < 6; i++) {
				for (int j = i+1; j < 6; j++) 
					list.add(new Dajun(i, j));
			}
			
			success = false;
			BackTracking(0);
			
			if(success)
				sb.append("1 ");
			else
				sb.append("0 ");
			
		}
		
		System.out.println(sb.toString());
	}
	
	public static void BackTracking(int vertex) {
		
		if(success)
			return;
		
		if (vertex == list.size()) {
			for (int i = 0; i < 6; i++) {
				if (con_list[i][0] != 0 || con_list[i][1] != 0 || con_list[i][2] != 0)
					return;
			}
			success = true;
			return;
		}
		
		Dajun dajun = list.get(vertex);
		
		if (con_list[dajun.country_a][0] > 0 && con_list[dajun.country_b][2] > 0) {
			// a승, b패배
			con_list[dajun.country_a][0]--;
			con_list[dajun.country_b][2]--;
			BackTracking(vertex+1);
			con_list[dajun.country_a][0]++;
			con_list[dajun.country_b][2]++;
		}
		
		if (con_list[dajun.country_a][2] > 0 && con_list[dajun.country_b][0] > 0) {
			// a패배, b승
			con_list[dajun.country_a][2]--;
			con_list[dajun.country_b][0]--;
			BackTracking(vertex+1);
			con_list[dajun.country_a][2]++;
			con_list[dajun.country_b][0]++;
		}
		
		if (con_list[dajun.country_a][1] > 0 && con_list[dajun.country_b][1] > 0) {
			con_list[dajun.country_a][1]--;
			con_list[dajun.country_b][1]--;
			BackTracking(vertex+1);
			con_list[dajun.country_a][1]++;
			con_list[dajun.country_b][1]++;
		}
		
	}
}

