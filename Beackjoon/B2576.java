import java.util.*;
import java.io.*;
public class B2576 {
	
	public static boolean hol(int a) {
		if(a%2==1) {return true;}
		else {return false;}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] num=new int[8];
		int Min=100000; int sum=0;
		for(int i=0; i<7; i++) {
			num[i]=Integer.parseInt(br.readLine());
			if(hol(num[i])) {sum+=num[i]; Min=Math.min(Min, num[i]);}
		}
		if(sum==0) {System.out.println(-1);}
		else {
			System.out.println(sum);
			System.out.println(Min);
		}
		

	}

}
