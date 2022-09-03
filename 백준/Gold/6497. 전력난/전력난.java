import java.util.*;
class Node implements Comparable<Node>{
	int x, y, z;
	public Node(int x, int y, int z) {
		this.x=x; this.y=y; this.z=z;
	}
	
	@Override
	public int compareTo(Node arg0) {
		return this.z-arg0.z;
	}
}
public class Main {

	static int[] uf;
	static int disjoint(int x) {
		if(uf[x]!=x) {return uf[x]=disjoint(uf[x]);}
		else return x;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
		int M=sc.nextInt(); 
		int N=sc.nextInt();
		if(M==0&&N==0) {break;}
		uf=new int[M];
		ArrayList<Node> house =new ArrayList<Node>();
		long sum=0;
		for(int j=0; j<M; j++) {uf[j]=j;}
		int a=1,b=1;
		int count=0;
		for(int i=0; i<N; i++){
			a=sc.nextInt(); b=sc.nextInt();
			int c=sc.nextInt(); count++;
			house.add(new Node(a,b,c));
			sum+=c;
		}
		
		Collections.sort(house);
		long ss=0;
		for(int i=0; i<count; i++) {
			int x=house.get(i).x, y=house.get(i).y, z=house.get(i).z;
			if(disjoint(x)!=disjoint(y)) {
				uf[disjoint(y)]=uf[x];
				ss+=z;
			}
		}
		System.out.println(sum-ss);
		}
	}

}
