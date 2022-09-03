import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] num=new int[N];
		for(int i=0; i<N; i++) {
			num[i]=i+1;
		}
		
		while(true) {
			if(num.length==1) {break;}
			System.out.print(num[0]+" ");
			num[0]=0;
			int[] temp=new int[num.length-1];
			for(int j=0; j<num.length-1; j++) {
				num[j]=num[j+1];
				if(j>0) {
					temp[j-1]=num[j];
				}
			}
			int ss=num[0];
			temp[num.length-2]=ss;
			num=temp;
		}
		System.out.println(num[0]);
	}

}
