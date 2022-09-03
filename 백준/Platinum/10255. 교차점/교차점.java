import java.util.Scanner;
public class Main {
	public static int count=0, kk=-1;
	public static int Area(long x1, long y1, long x2, long y2, long x3, long y3 ){
		long sum=0;
		sum=((x1*y2)-(x2*y1)+(x2*y3)-(x3*y2)+(x3*y1)-(x1*y3));
		if(sum==0) return 0;
		else if(sum>0) return 1;
		else return -1;
	}
	public static void angle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
		float a1=0, a2=0;
		if(x1-x2==0){a1=0;} else {a1=(float)((y1-y2)/(x1-x2));}
		if(x3-x4==0){a2=0;} else {a2=(float)((y3-y4)/(x3-x4));}
		if(a1==a2&&(x3-x4==0&&x1-x2==0||y3-y4==0&&y1-y2==0)){
			
		if(Math.max(x1, x2)<Math.min(x3, x4)){return;}
		if(Math.max(x3, x4)<Math.min(x1, x2)){return;}
		if(Math.max(y1, y2)<Math.min(y3, y4)){return;}
		if(Math.max(y3, y4)<Math.min(y1, y2)){return;}
		else{count=8;}//둘이 겹칠때
		
		if(x3-x4==0&&x1-x2==0&&x3==x1){
			if(Math.max(y1, y2)==Math.min(y3, y4)){count=1; return;}
			if(Math.max(y3, y4)==Math.min(y1, y2)){count=1; return;}
		}
		else if(y3-y4==0&&y1-y2==0&&y1==y3){
			if(Math.max(x1, x2)==Math.min(x3, x4)){count=1; return;}
			if(Math.max(x3, x4)==Math.min(x1, x2)){count=1; return;}
		}
			}
	}
	public static int judge(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
		count=0; kk=-1;
		int a1=Area(x1, y1, x2, y2, x3, y3), a2=Area(x1, y1, x2, y2, x4, y4);
		int b1=Area(x3, y3, x4, y4, x1, y1), b2=Area(x3, y3, x4, y4, x2, y2);
		if(a1*a2==0&&b1*b2==0){//삼각형의 넓이가 없음.->같은선상/겹침
			if(a1==0&&a2==0&&b1==0&&b2==0){// 겹치거나 같은 선상 있거나 
				angle(x1, y1,x2,y2,x3,y3,x4,y4);
				return count;}
			else{//한점으로 만남
				kk=0;
				return 1;
			}
			}
		else if((a1*a2<0&&b1*b2<0)){kk=-1;
			return 1;
		}
		else if((a1*a2<=0&&b1*b2<0)){kk=0;
			return 1;
		}
		else if((a1*a2<0&&b1*b2<=0)){kk=0;
			return 1;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T; i++){
			
			int c=0;
			int xmin=sc.nextInt();
			int ymin=sc.nextInt();
			int xmax=sc.nextInt();
			int ymax=sc.nextInt();
			int x1=sc.nextInt(), y1=sc.nextInt(), x2=sc.nextInt(), y2=sc.nextInt();
			
			c+=judge(xmin, ymin, xmin, ymax, x1, y1, x2, y2);//왼쪽 라인
			//System.out.println("L"+" "+c);
			c+=judge(xmin, ymin, xmax, ymin, x1, y1, x2, y2);//아래 라인
			//System.out.println("d"+" "+c);
			c+=judge(xmin, ymax, xmax, ymax, x1, y1, x2, y2);//위 라인
			//System.out.println("u"+" "+c);
			c+=judge(xmax, ymin, xmax, ymax, x1, y1, x2, y2);//오른쪽 라인
			//System.out.println("R"+" "+c);
			
			if(Area(x1, y1,x2,y2,xmax,ymax)==0&&c>1){c--;}
			if(Area(x1, y1,x2,y2,xmax,ymin)==0&&c>1){c--;}
			if(Area(x1, y1,x2,y2,xmin,ymax)==0&&c>1){c--;}
			if(Area(x1, y1,x2,y2,xmin,ymin)==0&&c>1){c--;}
			if(c>4){c=4;}
			
			System.out.println(c);
		}
	}
}