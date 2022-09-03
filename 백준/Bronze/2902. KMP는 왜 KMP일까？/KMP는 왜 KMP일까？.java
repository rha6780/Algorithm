import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		char[] str=new char[120];
		str=s.toCharArray();
		String result="";
		for(int i=0; i<s.length(); i++){
			if(i==0||(i>0&&str[i-1]=='-')){result+=str[i];}
		}
		System.out.println(result);
	}

}
