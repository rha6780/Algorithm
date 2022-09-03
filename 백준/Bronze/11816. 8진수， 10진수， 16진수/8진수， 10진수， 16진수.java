import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		sc.close();
		char[] arr=s.toCharArray();
		boolean hex=false, oct=false;
		if(s.length()-2>0&&arr[0]=='0'&&arr[1]=='x'){hex=true;}
		else if(s.length()-1>0&&arr[0]=='0'){oct=true;}
			if(hex==true){
				int su=0, count=1;
				for(int i=s.length()-1; i>1; i--){
					if(arr[i]>='0'&&arr[i]<='9'){int a=(int)(arr[i]-'0');su+=a*count;}
					else if(arr[i]>='a'&&arr[i]<='z'){su+=count*((arr[i]-'a')+10);}
					count*=16;
				}System.out.println(su);
			}
			else if(oct==true){
				int su=0, count=1;
				for(int j=s.length()-1; j>0; j--){
					int a=(int) (arr[j]-'0');
					su+=count*a;
					count*=8;
				}
				System.out.print(su);
			}
			else{
				for(int i=0; i<s.length(); i++)
				System.out.print(arr[i]);
			}

	}

}
