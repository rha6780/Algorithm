import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		int C=N*M;
		int[] cho=new int[(N*M)+1];
		for(int i=1; i<=C; i++){
			if(i==1) cho[1]=0;
			else if(i==2) cho[2]=1;
			else{cho[i]=i-1;}
		}
		System.out.println(cho[C]);

	}

}