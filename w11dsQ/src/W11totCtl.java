import java.util.Scanner;

public class W11totCtl {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		W11totCtl w11r = new W11totCtl();
		int ans = 0;
		Ex8_3_modi aa = new Ex8_3_modi();
		Ex8_3 a = new Ex8_3();
		Ex8_4 b = new Ex8_4();
		
		while(ans != 99) {
			w11r.menuDisp();
			ans = in.nextInt();
			switch(ans) {
			case 11 : 
				aa.runBook();
				break;
			case 12 :
				aa.runMy(in);
				break;
			case 13:
				a.mainModi();
				break;
			case 21:
				b.main8_4();
				break;
			case 99: 
				System.out.println("����....");
				break;
			default:
				System.out.println("�߸��� ��ȣ�Դϴ�.");
			}
		}
	}
	public void menuDisp() {
		System.out.println("========= menu ==============");
		System.out.println(" 11. ���� ����Ʈ ť(����)");
		System.out.println(" 12. ���� ����Ʈ ť(�Է�)");
		System.out.println(" 13. ���� ����Ʈ ť(����) ���� ȣ��");
		System.out.println(" 21. ��");
		System.out.println(" 31. �迭 Ʈ��");
		System.out.println(" 99. ����");
		System.out.println("=============================");
		System.out.print(" ���� : ");
	}

}
