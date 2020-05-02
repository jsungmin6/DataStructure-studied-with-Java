public class PolynomialTest {
	public static void main(String[] args) {
		Polynomial A = new Polynomial();
		A.appendTerm(A, 4, 3, A.last);
		A.appendTerm(A, 3, 2, A.last);
		A.appendTerm(A, 5, 1, A.last);
		A.print();

		Polynomial B = new Polynomial();
		B.appendTerm(B, 3, 4, B.last);
		B.appendTerm(B, 1, 3, B.last);
		B.appendTerm(B, 2, 1, B.last);
		B.appendTerm(B, 1, 0, B.last);
		B.print();
		
		OperatePoly optPoly = new OperatePoly();

		Polynomial C = optPoly.AddPoly(A, B);
		C.print();
	}
}
class OperatePoly{
	public Polynomial AddPoly(Polynomial A, Polynomial B){
		Node p = A.head;
		Node q = B.head;
		Polynomial C = new Polynomial();

		while(p!=null && q!=null){
			if(p.expo<q.expo){
				C.appendTerm(C,q.coef, q.expo,C.last);
				q = q.link;
			}
			else if(p.expo>q.expo){
				C.appendTerm(C,p.coef, p.expo,C.last);
				p = p.link;
			}
			else{
				int sum = p.coef+q.coef;
				if(sum!=0)
				{
					C.appendTerm(C,sum, p.expo,C.last);
				}
				p = p.link;
				q = q.link;
			}
		}    

		while(p!=null){
			C.appendTerm(C,p.coef, p.expo,C.last);
			p = p.link;
		}

		while(q!=null){
			C.appendTerm(C,q.coef, q.expo,C.last);
			q = q.link;
		}

		return C;
	}
}


class Node {
	int coef;
	int expo;
	Node link;

	public Node() {
		link = null;
	}

	public Node(int coef, int expo){
		this.coef = coef;
		this.expo = expo;
		this.link = null;
	}

	public Node(int coef, int expo, Node link){
		this.coef = coef;
		this.expo = expo;
		this.link = link;
	}

	public int getCoef() {
		return this.coef;
	}

	public int getExpo() {
		return this.expo;
	}
}

class Polynomial {
	Node head;
	Node last;

	public Polynomial() {
		head = null;
		last = null;
	}

	public void appendTerm(Polynomial PL,int coef, int expo, Node r){
		Node newNode = new Node(coef, expo);
		last = r;

		if(PL.head==null){
			head = newNode;
			last = newNode;
		}else{
			last.link= newNode;
			last = newNode;
		}
	}

	public void print(){
		if(head==null){
			System.out.println("출력할 노드가 존재하지 않습니다.");
		}else{
			Node current = head;
			while(current.link!=null){
				System.out.print(current.coef + "X^" + current.expo + " + ");
				current = current.link;
			}
			System.out.print(current.coef + "X^" + current.expo);
			System.out.println();
		}
	}
}

