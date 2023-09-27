import java.util.Scanner;
import java.util.Random;

public class Tictactoe {
	
	//defining matrix
	static char tictac[][]=new char[3][3];
	static char X='X',O='O';
	//for getting output
	static void print() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
			System.out.print(tictac[i][j]);
			
			}System.out.println();
		}	
		
	}
	
	//from git hub for win/loose
	static boolean check(int N,int M,char ch) {
		boolean winlse=false;
		
		if(rawcheck(N,M)==true) {
		winlse=true;	
		}else if(colomncheck(N,M)==true) {
			winlse=true;
		}else if(diagcheck(N,M)==true) {
			winlse=true;
		}else if(antidiagcheck(N,M)==true) {
			winlse=true;
		}
		return winlse;
		
	}
	
	
	static boolean rawcheck(int N,int M) {
		//k is input
		int k=N;
		char x=X;
			boolean winplayer=false;
			
			//check raw 
			for(int j=0;j<3;j++) {
				if(tictac[k][j]==x) {
					winplayer=true;
					//System.out.println("raw true ok");
				}else {
					winplayer=false;
					//System.out.println("raw false ok");
					break;
				}
			}
			return winplayer;
	}
	static boolean colomncheck(int N,int M) {
		char x=X;
			boolean winplayer=false;
			
			
			//check colomn
			int m=M;
			for(int j=0;j<3;j++) {
				if(tictac[j][m]==x) {
					winplayer=true;
					//System.out.println("colomn true ok");
				}else {
					winplayer=false;
					//System.out.println("colomn false ok");
					break;
				}
			}
			return winplayer;
	}
	static boolean diagcheck(int N,int M) {
		//k is input
		int k;
		char x=X;
			boolean winplayer=false;
			
			//check diagonal
				for(k=0;k<3;k++) {
					if(tictac[k][k]==x) {
						winplayer=true;
						//System.out.println("d true ok");
					}else {
						winplayer=false;
						//System.out.println("d false ok");
						break;
					}
				}
				return winplayer;
	}
	static boolean antidiagcheck(int N,int M) {
		//k is input
		char x=X;
			boolean winplayer=false;
			
				//anti diagonal
			for(int i=0;i<3;i++) {
				for(int j=2;j>=0;j--) {
						if(tictac[i][j]==x) {
							winplayer=true;
							//System.out.println("ad true ok");
						}else {
								winplayer=false;
								//System.out.println("ad false ok");
							break;
						}
				}
			}
				return winplayer;
	}
			
	public static char display(int N,int M,char ch) {
			//for winner announce
		char won='n';
			if(check(N,M,ch)==true) {
				if(ch==X) {
					//print();
				//System.out.println("you won!");
				
				won='y';
				}else if(ch==O) {
					//print();
					//System.out.println("you loss! think more.");
					won='y';
						
				}
			}
			return won;
		}
	public static int randomgenarator(int n,int m) {
		Random num=new Random(); 
		 int n1=n;
		while(n1==n||n1==m){
			n1=num.nextInt(3);
		}
		return n1;
	}

