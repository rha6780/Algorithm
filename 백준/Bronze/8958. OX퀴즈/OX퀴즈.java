import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num, i, j=0, count=0;
		num=sc.nextInt();
		sc.nextLine();
		int []score=new int[num];
		String[] question=new String[num];
		for(i=0;i<num; i++) {question[i]=sc.nextLine();
		}
		for(i=0;i<num; i++) {
			char [] result=question[i].toCharArray();
			for(j=0;j<question[i].length(); j++) {
			if(result[j]=='O') {
				count++;}
			else if(result[j]=='X') {
				count=0;}
			
			score[i]=score[i]+count;}
			count=0;
			
		}
		for(i=0; i<num; i++) {
			System.out.println(score[i]);
		}
	
	}
}