import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int rest=(1000-N);
		int coin=0;
		while(rest!=0) {
			if(rest/500>0) {
				coin+=rest/500;
				rest=rest%500;
			}
			if(rest/100>0) {
				coin+=rest/100;
				rest=rest%100;
			}
			if(rest/50>0) {
				coin+=rest/50;
				rest=rest%50;
			}
			if(rest/10>0) {
				coin+=rest/10;
				rest=rest%10;
			}
			if(rest/5>0) {
				coin+=rest/5;
				rest=rest%5;
			}
			if(rest/1>0) {
				coin+=rest/1;
				rest=rest%1;
			}
		}
		System.out.println(coin);

	}

}