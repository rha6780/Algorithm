import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.next();
		ss=ss.toUpperCase();
		int[] count=new int[52];
		int Max=0;
		char result='?';
		for(int i=0; i<ss.length(); i++) {
			count[ss.charAt(i)-'A']++;
			if(Max<count[ss.charAt(i)-'A']) {
				Max=count[ss.charAt(i)-'A'];
				result=ss.charAt(i);
			}	
			else if(Max==count[ss.charAt(i)-'A']) {result='?';}

		}
		System.out.println(result);		
		
	}

}
