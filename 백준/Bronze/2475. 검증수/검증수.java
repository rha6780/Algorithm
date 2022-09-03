import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] num=new int[5];
		int sum=0;
		for(int i=0; i<5; i++){
			num[i]=sc.nextInt();
			sum+=(num[i]*num[i])%10;
			if(sum>=10){sum%=10;}
		}
		System.out.println(sum);

	}

}
