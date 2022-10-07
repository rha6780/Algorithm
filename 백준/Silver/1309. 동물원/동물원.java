import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long[][] lion=new long[N+1][3];
		long[] count=new long[N+1];
		for(int i=0; i<N; i++){
			if(i==0){lion[i][0]=1;lion[i][1]=1;lion[i][2]=1;}
			else{
				lion[i][0]=count[i-1];lion[i][1]=count[i-1]-lion[i-1][1];lion[i][2]=count[i-1]-lion[i-1][2];
				lion[i][0]%=9901;lion[i][1]%=9901;lion[i][2]%=9901;
			}
			count[i]=lion[i][0]+lion[i][1]+lion[i][2];
			if(count[i]>(9901*3)+1)
			count[i]%=9901;
		}
		count[N-1]%=9901;
		System.out.println(count[N-1]);
	}
}