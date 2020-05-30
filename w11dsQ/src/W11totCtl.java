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
				System.out.println("종료....");
				break;
			default:
				System.out.println("잘못된 번호입니다.");
			}
		}
	}
	public void menuDisp() {
		System.out.println("========= menu ==============");
		System.out.println(" 11. 연결 리스트 큐(교재)");
		System.out.println(" 12. 연결 리스트 큐(입력)");
		System.out.println(" 13. 연결 리스트 큐(교재) 직접 호출");
		System.out.println(" 21. 덱");
		System.out.println(" 31. 배열 트리");
		System.out.println(" 99. 종료");
		System.out.println("=============================");
		System.out.print(" 선택 : ");
	}

}
