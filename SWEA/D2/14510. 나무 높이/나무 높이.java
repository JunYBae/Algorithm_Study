import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {	
				int length = Integer.parseInt(st.nextToken());
				if (max < length)
					max = length;
				
				arr[i] = length;
			}			
			
            int even = 0, odd = 0;
            int day = 0;
            
            for (int i = 0; i < N; i++) {
                int diff = max - arr[i];
                
                even += diff / 2;
                odd += diff % 2;
              
            }
            
            // 짝수와 홀수를 최대한 짝지어 처리
            int min = Math.min(even, odd);
            day += min * 2;
            even -= min;
            odd -= min;
            
            // 남은 짝수 또는 홀수 처리
            if (even > 0) {
                
            	int temp = 0;
            	boolean is_odd = true;
            	
            	while (even > 0) {
            		
            		if (is_odd) {
            			if(++temp % 2 == 0) 
            				even--;
            		}
            		
            		else 
            			even--;
            		
            		is_odd = !is_odd;
            		day++;
            	}
            	
            } else if (odd > 0) {
                day += 2 * odd - 1;
            }
			
			
			
			sb.append("#").append(test_case).append(" ").append(day).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}