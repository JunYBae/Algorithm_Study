

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int array[], answer[], temp[];
	static boolean visit[];
	
	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		array = new int[9];
		answer = new int[7];
		temp = new int[7];
		visit = new boolean[9];
		
		for (int index = 0; index < 9; index++)
			array[index] = sc.nextInt();
		
		DFS(0, 0, 0);
		
		for (int i = 0; i < answer.length; i++)
			System.out.println(temp[i]);		
	}
	
	public static void DFS(int vertex, int count, int height) {
		
		if (count == 7) {
			if (height == 100) {
				temp = answer.clone();
				Arrays.sort(temp);
			}
			return;
		}
		
		
		for (int i = vertex; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				answer[count] = array[i];
				DFS(i, count + 1, height + array[i]);
				visit[i] = false;
			}
		}
	}
	
}
