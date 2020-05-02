import java.util.Scanner;

public class StudentLinkMng {
	public static void main(String args[]){
		Scanner stdin = new Scanner(System.in);
		StudentLinkedList L = new StudentLinkedList();
		char Choice='0';
		String strSTNO="";
		String strSTNAME="";
		String strSTDEPT="";
		int intSTAGE=0;
		String strSTCITY="";
		
		while(true)
		{
		System.out.println("=========== menu =========\r\n" + 
				"1. 학생 데이터 입력\r\n" + 
				"2. 학생 데이터 출력\r\n" + 
				"3. 학생 명수 출력\r\n" + 
				"4. 현재 노드 개수 출력\r\n" + 
				"==========================\r\n" + 
				"번호 선택 : ");
		
		Choice = stdin.next().charAt(0);
		
		switch(Choice) {
			case '1':
				System.out.printf("%s","학번 입력 : ");
				strSTNO = stdin.next();
				System.out.printf("%s","이름 입력 : ");
				strSTNAME = stdin.next();
				System.out.printf("%s","부서 입력 : ");
				strSTDEPT = stdin.next();
				System.out.printf("%s","나이 입력 : ");
				intSTAGE = stdin.nextInt();
				System.out.printf("%s","거주지 입력 : ");
				strSTCITY = stdin.next();
				L.insertLastNode(strSTNO,strSTNAME,strSTDEPT,intSTAGE,strSTCITY);
				break;
			case '2':
				L.printList();
				break;
			case '3':
				L.printStudentNum();
				break;
			case '4':
				L.printStudenNodeNum();
				break;
			default:
				System.out.println("잘못된 입력값입니다. 다시 입력 하세요");
		}
		}
	}
}


class StudentDataNode{
	public String STNO;
	public String STNAME;
	public String STDEPT;
	public int STAGE;
	public String STCITY;
	public StudentDataNode link;
	
	public StudentDataNode() {
		this.STNO = null;
		this.STNAME = null;
		this.STDEPT = null;
		this.STAGE = 0;
		this.STCITY = null;
		this.link = null;
	}
	
	public StudentDataNode(String STNO,String STNAME,String STDEPT,int STAGE,String STCITY){
		this.STNO = STNO;
		this.STNAME = STNAME;
		this.STDEPT = STDEPT;
		this.STAGE = STAGE;
		this.STCITY = STCITY;
		this.link = null;
	}
	
	public StudentDataNode(String STNO,String STNAME,String STDEPT,int STAGE,String STCITY,StudentDataNode link){
		this.STNO = STNO;
		this.STNAME = STNAME;
		this.STDEPT = STDEPT;
		this.STAGE = STAGE;
		this.STCITY = STCITY;
		this.link = link;
	}
	public String getSTNO(){
		return this.STNO ;
	}
	public String getSTNAME(){
		return this.STNAME ;
	}
	public String getSTDEPT(){
		return this.STDEPT ;
	}
	public int getSTAGE(){
		return this.STAGE ;
	}
	public String getSTCITY(){
		return this.STCITY ;
	}
}

class StudentLinkedList{
	private StudentDataNode head;
	public StudentLinkedList(){
		head = null;
	}
	public void insertLastNode(String STNO,String STNAME,String STDEPT,int STAGE,String STCITY){
		StudentDataNode newNode = new StudentDataNode(STNO,STNAME,STDEPT,STAGE,STCITY);
		if(head == null){
			this.head = newNode;
		}
		else{
			StudentDataNode temp = head;
			while(temp.link != null) temp = temp.link;
			temp.link = newNode;
		}
	}
	public void printList(){
		StudentDataNode temp = this.head;
		System.out.printf("%s\t%s\t%s\t%s\t%s\n","STNO","STNAME","STDEPT","STAGE","STCITY");
		while(temp != null){
			System.out.printf("%s\t",temp.getSTNO());
			System.out.printf("%s\t",temp.getSTNAME());
			System.out.printf("%s\t",temp.getSTDEPT());
			System.out.printf("%d\t",temp.getSTAGE());
			System.out.printf(temp.getSTCITY());
			temp = temp.link;
			if(temp != null){
				System.out.printf("\n");
		
			}			
		}
		System.out.printf("\n");
	}
	
	public void printStudentNum(){
		StudentDataNode temp = this.head;
		int StudentNum=1;
		while(temp != null){
			StudentNum+=1;
			temp = temp.link;
			if(temp != null){
				System.out.printf("학생의 수 : %d",StudentNum);
				System.out.printf("\n");
			}			
		}
		if(StudentNum == 1)
		{
			System.out.printf("학생의 수 : %d",1);
		}
		System.out.printf("\n");
	}
	
	public void printStudenNodeNum(){
		StudentDataNode temp = this.head;
		int StudentNodeNum=1;

		while(temp != null){
			StudentNodeNum+=1;
			temp = temp.link;
			if(temp != null){
				System.out.printf("노드의 수 : %d",StudentNodeNum);
				
			}			
		}
		if(StudentNodeNum == 1)
		{
			System.out.printf("노드의 수 : %d",1);
		}
		System.out.printf("\n");
	}
}

