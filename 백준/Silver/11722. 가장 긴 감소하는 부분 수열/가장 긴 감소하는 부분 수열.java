import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();
		int[] num=new int[A];
		int[] sub=new int[A];
		for(int i=0; i<A; i++){
			num[i]=sc.nextInt();
		}
		
		for(int i=0; i<A; i++){
			sub[i]=1;
			for(int j=0; j<i; j++){
				if(num[i]<num[j]&&sub[j]+1>sub[i]){sub[i]=sub[j]+1;}
			}
		}
		int Max=sub[0];
			for(int j=0; j<A; j++){
				if(Max<sub[j]) Max=sub[j];
		}
		System.out.println(Max);
	}

}