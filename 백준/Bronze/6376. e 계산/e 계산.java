import java.util.*;
public class Main {

	public static void main(String[] args) {
		System.out.println("n e");
		System.out.println("- -----------");
		double result=1;
		double inc=1;
		for(int i=0; i<=9; i++){
			if(i==0){result=1; System.out.println(i+" "+1);}
			else if(i==1){result=2; System.out.println(i+" "+2);}
			else if(i==2){inc*=((double)1/(double)i); result+=inc; System.out.println(i+" "+2.5);}
			else{inc*=((double)1/(double)i); result+=inc; String format="%d %.9f"; System.out.println(String.format(format, i, result));}
			
		}

	}

}
