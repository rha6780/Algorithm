import java.util.*;
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt(), y=sc.nextInt(), w=sc.nextInt(), h=sc.nextInt();
		int mover=0;
		if(x-0<w-x) {mover=x-0;}
		else {mover=w-x;}
		int movec=0;
		if(y-0<h-y) {movec=y-0;}
		else {movec=h-y;}
		
		if(mover<movec) {System.out.println(mover);}
		else {
			System.out.println(movec);
		}
	}

}
