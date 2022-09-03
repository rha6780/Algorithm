import java.util.Scanner;
public class Main {
	public static int[] sn=new int [1000];
	
	public static boolean excon(int count) {
		int j=0, i=0;
		for(i=0, j=count-1; i<=j; ) {
			
			if(sn[i]==sn[j]) {  
			if(i==j||j-i==1) {return true;}
			else {i++; j--; continue;}}
			else break;
		}
		return false;
	}

	public static int Conv(int num) {
		int count=0, j=0;
		int numt=num;
		for(int i=2; i<=64; i++) {
			count=0;numt=num;j=0; sn=new int [1000];
			while(numt>0) {
				sn[j]=numt%i;
				numt=numt/i;
				count++;
				j++;
			}
			if(excon(count)==true) {return 1;}
			
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int test1=0;
		for(int i=0; i<N; i++) {
			test1=sc.nextInt();
			System.out.println(Conv(test1));
		}
		sc.close();
		
	}

}