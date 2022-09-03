import java.util.Scanner;
public class Main {
	public static int[] str=new int[100002];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		str[1]=2; str[2]=2;
		str[3]=4; 
		for(int i=4; i<=N; i++){
			if(i%2==1){str[i]=str[i-1]*2;}
			else{
				str[i]=str[i-1];
			}
			if(str[i]>=16769023)str[i]%=16769023;

	}
		System.out.println(str[N]);

}
}