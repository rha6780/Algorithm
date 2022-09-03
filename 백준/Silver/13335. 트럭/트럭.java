import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int L=sc.nextInt(), W=sc.nextInt();
		Queue<Integer> que=new LinkedList<Integer>();
		int[] truck=new int[N+1];
		for(int i=0; i<N; i++){
			truck[i]=sc.nextInt();
		}
		int count=0;int time=0;int weight=0;
		while(true){
			if(count==N){break;}
			if(que.isEmpty()){
				que.add(truck[count]); time++;
				weight+=truck[count]; count++;
			}
			else if(que.size()==L){weight-=que.poll();}
			else{
				if(weight+truck[count]>W){
					que.add(0); time++; weight+=0;
				}
				if(weight+truck[count]<=W){que.add(truck[count]); weight+=truck[count]; time++; count++;}
			}
		}
		time+=L;
		System.out.println(time);
				

	}

}
