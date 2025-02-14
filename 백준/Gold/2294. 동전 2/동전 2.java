import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int array[];
	static ArrayList<Integer> set = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new int[100001]; // 메모리제이션
		Arrays.fill(array, Integer.MAX_VALUE - 1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			array[temp] = 1;
			
			if(!set.contains(temp))
				set.add(temp);
		}
		
		Collections.sort(set, Collections.reverseOrder());
		
		
		for (int coin : set) {
			
			for (int cur_money = coin; cur_money <= K; cur_money++) {
				
				if (array[cur_money - coin] + 1 < array[cur_money])
					array[cur_money] = array[cur_money - coin] + 1;
				
			}
		}
		
//		for (int i = 1; i <= K; i++)
//			System.out.println("money " + i + " : "  + array[i] + " ");
		
		System.out.println(array[K] == Integer.MAX_VALUE - 1 ? -1 : array[K]);
		
	}
	
}