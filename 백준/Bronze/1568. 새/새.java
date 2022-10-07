import java.util.*;
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int count=1, cc=0;
		while(N>0) {
			cc++;
			if(N<count) {count=1;N-=count;count++;}
			else{N-=count;count++;}
			
		}
		System.out.println(cc);
	}

}
