import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static ArrayList<Long> num_list;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num_list = new ArrayList<>();

		calculate(0, 10);
		
		
		if (num_list.size() <= N) {
			System.out.println(-1);
			return;
		}
		Collections.sort(num_list);
		
		System.out.println(num_list.get(N));
	}
	
	public static void calculate(long num, int prev_num) {
		
		if (!num_list.contains(num)) {
			num_list.add(num);
		}
		
		for (int cur_num = prev_num-1; cur_num >= 0; cur_num--) {
			calculate(num * 10 + cur_num, cur_num);
		}
	}
}

