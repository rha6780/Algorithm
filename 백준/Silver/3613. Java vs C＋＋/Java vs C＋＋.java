import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		sc.close();
		char[] arr=s.toCharArray();
		boolean isC=false, tuk=false, Sm=true;
		if(arr[0]>='A'&&arr[0]<='Z'||arr[0]=='_'){System.out.println("Error!"); return;}
		if(arr[s.length()-1]=='_'){System.out.println("Error!");return;}
		for(int i=0; i<s.length(); i++){
			if(arr[i]>='A'&&arr[i]<='Z'){isC=true;Sm=false;}
			else if(arr[i]=='_'){tuk=true;}
			if(i-1>=0&&arr[i-1]=='_'&&arr[i]=='_'){System.out.println("Error!");return;}
			if(isC&&tuk){System.out.println("Error!"); return;}
			if(!(arr[i]>='A'&&arr[i]<='Z')&&!(arr[i]>='a'&&arr[i]<='z')&&!(arr[i]=='_')){System.out.print("Error!"); return;}
		}
		if(isC&&!tuk){//JAVA
			for(int i=0; i<s.length(); i++){
				if(arr[i]>='A'&&arr[i]<='Z'){String ss=""+arr[i];System.out.print("_"+ss.toLowerCase());}
				else{System.out.print(arr[i]);}
			}
			return;
		}
		if(!isC&&tuk){//C++
			for(int i=0; i<s.length(); i++){
				if(i-1>=0&&arr[i-1]=='_'){String ss=""+arr[i];System.out.print(ss.toUpperCase());}
				else if(arr[i]!='_'){System.out.print(arr[i]);}
			}
			return;
		}
		if(!isC&&!tuk&&Sm){System.out.print(s);}

	}

}
