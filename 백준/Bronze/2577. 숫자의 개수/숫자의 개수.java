import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int []result=new int [10];
		int []count=new int [10];
		int a=0,b=0,c=0,i=0,j, k,ten=10,len=0;
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		k=(a*b*c);
		while((k/ten)!=0 ){
			result[i]=k%ten;
			k=k/ten;
			if(k<10) {result[i+1]=k; break;}
			i++;
		}
		len=i+2;
		for(i=0; i<10;i++) {
			for(j=0; j<len;j++)
			if(result[j]==i) {
				count[i]++;
			}
		}
		for(i=0; i<10;i++) {
			System.out.println(count[i]);
		}
	}
}