import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt(), b=sc.nextInt(), c=sc.nextInt();
		int move=0;
		if(b-a<c-b){move=c-b-1;}
		else{move=b-a-1;}
		System.out.println(move);
	}

}
