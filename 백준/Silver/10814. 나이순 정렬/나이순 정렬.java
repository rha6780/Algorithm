import java.util.*;
class member{
	int age; String name;
	public member(int age, String name){
		this.age=age; this.name=name;
	}
}
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		member[] mem=new member[N];
		for(int i=0; i<N; i++){
			int a=sc.nextInt(); String n=sc.next();
			mem[i]=new member(a,n);
		}
		Arrays.sort(mem, new Comparator<member>(){
			@Override
			public int compare(member m1, member m2){
				if(m1.age>m2.age){return 1;}
				else if(m1.age==m2.age){return 0;}
				else{return -1;}
			}
		});
		
		for(int i=0; i<N; i++){
			System.out.println(mem[i].age+" "+mem[i].name);
		}
	}

}
