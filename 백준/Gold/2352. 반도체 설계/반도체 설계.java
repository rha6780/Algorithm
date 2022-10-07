import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] line=new int[N];
		int[] count=new int[N];
		for(int i=0; i<N; i++){
			line[i]=sc.nextInt();
		}
		
		for(int i=0; i<N; i++){
			for(int j=0; j<i; j++){
				if(line[i]>line[j]){
					if(count[i]<count[j]){
						count[i]=count[j];
					}
				}
			}
			count[i]++;
		}
		int Max=0;
		for(int i=0; i<N; i++){
			
			if(Max<count[i]){
				Max=count[i];
			}
		}
		System.out.println(Max);
	}

}
