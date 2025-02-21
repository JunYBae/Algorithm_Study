import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Ingredient {
	int sweet, sour;
	
	Ingredient(int sour, int sweet) {
		this.sweet = sweet;
		this.sour = sour;
	}
}


public class Main {
	
	static int N, answer;
	static ArrayList<Ingredient> list;

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		

		simulation(0, 0, 0, 1);
		System.out.println(answer);
	}
	
	public static void simulation(int vertex, int count, int sweet, int sour) {
		
		if(vertex == N) {
			if ((answer > Math.abs(sweet - sour)) && count != 0) 
				answer = Math.abs(sweet - sour);
			return;
		}
		
		simulation(vertex+1, count+1, sweet + list.get(vertex).sweet, sour * list.get(vertex).sour);
		simulation(vertex+1, count, sweet, sour);		
	}

}



