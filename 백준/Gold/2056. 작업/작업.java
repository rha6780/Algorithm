import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		int[] time=new int[N+1];
		int[] siz=new int[N+1];
		int[] step=new int[N+1];
		for(int i=0; i<=N; i++){arr.add(new ArrayList<Integer>());}
		for(int i=1; i<=N; i++){
			time[i]=sc.nextInt();step[i]=time[i];
			int a=sc.nextInt(); siz[i]=a;
			for(int j=0; j<a; j++){
				int b=sc.nextInt();
				arr.get(b).add(i);
				
			}
		}
		Queue<Integer> que=new LinkedList<Integer>();
		for(int i=1; i<=N; i++){
			if(siz[i]==0){que.add(i); step[i]=time[i];}
		}
		int result=0;
		while(!que.isEmpty()){
			int t=que.remove();
			//System.out.println(t+"/");
			
			for(int j=0; j<arr.get(t).size(); j++){
				int h=arr.get(t).get(j); 
				if(time[h]<time[t]+step[h]){time[h]=step[h]+time[t];}
				siz[h]--;
				if(siz[h]==0){que.add(h); step[h]+=time[h];}
			}
			
		}
		for(int i=1; i<=N; i++){
			if(result<time[i]){result=time[i];}
		}
		System.out.println(result);
	}

}
