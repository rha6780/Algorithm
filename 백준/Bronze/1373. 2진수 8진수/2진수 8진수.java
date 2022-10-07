import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next(); 
		if(s.equals("0")){System.out.println(0);}
		else{
		StringBuilder ss=new StringBuilder();
		int two=1;
		int ten=0;
		int count=0;

		for(int i=s.length()-1; i>=0; i--){
			if(s.charAt(i)=='1'){ten+=two;}
			two*=2;
			count++;
			if(count==3){count=0; ss.append(ten);ten=0;two=1;}
		}
		if(ten>0){
		ss.append(ten);}
		
		for(int j=ss.length()-1; j>=0; j--) System.out.print(ss.charAt(j));
		}
	}

}
