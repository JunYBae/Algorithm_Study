import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BigInteger N = new BigInteger(st.nextToken());
		BigInteger M = new BigInteger(st.nextToken());
		
		BigInteger result = new BigInteger("1");
		for (long i = N.intValue(), index = 1; index <= M.intValue(); index++, i--) {
			
			result = result.multiply(new BigInteger(i + ""));
			result = result.divide(new BigInteger(index +""));
			
		}

		
		System.out.println(result.toString());
	}

}

