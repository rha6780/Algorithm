import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String[] word=new String[15];
		for(int i=1; i<15; i++) {
			if(i==1||i==13) {word[i]="baby";}
			else if(i==2||i==14) {word[i]="sukhwan";}
			else if(i==3||i==7||i==11) {word[i]="tururu";}
			else if(i==4||i==8||i==12) {word[i]="turu";}
			else if(i==5) {word[i]="very";}
			else if(i==6) {word[i]="cute";}
			else if(i==9) {word[i]="in";}
			else if(i==10) {word[i]="bed";}
		}
		if(N<15) {System.out.println(word[N]);}
		else {
			int k=N/14; int ind=N%14;
			if((ind==3||ind==7||ind==11)) {
				if(k>=3) {System.out.println("tu+ru*"+(k+2));}
				else {for(int j=0; j<k; j++){word[ind]+="ru";}System.out.println(word[ind]);}
			}
			else if((ind==4||ind==8||ind==12)) {
				if(k>=4) {System.out.println("tu+ru*"+(k+1));}
				else {for(int j=0; j<k; j++){word[ind]+="ru";}System.out.println(word[ind]);}
			}
			else if(ind==0) {System.out.println("sukhwan");}
			else {
				System.out.println(word[ind]);
			}
		}

	}

}
