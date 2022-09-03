import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		float[] num=new float[N];
		float Max=0;
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
			if(Max<num[i]) {Max=num[i];}
		}
		float mean=0;
		for(int j=0; j<N; j++) {
			num[j]=(num[j]/Max)*100;
			mean+=num[j];
		}
		System.out.println(mean/N);
		sc.close();
	}

}
