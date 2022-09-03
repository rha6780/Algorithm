import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int s=sc.nextInt();
		int m=sc.nextInt();
		int[] eatT=new int[m+1];

		int[] cc=new int[m+1];
		for(int i=0; i<m; i++){
			eatT[i]=sc.nextInt();
		}
		if(n-s<=m){System.out.println(n-s);}
		else{
			int rest=n-s-m;
			int count=1;
			int rr=rest, ii=0;
			boolean bb=false;
			while(!bb){
				for(int k=0; k<m; k++){
					if(count/eatT[k]>cc[k]){cc[k]++; rr--; ii++;}
					if(rr==0){System.out.print(k+1); bb=true;break;}
				}
				count++;
			}
		}
		sc.close();

	}

}
