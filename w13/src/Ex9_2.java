import java.util.Scanner;

class TreeNode{
	char data;
	TreeNode left;
	TreeNode right;
}

class BinarySearchTree{
	private TreeNode root = new TreeNode();
	
	public TreeNode insertKey(TreeNode root, char x){
		TreeNode p = root;
		TreeNode newNode = new TreeNode();
		newNode.data = x;
		newNode.left = null;
		newNode.right = null;
		if(p == null)			
			return newNode;
		else if(newNode.data < p.data){
			p.left = insertKey(p.left, x);
			return p;
		}
		else if(newNode.data > p.data){
			p.right = insertKey(p.right, x);
			return p;
		}
		else return p;
	}
	
	public void insertBST(char x){
		root = insertKey(root, x);
	}
	
	public TreeNode searchBST(char x){
		TreeNode p = root;
		while(p != null){
			if(x < p.data)  p = p.left;
			else if (x > p.data) p = p.right;
			else return p;
		}
		return p;
	}
	
	public void inorder(TreeNode root){
		if(root != null){
			inorder(root.left);
			System.out.printf(" %c", root.data);			
			inorder(root.right);
		}
	}
	
	public int countNode(TreeNode root){
		int num;
		if(root == null){
			num=0;
		}
		else {
			num =countNode(root.left)+countNode(root.right)+1;
		}
		return num;
	}

	public void printBST(){
		inorder(root);
		System.out.println();
	}	
	
	public boolean deleteNode(char key) {
		// focusNode 와 parent 가 같을 수 있는 경우는 찾으려는 key 가 root 인 경우
		TreeNode focusNode = root;
		TreeNode parent = root;

		boolean isLeftChild = true;

		// while 문이 끝나고 나면 focusNode 는 삭제될 노드를 가리키고, parent 는 삭제될 노드의 부모노드를 가리키게 되고, 삭제될 노드가 부모노드의 left 인지 right 인지에 대한 정보를 가지게 된다
		while(focusNode.data != key) {
			parent = focusNode;

			if(key < focusNode.data) {
				isLeftChild = true;             // 지우려는 노드가 왼쪽에 있는 노드냐 기록용
				focusNode = parent.left;
			} else {
				isLeftChild = false;            // 지우려는 노드가 오른쪽에 있는 노드냐 기록용
				focusNode = parent.right;
			}

			// 찾으려는 노드가 없는 경우
			if(focusNode == null) {
				return false;
			}
		}


		TreeNode replacementNode;
		// 지우려는 노드의 자식 노드가 없는 경우
		if(focusNode.left == null && focusNode.right == null) {
			if (focusNode == root)
				root = null;
			else if (isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}
		// 지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
		else if(focusNode.right == null) {
			replacementNode = focusNode.left;

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;
		}
		// 지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있는 경우)
		else if (focusNode.left == null) {
			replacementNode = focusNode.right;
			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;
		}
		// 지우려는 노드의 양쪽 자식노드가 모두 있는 경우
		// 오른쪽 자식 노드의 sub tree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
		else {
			TreeNode rightSubTree = focusNode.right;                   // 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
			replacementNode = getRightMinNode(focusNode.right);    // 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree 에서 가장 작은 값을 가진 노드). 이 노드는 왼쪽 child 가 없어야 한다 (가장 작은 값이기 때문에)

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;

			replacementNode.right = rightSubTree;
			if (replacementNode == rightSubTree)                // 지우려는 노드의 오른쪽 sub tree 에 노드가 하나밖에 없는 경우
				replacementNode.right = null;

			replacementNode.left = focusNode.left;    // 지우려는 노드의 왼쪽 sub tree 를 연결시킨다
		}

		return true;
	}

	private TreeNode getRightMinNode(TreeNode rightChildRoot) {
		TreeNode parent = rightChildRoot;
		TreeNode focusNode = rightChildRoot;

		while (focusNode.left != null) {
			parent = focusNode;
			focusNode = focusNode.left;
		}

		parent.left = null;
		return focusNode;
	}

	public void inOrderTraverse(TreeNode focusNode) {
		if (focusNode != null) {
			inOrderTraverse(focusNode.left);
			System.out.print(focusNode.data + " ");
			inOrderTraverse(focusNode.right);
		}
	}

	public void preOrderTraverse(TreeNode focusNode) {
		if (focusNode != null) {
			System.out.print(focusNode.data + " ");
			preOrderTraverse(focusNode.left);
			preOrderTraverse(focusNode.right);
		}
	}

	public void postOrderTraverse(TreeNode focusNode) {
		if (focusNode != null) {
			postOrderTraverse(focusNode.left);
			postOrderTraverse(focusNode.right);
			System.out.print(focusNode.data + " ");
		}
	}

	public TreeNode findNode(char key) {
		// 트리가 비었을 때
		if (root == null) return null;

		TreeNode focusNode = root;

		while (focusNode.data != key) {
			if (key < focusNode.data) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}

			// 찾으려는 노드가 없을 때
			if (focusNode == null)
				return null;
		}

		return focusNode;
	}
	
	public TreeNode getRoot() {
        return this.root;
    }
	
}

class Ex9_2{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		char insertedItem;
		char deletedItem;
		char searchItem;
		BinarySearchTree bsT = new BinarySearchTree();
		
		int sel = 0;
		while (sel != 9) {
			System.out.println("==== 큐 메뉴 ====");
			System.out.println(" 1. 노드 입력(키 값 입력)");
			System.out.println(" 2. 키 값 검색");
			System.out.println(" 3. 노드 삭제(키 값 입력)");
			System.out.println(" 4. 트리 내 모든 값 출력");
			System.out.println(" 5. 노드 개수 출력");
			System.out.println(" 9. 종료");
			System.out.println("==============");
			System.out.print(" 선택 : ");
			sel = in.nextInt();
			switch (sel) {
			case 1:
				System.out.print("입력하려는 키는? ");
				insertedItem = in.next().charAt(0);
				bsT.insertBST(insertedItem);
				bsT.printBST();
		        System.out.println();
				break;
			case 2:
				searchItem = in.next().charAt(0);
				TreeNode p1 = bsT.searchBST(searchItem);
				if(p1 != null)
					System.out.printf("Searching Success! Searched key : %c \n", searchItem);
				else
					System.out.printf("Searching fail!! There is no %c \n", searchItem);
				break;
			case 3:
				deletedItem = in.next().charAt(0);
				bsT.deleteNode(deletedItem);
		        System.out.println();
				break;
			case 4:
				bsT.printBST();
		        System.out.println();
				break;
			case 5:
				int result=bsT.countNode(bsT.getRoot());
		        System.out.println(result-1);
		        System.out.println();
				break;
			case 9:
				break;
			default:
				System.out.println("잘못된 번호입니다.");

			}
		}
		/*
		bsT.insertBST('G');
		bsT.insertBST('I');
		bsT.insertBST('H');
		bsT.insertBST('D');
		bsT.insertBST('B');
		bsT.insertBST('M');
		bsT.insertBST('N');
		bsT.insertBST('A');
		bsT.insertBST('J');
		bsT.insertBST('E');
		bsT.insertBST('Q');
		*/
	}
}