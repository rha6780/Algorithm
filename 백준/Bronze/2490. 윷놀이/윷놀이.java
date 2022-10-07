import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[]yut=new int [4];int b=0, d=0;
		for(int i=0; i<3; i++) {
			d=0;
			yut=new int[4];
			for(int j=0; j<4; j++) {
				yut[j]=sc.nextInt();
				if(yut[j]==1) {
					d++;
				}
			}
			if(d==4)System.out.println("E");
			else if(d==1)System.out.println("C");
			else if(d==2)System.out.println("B");
			else if(d==0)System.out.println("D");
			else System.out.println("A");
				
		}
	}

}