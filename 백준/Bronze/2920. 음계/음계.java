import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int i;boolean resultup=false, resultdown=false;
		Scanner sc=new Scanner(System.in);
		int []mel=new int [8];
		for(i=0; i<8;i++) {
			mel[i]=sc.nextInt();
	}

		for(i=0; i<7; i++) {
			if(mel[i]==mel[i+1]-1)
					resultdown=true;
			else if(mel[i]==mel[i+1]+1) 
					resultup=true;
			else
				{System.out.print("mixed"); return;}	
}
		if(resultup==true)
			System.out.print("descending");	
		else if(resultdown==true)
			System.out.print("ascending");	
}
}