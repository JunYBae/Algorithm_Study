import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 문자열 길이
		
		// 첫숫자는 무조건 2, 3, 5, 7 임.
		// 왜? 한자리 숫자 중 2, 3, 5, 7만 소수이기 때문
		backTracking(1, 2); 
		backTracking(1, 3);
		backTracking(1, 5);
		backTracking(1, 7);
		
		System.out.println(sb.toString());
	}
	
	public static void backTracking(int length, int number) {
		
		if (length == N) { // 내가 원하는 길이가 된다면 
			sb.append(number).append("\n"); // 출력 붙이기 
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			int check_num = number * 10 + i; // 뒷자리에 i 추가했을 때
			if(is_prime(check_num)) // 이게 소수인지 판별 
				backTracking(length+1, check_num); // 맞으면 재귀로 넘어감 
		}
	}
	
	public static boolean is_prime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) { 
			// 자기 자신의 제곱근까지 나눴을 때 나머지가 없으면 됨
			if (num % i == 0)
				return false;
		}
		return true;
	}
}