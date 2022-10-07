import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.xml.soap.Node;

import java.io.*;

public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();//가로
	public static int M=sc.nextInt();//세로
	public static int[][]tomato=new int[M][N];
	public static boolean[][]tosite=new boolean[M][N];
	public static int day=0;
	public static int rear=-1, front=0;
	public static int XX=-1, YY=0, xx,yy;
	public static Queue<Integer> qx=new LinkedList <Integer>();
	public static Queue<Integer> qy=new LinkedList <Integer>();
	
	public static void bfs() {
	int result=0;
		while(!qx.isEmpty()&&!qy.isEmpty()) {
			XX=qx.poll();
			YY=qy.poll();
			tosite[XX][YY]=true;
			for(int i=0; i<4; i++) {
				switch(i) {
				case 0: xx=XX-1; yy=YY;break;
				case 1: xx=XX+1; yy=YY;break;
				case 2: xx=XX; yy=YY-1;break;
				case 3: xx=XX; yy=YY+1;break;
				}
				if(xx<M&&yy<N&&xx>=0&&yy>=0) {
				if(tomato[xx][yy]==0&&tosite[xx][yy]==false) {
					qx.add(xx);
					qy.add(yy);
					tosite[xx][yy]=true;
					tomato[xx][yy]=tomato[XX][YY]+1;
					result=tomato[xx][yy];
				}
				}
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N ;j++) {
				if(tomato[i][j]==0) {
					result=-1;
				}
			}
		}
		if(result>0)System.out.println(result-1);
		else System.out.println(result);
	}
	public static void main(String[] args) {
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N ;j++) {
				tomato[i][j]=sc.nextInt();
				if(tomato[i][j]==1) {
					qx.add(i);
					qy.add(j);
				}
			}
		}
		bfs();
	}
}
