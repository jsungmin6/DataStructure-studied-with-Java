import java.util.Scanner;
class QNode{
	String data;
	QNode link;
}

class LinkedQueue{
	QNode front;
	QNode rear;
		
	public LinkedQueue(){
		front = null;
		rear = null;		
	}
	
	public boolean isEmpty(){
		return (front == null);
	}
	
	public void enQueue(String item){
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		if(isEmpty()){
			front = newNode;
			rear = newNode;
		}
		else {
			rear.link = newNode;
			rear = newNode;			
		}
		System.out.println("Inserted Item : " + item);
	}
	
	public String deQueue(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Queue is empty!!");
			return "0";
		}
		else{ 
			String item = front.data;
			front = front.link;
			if(front == null)
				rear = null;
			return item;
		}				
	}
	
	public void delete(){
		if(isEmpty()){
			System.out.println("Deleting fail! Linked Queue is empty!!");			
		}
		else {
			front = front.link;
			if(front == null)
				rear = null;
		}
	}
	
	public String peek(){
		if(isEmpty()){
			System.out.println("Peeking fail! Linked Queue is empty!!");
			return "0";
		}
		else 
			return front.data;		
	}
	
	public void printQueue(){
		if(isEmpty())
			System.out.printf("Linked Queue is empty!! %n %n");
		else{
			QNode temp = front;
			System.out.printf("Linked Queue>> ");
			while(temp != null){
				System.out.printf("%s ", temp.data);
				temp = temp.link;
			}
			System.out.println();System.out.println();
		}
	

	}
	
	public void print4Queue(){
		if(isEmpty())
			System.out.printf("Linked Queue is empty!! %n %n");
		else{
			QNode temp = front;
			int count = 1;
			System.out.printf("Linked 4의배수 Queue>> ");
			while(temp != null){
				if(count%4==0) {
					System.out.printf("%s ", temp.data);	
				}
				count+=1;
				temp = temp.link;
				
			}
			System.out.println();System.out.println();
		}
	

	}
}

class Ex8_3{
	public void mainModi(){		
		String deletedItem;
		LinkedQueue LQ = new LinkedQueue();
		
		LQ.enQueue("A");
		LQ.printQueue();
		
		LQ.enQueue("B");
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem != "0")
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();
		
		LQ.enQueue("C");
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem != "0")
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();

		deletedItem = LQ.deQueue();
		if(deletedItem != "0")
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();		
		
		deletedItem = LQ.deQueue();
		if(deletedItem != "0")
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();	
	}
}
public class Ex8_3_modi {
	public void runBook() {
		Ex8_3 a1 = new Ex8_3();
		a1.mainModi();
	}

	public void runMy(Scanner in) {
		String insertedItem;
		String deletedItem;
		LinkedQueue LQ = new LinkedQueue();

		int sel = 0;
		while (sel != 9) {
			System.out.println("==== 큐 메뉴 ====");
			System.out.println(" 1. 삽입");
			System.out.println(" 2. 삭제");
			System.out.println(" 3. 출력");
			System.out.println(" 4. 4의 배수 데이터 출력");
			System.out.println(" 9. 종료");
			System.out.println("==============");
			System.out.print(" 선택 : ");
			sel = in.nextInt();
			switch (sel) {
			case 1:
				System.out.print("입력하려는 값은? ");
				insertedItem = in.next();
				LQ.enQueue(insertedItem);
				break;
			case 2:
				deletedItem = LQ.deQueue();
				if (deletedItem != "0")
					System.out.println("deleted Item : " + deletedItem);
				break;
			case 3:
				LQ.printQueue();
				break;
			case 4:
				LQ.print4Queue();
				break;
			case 9:
				break;
			default:
				System.out.println("잘못된 번호입니다.");

			}
		}
	}
}
