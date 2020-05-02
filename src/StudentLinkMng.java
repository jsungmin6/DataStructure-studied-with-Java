public class PolynomialTest {
    public static void main(String[] args) {
        //다항식 A 만들기
        Polynomial A = new Polynomial();
        A.insertNode(4, 3);
        A.insertNode(3, 2);
        A.insertNode(5, 1);
        A.print();
 
        //다항식 B 만들기
        Polynomial B = new Polynomial();
        B.insertNode(3, 4);
        B.insertNode(1, 3);
        B.insertNode(2, 1);
        B.insertNode(1, 0);
        B.print();
 
        Polynomial C = AddPolynomial(A, B);
        C.print();
    }
 
    static Polynomial AddPolynomial(Polynomial A, Polynomial B){
        ListNode a = A.head;
        ListNode b = B.head;
        Polynomial C = new Polynomial();
 
        //A나 B 둘 중 하나가 모든 항에 대해 덧셈이 끝나는 경우 while 종료
        while(a!=null && b!=null){
            //B의 지수가 A의 지수보다 큰 경우
            if(a.expo<b.expo){
                C.insertNode(b.coef, b.expo);
                b = b.next;
            }
            //A의 지수가 B의 지수보다 큰 경우
            else if(a.expo>b.expo){
                C.insertNode(a.coef, a.expo);
                a = a.next;
            }
            //A의 지수와 B의 지수가 같은 경우
            else{
                C.insertNode(a.coef+b.coef, a.expo);
                a = a.next;
                b = b.next;
            }
        }    
        
        //A에 항이 남아 있는 경우 C에 추가
        while(a!=null){
            C.insertNode(a.coef, a.expo);
            a = a.next;
        }
        
        //B에 항이 남아 잇는 경우 B에 추가
        while(b!=null){
            C.insertNode(b.coef, b.expo);
            b = b.next;
        }
        
        return C;
    }
}




public class ListNode {
    int coef;
    int expo;
    ListNode next;
    
    public ListNode() {
        next = null;
    }
    
    public ListNode(int coef, int expo){
        this.coef = coef;
        this.expo = expo;
        this.next = null;
    }
    
    public ListNode(int coef, int expo, ListNode next){
        this.coef = coef;
        this.expo = expo;
        this.next = next;
    }
    
    public int getCoef() {
        return this.coef;
    }
    
    public int getExpo() {
        return this.expo;
    }
}

public class Polynomial {
    ListNode head;
    
    public Polynomial() {
        head = null;
    }
    
    public void insertNode(int coef, int expo){
        ListNode node = new ListNode(coef, expo);
        if(head==null){
            head = node;
        }else{
            ListNode current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = node;
        }
    }
    
    public void print(){
        if(head==null){
            System.out.println("출력할 노드가 존재하지 않습니다.");
        }else{
            ListNode current = head;
            while(current.next!=null){
                System.out.print(current.coef + "X^" + current.expo + " + ");
                current = current.next;
            }
            System.out.print(current.coef + "X^" + current.expo);
            System.out.println();
        }
    }
}

