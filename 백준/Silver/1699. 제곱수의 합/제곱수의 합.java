import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		sc.close();
		int[] knap=new int[100001];//[숫자]
		for(int i=1; i<=N; i++){
			if(knap[i]!=1){knap[i]=100001;}
			for(int j=1; j<=(int)Math.sqrt(i); j++){
				knap[i]=Math.min(knap[i], knap[i-(j*j)]+1);	
			}
		}
		System.out.println(knap[N]);

	}

}
