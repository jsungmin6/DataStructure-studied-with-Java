package w10;

import java.util.HashMap;

import java.util.Scanner;

import com.sun.javafx.collections.MappingChange.Map;

class StackNodeChar {
	char data;
	StackNodeChar link;
}

class LinkedStackChar {
	private StackNodeChar top;

	public boolean isEmpty() {
		return (top == null);
	}

	public void push(char item) {
		StackNodeChar newNode = new StackNodeChar();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}

	public char pop() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		} else {
			char item = top.data;
			top = top.link;
			return item;
		}
	}

	public void delete() {
		if (isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
		} else {
			top = top.link;
		}
	}

	public char peek() {
		if (isEmpty()) {
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		} else
			return top.data;
	}
	
	public int countNode() {
		int cnt = 0;

		StackNodeChar temp = top;
		while (temp != null) {
			cnt++;
			temp = temp.link;
		}
		return cnt;
	}

	public void printStackChar() {
		if (isEmpty())
			System.out.printf("Linked Stack is empty!! %n %n");
		else {
			StackNodeChar temp = top;
			System.out.println("\nLinked Stack>> ");
			while (temp != null) {
				System.out.printf("\t %c \n", temp.data);
				temp = temp.link;
			}
			System.out.println();
		}
	}
}
class OptExp{
	private String exp;
	private int expSize, postfixSize=0;
	private char testCh, openPair;
	
	public boolean testPair(String exp){
		
		this.exp = exp;
		LinkedStackChar S = new LinkedStackChar();
		expSize = this.exp.length();
		
		

		
		for(int i=0; i<expSize; i++){
			testCh = this.exp.charAt(i);
			switch(testCh){
				case '(' :
				case '{' :
				case '[' : 
					S.push(testCh); break;				
				case ')' :
				case '}' :
				case ']' : 
					if(S.isEmpty()) return false;
					else{
						openPair = S.pop();
						if((openPair == '(' && testCh != ')') ||
						   (openPair == '{' && testCh != '}') ||
						   (openPair == '[' && testCh != ']'))
						   return false;
					   else break;
					}
			}
		}
		if (S.isEmpty()) return true;
		else return false;
	}
	
	public char[] toPostfix(String infix){
		char testCh;		
		exp = infix;	
//		System.out.println("1. "+exp.length());
		int expSize = exp.length();
		int j=0;
		char postfix[] = new char[expSize];
		LinkedStackChar S = new LinkedStackChar();
//		System.out.println("2. "+expSize);
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('+', 2);
		hm.put('-', 2);
		hm.put('*', 3);
		hm.put('/', 3);
		hm.put('(', 1);
		
		for(int i=0; i<expSize; i++){
			testCh = this.exp.charAt(i);
//			System.out.println("3. "+i+" "+testCh);
			
			System.out.println(postfix);
			switch(testCh){
				case '+' :
				case '-' :
				case '*' :
				case '/' :
					if(S.isEmpty()) {
						S.push(testCh);
						break;
					}
					while(hm.get(S.peek())>=hm.get(testCh)) {
						postfix[j] = S.pop();
						j++;
						if(S.isEmpty()) {
							break;
						}
					}
					S.push(testCh);
					break;
				case '(':
					S.push(testCh);
					break;
				case ')' :
					while(S.peek()!='(') {
						postfix[j] = S.pop();
						j++;
					}
					S.pop();
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					postfix[j] = testCh;
					j++;
					break;

					
				default:
			}
		}
		
//		System.out.println(!S.isEmpty());

//			System.out.println(postfix);
		
		while(!S.isEmpty()) {
			postfix[j] = S.pop();
			j++;
		}

		postfixSize = j;
//		System.out.println(postfix);
		char [] postfix2 = new char[j];//인덱스번호 마지막이 포함이 안되므로 1을 더해주어야 한다.
		for(int i=0; i<postfixSize; i++) {
			postfix2[i]=postfix[i];			
		}
		System.out.println(postfix2);
		return postfix2;
	}	
}


class StackNode{
	int data;	
	StackNode link;
}

class LinkedStack{
	private StackNode top;
		
	public boolean isEmpty(){
		return (top == null);
	}
	
	public void push(int item){
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;		
	}
	
	public int pop(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			int item = top.data;
			top = top.link;
			return item;	
		}				
	}	
	public void printStack(){
	if(isEmpty())
		System.out.printf("Linked Stack is empty!! %n %n");
	else{
		StackNode temp = top;
		System.out.println("\nLinked Stack>> ");
		while(temp != null){
			System.out.printf("\t %d \n", temp.data);
			temp = temp.link;
		}
		System.out.println();	
	}
}

}

class OptExp2{	
	private String exp;
	
	public int evalPostfix(String postfix){		
		LinkedStack S = new LinkedStack();
		exp = postfix;
//		System.out.println("\n1. " +postfix.length()+", "+exp.length());
		int opr1, opr2, value;			
	    char testCh;
		for(int i=0; i<exp.length(); i++){		
			testCh = exp.charAt(i);
			if(testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/'){
				value = testCh - '0';
				S.push(value);
			}
			else{
				opr2 = S.pop();
				opr1 = S.pop();
				switch(testCh){
					case '+' :
						S.push(opr1 + opr2);
						break;
					case '-' : S.push(opr1 - opr2); break;
					case '*' : S.push(opr1 * opr2); break;
					case '/' : S.push(opr1 / opr2); break;
				}
			}
			S.printStack();
		}
		return S.pop();		
	}	
}






public class hw01 {
	public static void main(String args[]){
		OptExp opt = new OptExp();
		Scanner stdin = new Scanner(System.in);
		char answer;
		do {
		System.out.println("계산식을 입력해 주세요 : ");
		String exp;
		exp = stdin.next();
		char postfix[];
		int value;
		System.out.println(exp);
		if(opt.testPair(exp))
			System.out.println("괄호 맞음!");
		else 
			System.out.println("괄호 틀림!!!");			
						
		System.out.printf("\n후위표기식 : ");
		postfix = opt.toPostfix(exp);
		System.out.println(postfix);
		
	//--------------------------
		
		OptExp2 opt2 = new OptExp2();
		int result;
//		String exp2 = "35*62/-";	
		String exp2 = new String(postfix);	
		System.out.printf("\n2. 후위표기식 : %s", exp2);
		result = opt2.evalPostfix(exp2);
		System.out.printf("\n2. 연산결과 =  %d\n", result);	
		System.out.println("계속 하시겠습니까? (Y/N) : ");
		answer = stdin.next().charAt(0);
		}while(answer == 'Y');
		
		System.out.println("프로그램을 종료합니다.");
	}
}
