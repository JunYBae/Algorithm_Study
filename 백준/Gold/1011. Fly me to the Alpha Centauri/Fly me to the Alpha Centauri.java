import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int start = sc.nextInt(); // 출발
			int end = sc.nextInt(); // 도착
			int gap = Math.abs(start-end); // 가야하는 거리
			
			if (gap == 1) {
				System.out.println("1");
				continue;
			}
			
			long move_half = gap / 2; // 절반 
			long count = 0; // 움직인 횟수 
			long number = 1; // 등차수열 숫자
			
			
			number = binary_search(move_half);
			
			count = number * 2; // 양쪽 다 움직이기 때문
//			System.out.println(number);
//			System.out.println(gap);
//			System.out.println((number+1)*number);
			
			
			if ((number+1) *number == gap) { 
			// 만약 둘이 움직인 합이 가야하는 거리와 같으면
				System.out.println(count);
			} else {
				
				long remain = (gap - (number+1) * number); // 남은 거리 
//				System.out.println("remain : "  + remain);
//				System.out.println("number : " + number);
//				System.out.println("count : " + count);
				
				if (remain == number || remain == number-1 || remain == number+1 
						|| remain < number) {
					// 한번만 움직이면 도달할 수 있을 때
					System.out.println(count+1);
				}
				
				else { // 나머지는 다 두번 움직여야 함 
					System.out.println(count+2);
				}
			}
		}	
	}
	
	public static long binary_search(long move_half) {
		
		long start = 1, end = Integer.MAX_VALUE/2;
		long goal = -1;
		
		while(start <= end) {
			long middle = (start+end)/ 2;
			
			if ((middle+1)*middle / 2 <= move_half) {
				goal = middle;
				start = middle+1;
			} else {
				end = middle-1; 
			}
			
		}
		return goal;
	}
}
