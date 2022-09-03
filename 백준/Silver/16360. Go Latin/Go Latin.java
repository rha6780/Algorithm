import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			String s=sc.next();
			String ss="";
			int len=s.length();
			char[] carr=s.toCharArray();
			for(int ii=0; ii<len-2; ii++) {ss+=carr[ii];}
			if(carr[len-1]=='a') {ss=s+"s";}
			else if(carr[len-1]=='i') {ss=s+"os";}
			else if(carr[len-1]=='y') {ss+=carr[len-2]+"ios";}
			else if(carr[len-1]=='n') {ss+=carr[len-2]+"anes";}
			else if(carr[len-2]=='n'&&carr[len-1]=='e') {ss+="anes";}
			else if(carr[len-1]=='o'||carr[len-1]=='u') {ss=s+"s";}
			else if(carr[len-1]=='r'||carr[len-1]=='v'||carr[len-1]=='l') {ss=s+"es";}
			else if(carr[len-1]=='t'||carr[len-1]=='w') {ss=s+"as";}
			else {ss=s+"us";}
			System.out.println(ss);
		}

	}

}
