import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int K=sc.nextInt(); int P=sc.nextInt(); int W=sc.nextInt();
		int answer=0;
		if(P%W==0) {answer=P/W;}
		else if(P%W>0) {answer=(P/W)+1;}
		System.out.println((int)answer);
	}

}
