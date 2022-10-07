import java.util.*;
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String A=sc.next(), B=sc.next();
		int Max=0, Min=Integer.MAX_VALUE;
		String aa="", a="";
		for(int i=0; i<A.length(); i++){
			if(A.charAt(i)=='5'){aa+="6";}
			else{aa+=A.charAt(i);}
			if(A.charAt(i)=='6'){a+='5';}
			else{a+=A.charAt(i);}
		}
		String bb="", b="";
		for(int i=0; i<B.length(); i++){
			if(B.charAt(i)=='5'){bb+="6";}
			else {bb+=B.charAt(i);}
			if(B.charAt(i)=='6'){b+='5';}
			else {b+=B.charAt(i);}
		}
		Max=Integer.parseInt(aa)+Integer.parseInt(bb);
		Min=Integer.parseInt(a)+Integer.parseInt(b);
		System.out.println(Min+" "+Max);
	}

}
