import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int count = s.nextInt();
		int[] array = new int[count];
		int temp = 0;
		
		for(int i = 0; i < count; i++)
			array[i] = s.nextInt();
		
		int check = s.nextInt();
		
		for(int i = 0; i < count; i++)
			if(array[i] == check)
				temp++;
		
		System.out.println(temp);
		
		s.close();
	}
}