/*	public static void oinput(int n,int m,int count) {
		if (count==1 && (tictac[1][1]=='_')) {
			tictac[1][1]=O;
			display(n,m,O);
		}else if(count==1 && (n==1&&m==1)) {
			int n1=randomgenarator(n,m);
			int n2=randomgenarator(n,m);
			tictac[n1][n2]=O;
			display(n,m,O);
		}else if(count==3) {
			if(tictac[1][1]==X) {
				if(tictac[0][0]==O) {
					if(tictac[0][1]==X){
						tictac[2][1]=O;
						return;
					}else if(tictac[0][2]==X) {
						tictac[2][0]=O;
						return;
					}else if(tictac[1][0]==X) {
						tictac[1][2]=O;
						return;
					}else if(tictac[1][2]==X) {
						tictac[1][0]=O;
						return;
					}else if(tictac[2][0]==X) {
						tictac[0][2]=O;
						return;
					}else if(tictac[2][1]==X) {
						tictac[0][1]=O;
						return;
					}else {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_') {
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[0][1]==O) {
					if(tictac[0][0]==X) {
						tictac[2][2]=O;
						return;
					}else if(tictac[0][2]==X) {
						tictac[2][0]=O;
						return;
					}else if(tictac[1][0]==X) {
						tictac[1][2]=O;
						return;
					}else if(tictac[1][2]==X) {
						tictac[1][0]=O;
						return;
					}else if(tictac[2][0]==X) {
						tictac[0][2]=O;
						return;
					}else if(tictac[2][2]==X) {
						tictac[0][0]=O;
						return;
					}else {
						int n1=2,n2=1;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[0][2]==O) {
					if(tictac[0][0]==X) {
						tictac[2][2]=O;
						return;
					}if(tictac[0][1]==X){
						tictac[2][1]=O;
						return;
					}else if(tictac[1][0]==X) {
						tictac[1][2]=O;
						return;
					}else if(tictac[1][2]==X) {
						tictac[1][0]=O;
						return;
					}else if(tictac[2][1]==X) {
						tictac[0][1]=O;
						return;
					}else if(tictac[2][2]==X) {
						tictac[0][0]=O;
						return;
					}else {
						int n1=2,n2=0;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[1][0]==O) {
					if(tictac[0][0]==X) {
						tictac[2][2]=O;
						return;
					}if(tictac[0][1]==X){
						tictac[2][1]=O;
						return;
					}else if(tictac[0][2]==X) {
						tictac[2][0]=O;
						return;
					}else if(tictac[2][0]==X) {
						tictac[0][2]=O;
						return;
					}else if(tictac[2][1]==X) {
						tictac[0][1]=O;
						return;
					}else if(tictac[2][2]==X) {
						tictac[0][0]=O;
						return;
					}else {
						int n1=1,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[1][2]==O) {
					if(tictac[0][0]==X) {
						tictac[2][2]=O;
						return;
					}if(tictac[0][1]==X){
						tictac[2][1]=O;
						return;
					}else if(tictac[0][2]==X) {
						tictac[2][0]=O;
						return;
					}else if(tictac[2][0]==X) {
						tictac[0][2]=O;
						return;
					}else if(tictac[2][1]==X) {
						tictac[0][1]=O;
						return;
					}else if(tictac[2][2]==X) {
						tictac[0][0]=O;
						return;
					}else {
						int n1=1,n2=0;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[2][0]==O) {
					if(tictac[0][0]==X) {
						tictac[2][2]=O;
						return;
					}if(tictac[0][1]==X){
						tictac[2][1]=O;
						return;
					}else if(tictac[1][0]==X) {
						tictac[1][2]=O;
						return;
					}else if(tictac[1][2]==X) {
						tictac[1][0]=O;
						return;
					}else if(tictac[2][1]==X) {
						tictac[0][1]=O;
						return;
					}else if(tictac[2][2]==X) {
						tictac[0][0]=O;
						return;
					}else {
						int n1=0,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[2][1]==O) {
					if(tictac[0][0]==X) {
						tictac[2][2]=O;
						return;
					}else if(tictac[0][2]==X) {
						tictac[2][0]=O;
						return;
					}else if(tictac[1][0]==X) {
						tictac[1][2]=O;
						return;
					}else if(tictac[1][2]==X) {
						tictac[1][0]=O;
						return;
					}else if(tictac[2][0]==X) {
						tictac[0][2]=O;
						return;
					}else if(tictac[2][2]==X) {
						tictac[0][0]=O;
						return;
					}else {
						int n1=0,n2=1;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[2][2]==O) {
					if(tictac[0][1]==X){
						tictac[2][1]=O;
						return;
					}else if(tictac[0][2]==X) {
						tictac[2][0]=O;
						return;
					}else if(tictac[1][0]==X) {
						tictac[1][2]=O;
						return;
					}else if(tictac[1][2]==X) {
						tictac[1][0]=O;
						return;
					}else if(tictac[2][0]==X) {
						tictac[0][2]=O;
						return;
					}else if(tictac[2][1]==X) {
						tictac[0][1]=O;
						return;
					}else {
						int n1=0,n2=0;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}
			}else if(tictac[1][1]==O) {
				if(tictac[0][0]==X) {
					if(tictac[0][1]==X) {
						tictac[0][2]=O;
						return;
					}if(tictac[0][2]==X) {
						tictac[0][1]=O;
						return;
					}if(tictac[1][0]==X) {
						tictac[2][0]=O;
						return;
					}if(tictac[2][0]==X) {
						tictac[1][0]=O;
						return;
					}if(tictac[1][2]==X||tictac[2][2]==X||tictac[2][1]==X) {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[0][1]==X) {
					if(tictac[0][0]==X) {
						tictac[0][2]=O;
						return;
					}if(tictac[0][2]==X) {
						tictac[0][0]=O;
						return;
					}else {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[0][2]==X) {
					if(tictac[0][0]==X) {
						tictac[0][1]=O;
						return;
					}if(tictac[0][1]==X) {
						tictac[0][0]=O;
						return;
					}if(tictac[1][2]==X) {
						tictac[2][2]=O;
						return;
					}if(tictac[2][2]==X) {
						tictac[1][2]=O;
						return;
					}else {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[0][1]==X) {
					if(tictac[0][0]==X) {
						tictac[2][0]=O;
						return;
					}if(tictac[2][0]==X) {
						tictac[0][0]=O;
						return;
					}else {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[1][2]==X) {
					if(tictac[0][2]==X) {
						tictac[2][2]=O;
						return;
					}if(tictac[2][2]==X) {
						tictac[0][2]=O;
						return;
					}else {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[2][0]==X) {
					if(tictac[0][0]==X) {
						tictac[1][0]=O;
						return;
					}if(tictac[1][0]==X) {
						tictac[0][0]=O;
						return;
					}if(tictac[2][1]==X) {
						tictac[2][2]=O;
						return;
					}if(tictac[2][2]==X) {
						tictac[2][1]=O;
						return;
					}else {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}if(tictac[2][1]==X) {
					if(tictac[2][0]==X) {
						tictac[2][2]=O;
						return;
					}if(tictac[2][2]==X) {
						tictac[2][0]=O;
						return;
					}else {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}else {
					if(tictac[0][2]==X) {
						tictac[1][2]=O;
						return;
					}if(tictac[1][2]==X) {
						tictac[0][2]=O;
						return;
					}if(tictac[2][0]==X) {
						tictac[2][1]=O;
						return;
					}if(tictac[2][1]==X) {
						tictac[2][0]=O;
						return;
					}else {
						int n1=2,n2=2;
						while(tictac[n1][n2]!='_'){
							n1=randomgenarator(n1,n2);
							n2=randomgenarator(n1,n2);
						}
						tictac[n1][n2]=O;
						return;
					}
				}
			}
		}else if(count==5) {
				if(tictac[0][0]=='_') {
					 tictac[0][0]=X;
					 if(display(0,0,X)=='y') {
						 tictac[0][0]=O;
						 
					 }else {
						 tictac[0][0]='_';
					 }
					 tictac[0][0]=O;
					 if(display(0,0,O)=='y') {
						 tictac[0][0]=O;
						 
					 }else {
						 tictac[0][0]='_';
					 }
				}else if(tictac[0][1]=='_') {
					tictac[0][1]=X;
					 if(display(0,1,X)=='y') {
						 tictac[0][1]=O;
					 }else {
						 tictac[0][1]='_';
					 }
				}else if(tictac[0][2]=='_') {
					tictac[0][2]=X;
					 if(display(0,2,X)=='y') {
						 tictac[0][2]=O;
					 }else {
						 tictac[0][2]='_';
					 }
				}else if(tictac[1][0]=='_') {
					tictac[1][0]=X;
					 if(display(1,0,X)=='y') {
						 tictac[1][0]=O;
					 }else {
						 tictac[1][0]='_';
					 }
				}else if(tictac[1][1]=='_') {
					tictac[1][1]=X;
					 if(display(1,1,X)=='y') {
						 tictac[1][1]=O;
					 }else {
						 tictac[1][1]='_';
					 }
				}else if(tictac[1][2]=='_') {
					tictac[1][2]=X;
					 if(display(1,2,X)=='y') {
						 tictac[1][2]=O;
					 }else {
						 tictac[1][2]='_';
					 }
				}else if(tictac[2][0]=='_') {
					tictac[2][0]=X;
					 if(display(2,0,X)=='y') {
						 tictac[2][0]=O;
					 }else {
						 tictac[2][0]='_';
					 }
				}else if(tictac[2][1]=='_') {
					tictac[2][1]=X;
					 if(display(2,1,X)=='y') {
						 tictac[2][1]=O;
					 }else {
						 tictac[2][1]='_';
					 }
				}else if(tictac[2][2]=='_'){
					tictac[2][2]=X;
					 if(display(2,2,X)=='y') {
						 tictac[2][2]=O;
					 }else {
						 tictac[2][2]='_';
					 }
				}else {
					int n1=0,n2=0;
					while(tictac[0][0]!='_'&&display(n1,n2,'O')=='y') {
						n1=randomgenarator(n1,n2);
						n2=randomgenarator(n1,n2);
					}tictac[n1][n2]=O;
				}
			}else if(count==7) {
				if(tictac[0][0]=='_') {
					 tictac[0][0]=X;
					 if(display(0,0,X)=='y') {
						 tictac[0][0]=O;
					 }else {
						 tictac[0][0]='_';
					 }
				}else if(tictac[0][1]=='_') {
					tictac[0][1]=X;
					 if(display(0,1,X)=='y') {
						 tictac[0][1]=O;
					 }else {
						 tictac[0][1]='_';
					 }
				}else if(tictac[0][2]=='_') {
					tictac[0][2]=X;
					 if(display(0,2,X)=='y') {
						 tictac[0][2]=O;
					 }else {
						 tictac[0][2]='_';
					 }
				}else if(tictac[1][0]=='_') {
					tictac[1][0]=X;
					 if(display(1,0,X)=='y') {
						 tictac[1][0]=O;
					 }else {
						 tictac[1][0]='_';
					 }
				}else if(tictac[1][1]=='_') {
					tictac[1][1]=X;
					 if(display(1,1,X)=='y') {
						 tictac[1][1]=O;
					 }else {
						 tictac[1][1]='_';
					 }
				}else if(tictac[1][2]=='_') {
					tictac[1][2]=X;
					 if(display(1,2,X)=='y') {
						 tictac[1][2]=O;
					 }else {
						 tictac[1][2]='_';
					 }
				}else if(tictac[2][0]=='_') {
					tictac[2][0]=X;
					 if(display(2,0,X)=='y') {
						 tictac[2][0]=O;
					 }else {
						 tictac[2][0]='_';
					 }
				}else if(tictac[2][1]=='_') {
					tictac[2][1]=X;
					 if(display(2,1,X)=='y') {
						 tictac[2][1]=O;
					 }else {
						 tictac[2][1]='_';
					 }
				}else if(tictac[2][2]=='_'){
					tictac[2][2]=X;
					 if(display(2,2,X)=='y') {
						 tictac[2][2]=O;
					 }else {
						 tictac[2][2]='_';
					 }
				}else {
					int n1=0,n2=0;
					while(tictac[0][0]!='_'&&display(n1,n2,'O')=='y') {
						n1=randomgenarator(n1,n2);
						n2=randomgenarator(n1,n2);
					}tictac[n1][n2]=O;
				}
			}else{
				if(tictac[0][0]=='_') {
					 tictac[0][0]=X;
					 if(display(0,0,X)=='y') {
						 tictac[0][0]=O;
					 }else {
						 tictac[0][0]='_';
					 }
				}else if(tictac[0][1]=='_') {
					tictac[0][1]=X;
					 if(display(0,1,X)=='y') {
						 tictac[0][1]=O;
					 }else {
						 tictac[0][1]='_';
					 }
				}else if(tictac[0][2]=='_') {
					tictac[0][2]=X;
					 if(display(0,2,X)=='y') {
						 tictac[0][2]=O;
					 }else {
						 tictac[0][2]='_';
					 }
				}else if(tictac[1][0]=='_') {
					tictac[1][0]=X;
					 if(display(1,0,X)=='y') {
						 tictac[1][0]=O;
					 }else {
						 tictac[1][0]='_';
					 }
				}else if(tictac[1][1]=='_') {
					tictac[1][1]=X;
					 if(display(1,1,X)=='y') {
						 tictac[1][1]=O;
					 }else {
						 tictac[1][1]='_';
					 }
				}else if(tictac[1][2]=='_') {
					tictac[1][2]=X;
					 if(display(1,2,X)=='y') {
						 tictac[1][2]=O;
					 }else {
						 tictac[1][2]='_';
					 }
				}else if(tictac[2][0]=='_') {
					tictac[2][0]=X;
					 if(display(2,0,X)=='y') {
						 tictac[2][0]=O;
					 }else {
						 tictac[2][0]='_';
					 }
				}else if(tictac[2][1]=='_') {
					tictac[2][1]=X;
					 if(display(2,1,X)=='y') {
						 tictac[2][1]=O;
					 }else {
						 tictac[2][1]='_';
					 }
				}else if(tictac[2][2]=='_'){
					tictac[2][2]=X;
					 if(display(2,2,X)=='y') {
						 tictac[2][2]=O;
					 }else {
						 tictac[2][2]='_';
					 }
				}else {
					int n1=0,n2=0;
					while(tictac[0][0]!='_'&&display(n1,n2,'O')=='y') {
						n1=randomgenarator(n1,n2);
						n2=randomgenarator(n1,n2);
					}tictac[n1][n2]=O;
				}
			}
		}
	
	*/
	
	
	

	public static void main(String[] arg) {
		Scanner sc=new Scanner(System.in);
		
		
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				tictac[i][j]='_';
			}
		}
		print();
		
		
	
		int count=0;
		while(count<9) {
			System.out.println("Enter the index: ");
			int n=sc.nextInt();
			///n=n-1;
			int m=sc.nextInt();
			///m=m-1;
			if((n<3 && m<3) && tictac[n][m]=='_') {
				tictac[n][m]='X';
				//print();
				count++;
				if(display(n,m,X)=='y') {
					System.out.println("you won!");
				return;	
				}
	//			oinput(n,m,count);
				if(display(0,0,O)=='y'||display(2,1,'O')=='y'||display(0,1,'O')=='y') {
					System.out.println("you loss! think more.");
					return;	
				}
				print();
				///oooo cde
				count++;			
				
			

			}else {
				System.out.println("wrong input ");
				continue;
			}
						
			
		}
		
		
		
	sc.close();
	}
	
	
}
