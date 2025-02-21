import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import javax.lang.model.util.Elements;

public class Main {
	
	static int N;
	static int arr[], answer[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		
		for (int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		answer = new int[7];
		tracking(0, 0, answer, 0);
		System.out.println(sb.toString());
	}
	
	public static void tracking(int vertex, int length, int answer[], int sum) {
		
		if (length == 7) {
			if (sum == 100)
				for (int num : answer)
					sb.append(num).append("\n");
			return;
		}
		
		for (int i = vertex; i < 9; i++) {
			answer[length] = arr[i];
			tracking(i+1, length+1, answer, sum+arr[i]);
		}
		
	}
}
