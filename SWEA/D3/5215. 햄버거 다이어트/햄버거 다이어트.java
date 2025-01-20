import java.util.Scanner;

class Solution {
	
	static int score[], kcal[], max_score[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int amount = sc.nextInt();
			int limit_kcal = sc.nextInt();
			
			score = new int[amount];
			kcal = new int[amount];
			max_score = new int[limit_kcal + 1];
			
			for (int i = 0; i < amount; i++)
			{
				score[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			
			for (int i = 0; i < amount; i++)
			{
				for (int j = limit_kcal; j >= kcal[i]; j--)
				{
					max_score[j] = Math.max(max_score[j - kcal[i]] + score[i], max_score[j]);
				}
			}
			
			System.out.println("#" + test_case + " " + max_score[limit_kcal]);
		}
	}
}