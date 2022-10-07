import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static Node path;
	
	public static void add(String dat1, String dat2, String dat3) {
		
		if(path==null) {
		if(dat1!=".") {path =new Node(dat1);}
		if(dat2!=".") {path.left=new Node(dat2);}
		if(dat3!=".") {path.right=new Node(dat3);}
		
		}
		else {position(path, dat1, dat2, dat3);}
	
	}
	public static void position(Node nod, String data, String ldata, String rdata) {
		if(nod==null) {return;}
		else if(nod.data.equals(data)) {//null자리에 자식들만 입력필요한 경우
			if(!ldata.equals(".")) nod.left=new Node(ldata);
			if(!rdata.equals(".")) nod.right=new Node(rdata);
		}
		else {//탐색 자리 남는곳
			position(nod.left, data, ldata, rdata);
			position(nod.right, data, ldata, rdata);
		}
	}
	
	public static void prepat(Node nod) {
		if(!nod.data.equals("."))System.out.print(nod.data);
		if(nod.left!=null) {prepat(nod.left);}
		if(nod.right!=null) {prepat(nod.right);}
	
	}
	public static void inpat(Node nod) {
		
		if(nod.left!=null) {inpat(nod.left);}
		if(!nod.data.equals("."))System.out.print(nod.data);
		if(nod.right!=null) {inpat(nod.right);}
		
	}
	public static void postpat(Node nod) {
		if(nod.left!=null) {postpat(nod.left);}
		if(nod.right!=null) {postpat(nod.right);}
		if(!nod.data.equals("."))System.out.print(nod.data);
	}
	
	
	
	public static void main(String[] args) {
	
		String[][] da=new String[N][3];
		for(int i=0; i<N;i++) {
			da[i][0]=sc.next();
			da[i][1]=sc.next();
			da[i][2]=sc.next();
			
			
		}
		Arrays.sort(da, new Comparator<String[]>() {
			@Override
			public int compare(final String[] entry1, final String[] entry2) {
				final String time1=entry1[0];
				final String time2=entry2[0];
				return time1.compareTo(time2);
			}
		});
		for(int i=0; i<N; i++)
			add(da[i][0],da[i][1],da[i][2]);
		
		prepat(path);
		System.out.println();
		inpat(path);
		System.out.println();
		postpat(path);
	}

}
class Node {
		String data;
		Node left, right;
		public Node(String data) {this.data=data;}
	}