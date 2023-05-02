import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int k, n, getn=1, getk=1;
		n=sc.nextInt();
		k=sc.nextInt();
		sc.close();
		for(int i=0; i<k; i++) {
			getk*=(k-i);
			getn*=n;
			n--;
		}
		getn/=getk;
		System.out.print(getn);
	}
}
