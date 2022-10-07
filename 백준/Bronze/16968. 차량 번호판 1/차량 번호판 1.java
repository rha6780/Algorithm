import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String format=sc.next();
		char[] form=format.toCharArray();
		int count=1;
		for(int i=0; i<form.length; i++) {
			if(i>=1&&form[i]==(form[i-1])) {
				if(form[i]=='d') {
					count*=9;
				}
				else if(form[i]=='c') {
					count*=25;
				}
			}else
				if(form[i]=='d') count*=10;
			else if(form[i]=='c') count*=26;
		}
		System.out.println(count);
	}

}