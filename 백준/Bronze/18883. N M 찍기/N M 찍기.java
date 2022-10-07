import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		sc.close();
		StringBuilder sb=new StringBuilder("");
		String s="";int count=1;
		for(int i=1; i<=N; i++) {
			for(int j=(M*(i-1))+1; j<=i*M; j++) {
			if(count!=M) {sb.append(j+" ");count++;}
			else {sb.append(j+"\n"); count=1;}}
		}
		System.out.print(sb);		
	}

}
