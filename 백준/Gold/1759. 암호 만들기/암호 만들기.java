import java.util.*;
public class Main {

	public static ArrayList<Integer> arr=new ArrayList<Integer>();
	public static TreeSet<String> tr=new TreeSet<String>();
	public static int[] visit=new int[20];
	public static void DP(int l, int m, char a, int len, char[] t){
		if(l==m){
			String s="";
			boolean isp=false;
			int count1=0, count2=0;
			for(int i=0; i<arr.size(); i++){
				int p=arr.get(i);
				s+=t[p];
				if(t[p]=='a'||t[p]=='e'||t[p]=='i'||t[p]=='o'||t[p]=='u'){count1++;}
				else{count2++;}
			}
			if(count1>0&&count2>1){isp=true;}
			if(isp){tr.add(s);}
			return;
		}
		for(int i=0; i<len; i++){
			if(((int)t[i])>=((int)a)){
			if(visit[i]!=0) continue;
			visit[i]=1;
			arr.add(i);
			DP(l+1, m, t[i],len, t);
			visit[i]=0;
			arr.remove(arr.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int L=sc.nextInt(); int C=sc.nextInt();
		char[] pass=new char[C];
		for(int i=0; i<C; i++){
			String a=sc.next();
			pass[i]=a.charAt(0);
		}
		DP(0,L,'a',C,pass);
		Iterator iter=tr.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

}
