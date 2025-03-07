import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
			
        int prev_x = 1;
        int prev_left = 1;
        int prev_right = 1;

        for (int count = 1; count < N; count++) {
            int cur_x = (prev_x + + prev_right + prev_left) % 9901;
            int cur_left = (prev_x + prev_right) % 9901;
            int cur_right = (prev_x + prev_left) % 9901;

            prev_x = cur_x;
            prev_left = cur_left;
            prev_right = cur_right;
        }

        int answer = prev_x + prev_left + prev_right;
		
		System.out.println(answer % 9901);
	}

}




