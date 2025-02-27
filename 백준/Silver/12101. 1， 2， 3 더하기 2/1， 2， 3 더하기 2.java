import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[] = {1, 2, 3}, count;
	static ArrayList<Integer> result;
	static boolean success;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = new ArrayList<>();
		success = false;
			
		backTracking(0, sb);
		if (!success)
			sb.append("-1");
		System.out.println(sb.toString());
	}
	
	public static void backTracking(int sum, StringBuilder sb) {
		
		if(sum == N) {
			count++;
			
			if (count == K) {
				success =true;
				sb.append(result.get(0));
				for (int i = 1; i < result.size(); i++) {
					sb.append("+").append(result.get(i));
				}
			}			
			return;
		} 
		
		else if (sum > N) {
			return;
		}
		
		for (int i = 0; i < arr.length && !success; i++) {
			result.add(arr[i]);
			backTracking(sum + arr[i], sb);
			result.remove(result.size() - 1);
		}
	}

}

