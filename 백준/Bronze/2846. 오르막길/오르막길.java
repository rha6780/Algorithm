import java.util.*;

public class Main {

	public static void main(String[] arg){
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] height=new int[N];
		int MaxH=0;int min=0;
		for(int i=0; i<N; i++){
			height[i]=sc.nextInt();
			if(i==0){min=height[0];}
			if(i>=1&&height[i-1]>=height[i]){min=height[i];}
			else if(min<height[i]){if(MaxH<=height[i]-min){MaxH=height[i]-min;}}
		}
		System.out.println(MaxH);
	}
}
