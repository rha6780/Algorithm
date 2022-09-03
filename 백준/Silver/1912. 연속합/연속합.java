import java.util.Scanner;
public class Main {
	public static Scanner sc= new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int Max=0;
	public static int Sum=0;
	public static int[] num=new int[N];
	public static int[] cosum=new int[N];
	
	public static int summit(int n) {
		cosum[0]=num[0];
		Max=num[0];
		for(int i=1; i<N; i++) {
			if(num[i]>=0) {
				if(cosum[i-1]<0)
					cosum[i]+=num[i];
				else
				cosum[i]+=cosum[i-1]+num[i];
			}
			else {
				if(i+1<N&&0<(num[i+1]+num[i])) {
					cosum[i]+=cosum[i-1]+num[i];
				}
				else if(i+1<N&&cosum[i-1]+num[i]>0){
					cosum[i]+=cosum[i-1]+num[i];
				}
				else {
					
					cosum[i]=num[i];
				}
			}
			if(Max<cosum[i]) {
				Max=cosum[i];
			}
		}
		if(Sum>Max) Max=Sum;
		return Max;
	}
	public static void main(String[] args) {
	for(int i=0; i<N; i++) {
		num[i]=sc.nextInt();
		Sum+=num[i];
	}
		System.out.println(summit(N));
	}

}