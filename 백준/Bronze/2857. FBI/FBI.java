import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String[] people=new String[5];
		for(int i=0; i<5; i++)
			people[i]=sc.next();
		int count=0;
		boolean[] isF=new boolean[5];
		for(int j=0; j<5; j++){
			for(int h=0; h<=people[j].length()-3; h++){
				if(people[j].charAt(h)=='F'&&people[j].charAt(h+1)=='B'&&people[j].charAt(h+2)=='I'){
					count++;
					isF[j]=true;
				}
			}
		}
		if(count==0){
			System.out.println("HE GOT AWAY!");
		}
		else{
			for(int i=0; i<5; i++){
				if(isF[i]){System.out.print(i+1+" ");}
			}
		}

	}

}
