import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.nextLine();
		char[] sch=ss.toCharArray();
		boolean[] flag=new boolean[4];
		for(int i=0; i<ss.length(); i++) {
			if(sch[i]=='U') {flag[0]=true;}
			if(flag[0]&&sch[i]=='C') {flag[1]=true;}
			if(flag[1]&&sch[i]=='P') {flag[2]=true;}
			if(flag[2]&&sch[i]=='C') {flag[3]=true;}
		}
		boolean isucpc=true;
		for(int i=0; i<4; i++) {
			if(flag[i]==false) {isucpc=false;}
		}
		if(isucpc) {System.out.println("I love UCPC");}
		else System.out.println("I hate UCPC");

	}

}
