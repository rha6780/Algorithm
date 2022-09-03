import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0; t<T; t++) {
		int P=sc.nextInt();
		int Q=sc.nextInt();
		int A=sc.nextInt();//비트
		int B=sc.nextInt();//코인
		int C=sc.nextInt();
		int D=sc.nextInt();
		int bitcoin1=0; int bitcoin2=0;
		int coin=0;
		coin=(Q/C)*D; Q%=C;
		int P1=P+(coin/B)*A;
		bitcoin1=(int)(P1/(A+B)*B);
		int restp=coin%B;
		if(P1%(A+B)>restp) {bitcoin1+=restp;}
		else {bitcoin1+=P1%(A+B);}
		
		int coin1=coin+(P/A)*B;
		bitcoin2=(int)(coin1/(A+B)*A);
		int restc=P%A;
		if(coin1%(A+B)>restc) {bitcoin2+=restc;}
		else {bitcoin2+=coin1%(A+B);}
		
		System.out.println(Math.max(bitcoin1,bitcoin2));
	}
	}

}
