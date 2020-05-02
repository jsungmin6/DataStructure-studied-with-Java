public class PolynomialTest {
    public static void main(String[] args) {
        //���׽� A �����
        Polynomial A = new Polynomial();
        A.insertNode(4, 3);
        A.insertNode(3, 2);
        A.insertNode(5, 1);
        A.print();
 
        //���׽� B �����
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
 
        //A�� B �� �� �ϳ��� ��� �׿� ���� ������ ������ ��� while ����
        while(a!=null && b!=null){
            //B�� ������ A�� �������� ū ���
            if(a.expo<b.expo){
                C.insertNode(b.coef, b.expo);
                b = b.next;
            }
            //A�� ������ B�� �������� ū ���
            else if(a.expo>b.expo){
                C.insertNode(a.coef, a.expo);
                a = a.next;
            }
            //A�� ������ B�� ������ ���� ���
            else{
                C.insertNode(a.coef+b.coef, a.expo);
                a = a.next;
                b = b.next;
            }
        }    
        
        //A�� ���� ���� �ִ� ��� C�� �߰�
        while(a!=null){
            C.insertNode(a.coef, a.expo);
            a = a.next;
        }
        
        //B�� ���� ���� �մ� ��� B�� �߰�
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
            System.out.println("����� ��尡 �������� �ʽ��ϴ�.");
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

