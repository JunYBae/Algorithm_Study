import java.util.Scanner;

class Main {
	
	static int N, K, array[], count;
	
 	public static void main(String[] args) {
 		
 		Scanner sc = new Scanner(System.in);
 		
 		N = sc.nextInt();
 		K = sc.nextInt();
 		
 		array = new int[N];
 		
 		for (int i = 0; i < N; i++)
 			array[i] = sc.nextInt();
 		
 		count = 0;
 		
 		for (int i = N-1; i >= 0; i--)
 		{
 			if (K == 0)
 				break;
 			
 			if (K / array[i] != 0) {
 				int temp =  K / array[i];
 				count += temp;
 				K -= array[i] * temp;
 			}
 		}
 		
 		System.out.println(count);
 	}
}