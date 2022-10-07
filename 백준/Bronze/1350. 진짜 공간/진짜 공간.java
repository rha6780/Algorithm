import java.util.Scanner;
public class Main {

	public static int realspace(int a, int b) {
		int rem=a%b, quo=a/b; int result=0;
		if(rem>0) quo++;
		result=quo*b;
		return result;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); long hap=0;
		int []data=new int [N];
		for(int i=0; i<N; i++) {
			data[i]=sc.nextInt();
		} 
		int clust=sc.nextInt();sc.close();
		for(int j=0; j<N; j++)
		hap+=realspace(data[j], clust);
	System.out.println(hap);
	}
}
