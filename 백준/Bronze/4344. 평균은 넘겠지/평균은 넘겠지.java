import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int a=sc.nextInt();
			int[] num=new int[a];
			float count=0,per=0, mean=0;
			int  sum=0;
			for(int j=0; j<a; j++) {
				num[j]=sc.nextInt();
				sum+=num[j];
			}
			mean=sum/a;
			for(int h=0; h<a; h++) {
				if(mean<num[h]) {count++;}
			}
			per=(count/(float)a)*100;
			System.out.println(String.format("%.3f", per)+"%");
		}
		sc.close();
	}

}
