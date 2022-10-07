import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		if(N<=5){System.out.println(N);}
		else{
			N-=1;
			int rest=N%8;
			int result=0;
			if(rest==0){result=1;}
			else if(rest==7||rest==1){result=2;}
			else if(rest==2||rest==6){result=3;}
			else if(rest==5||rest==3){result=4;}
			else{result=5;}
			System.out.println(result);
		}
		

	}

}
