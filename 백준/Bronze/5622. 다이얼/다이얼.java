import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String ss=sc.next();
		sc.close();
		int[] num=new int[10];
		num[0]=12;
		for(int i=1; i<10; i++) {
			num[i]=1+i;
		}
		int time=0;
		for(int i=0; i<ss.length(); i++) {
			int mok=0;
			char aa=ss.charAt(i);
			if('A'<=aa&&'C'>=aa) {
				time+=num[2];
			}
			else if('D'<=aa&&'F'>=aa) {
				time+=num[3];
			}
			else if('G'<=aa&&'I'>=aa) {
				time+=num[4];
			}
			else if('J'<=aa&&'L'>=aa) {
				time+=num[5];
			}
			else if('M'<=aa&&'O'>=aa) {
				time+=num[6];
			}
			else if('P'<=aa&&'S'>=aa) {
				time+=num[7];
			}
			else if('T'<=aa&&'V'>=aa) {
				time+=num[8];
			}
			else {
				time+=num[9];
			}
			
		}
		System.out.println(time);
	}

}
