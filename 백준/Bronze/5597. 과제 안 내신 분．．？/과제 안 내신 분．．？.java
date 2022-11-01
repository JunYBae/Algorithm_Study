import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int array[] = new int[31];
		for(int i = 1; i <= 30; i++)
			array[i] = 0;
		
		for(int j = 1; j <= 28; j++)
			array[s.nextInt()] = 1;
		
		for(int k = 1; k <= 30; k++)
			if(array[k] == 0)
				System.out.println(k);
	}
}
