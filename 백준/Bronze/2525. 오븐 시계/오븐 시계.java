import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int hour = s.nextInt();
		int minute = s.nextInt();
		
		int wait = s.nextInt();
		
		hour = ((hour + (wait / 60)) % 24);
		
		minute = minute + wait % 60;
		
		if(minute / 60 != 0) {
			hour = (hour + 1) % 24;
			minute = minute % 60;
		}
		
		System.out.println(hour + " " + minute);
		
		s.close();
	}
}
