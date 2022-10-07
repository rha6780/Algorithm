import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		char[] sit=new char[N];
		String s=sc.next();
		for(int i=0; i<N; i++){
			sit[i]=s.charAt(i);
		}
		int noholder=0;
		int flag=1;
		for(int i=0; i<N; ){
			if(i==0){flag=1; i++;}
			else if(i>0){
				if(sit[i-1]==sit[i]&&sit[i]=='L'){
					if(flag==1){
						flag=0;
					}
					else{
						flag=0; noholder++;
					}
					i+=2;
				}
				else{
					i++;
				}
			}
			
		}
		
		System.out.println(N-noholder);

	}

}
