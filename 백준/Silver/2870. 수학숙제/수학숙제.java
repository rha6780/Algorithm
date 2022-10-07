import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String[] word=new String[N];
		String[] num=new String[10001];
		
		String[] nn=new String[10001];
		int count=0;
		for(int i=0; i<N; i++){
			word[i]=sc.next();
			String s="";
			for(int j=0; j<word[i].length(); j++){
				if(word[i].charAt(j)>='a'&&word[i].charAt(j)<='z'){if(s!=""){nn[count]=s;count++;s="";}}
				else{s+=word[i].charAt(j);}
			}
			if(s!=""){nn[count]=s; count++; s="";}
		}
		num=new String[count];
		for(int i=0; i<count; i++){
			boolean isz=false; String tmp="";
			for(int j=0; j<nn[i].length()-1; j++){
				if(nn[i].charAt(j)=='0'&&!isz){tmp+="";}
				else{isz=true; tmp+=nn[i].charAt(j);}
			}
			tmp+=nn[i].charAt(nn[i].length()-1);
			if(tmp!="")num[i]=tmp;
			//System.out.println(nn[i]);
		}
		Arrays.sort(num, new Comparator<String>(){
			@Override
			public int compare(final String e1,final String e2){
				if(e1.length()<e2.length()){return -1;}
				else if(e1.length()==e2.length()){return e1.compareTo(e2);}
				else{
					return 1;
				}
			}
		});
		
		for(int i=0; i<count; i++){System.out.println(num[i]);}
	}

}
