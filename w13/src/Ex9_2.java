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
		// focusNode �� parent �� ���� �� �ִ� ���� ã������ key �� root �� ���
		TreeNode focusNode = root;
		TreeNode parent = root;

		boolean isLeftChild = true;

		// while ���� ������ ���� focusNode �� ������ ��带 ����Ű��, parent �� ������ ����� �θ��带 ����Ű�� �ǰ�, ������ ��尡 �θ����� left ���� right ������ ���� ������ ������ �ȴ�
		while(focusNode.data != key) {
			parent = focusNode;

			if(key < focusNode.data) {
				isLeftChild = true;             // ������� ��尡 ���ʿ� �ִ� ���� ��Ͽ�
				focusNode = parent.left;
			} else {
				isLeftChild = false;            // ������� ��尡 �����ʿ� �ִ� ���� ��Ͽ�
				focusNode = parent.right;
			}

			// ã������ ��尡 ���� ���
			if(focusNode == null) {
				return false;
			}
		}


		TreeNode replacementNode;
		// ������� ����� �ڽ� ��尡 ���� ���
		if(focusNode.left == null && focusNode.right == null) {
			if (focusNode == root)
				root = null;
			else if (isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}
		// ������� ����� ������ �ڽĳ�尡 ���� ��� (���� �ڽ� ��常 �ִ� ���)
		else if(focusNode.right == null) {
			replacementNode = focusNode.left;

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;
		}
		// ������� ����� ���� �ڽĳ�尡 ���� ��� (������ �ڽ� ��常 �ִ� ���)
		else if (focusNode.left == null) {
			replacementNode = focusNode.right;
			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;
		}
		// ������� ����� ���� �ڽĳ�尡 ��� �ִ� ���
		// ������ �ڽ� ����� sub tree ���� ���� ���� ��带 ã�Ƽ� ������� ��尡 �ִ� �ڸ��� ��ġ��Ų��
		else {
			TreeNode rightSubTree = focusNode.right;                   // ������ ����� ������ sub tree �� �����صд�
			replacementNode = getRightMinNode(focusNode.right);    // ������ ��� �ڸ��� ���� �� ���ο� ��� (������ sub tree ���� ���� ���� ���� ���� ���). �� ���� ���� child �� ����� �Ѵ� (���� ���� ���̱� ������)

			if (focusNode == root)
				root = replacementNode;
			else if (isLeftChild)
				parent.left = replacementNode;
			else
				parent.right = replacementNode;

			replacementNode.right = rightSubTree;
			if (replacementNode == rightSubTree)                // ������� ����� ������ sub tree �� ��尡 �ϳ��ۿ� ���� ���
				replacementNode.right = null;

			replacementNode.left = focusNode.left;    // ������� ����� ���� sub tree �� �����Ų��
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
		// Ʈ���� ����� ��
		if (root == null) return null;

		TreeNode focusNode = root;

		while (focusNode.data != key) {
			if (key < focusNode.data) {
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}

			// ã������ ��尡 ���� ��
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
			System.out.println("==== ť �޴� ====");
			System.out.println(" 1. ��� �Է�(Ű �� �Է�)");
			System.out.println(" 2. Ű �� �˻�");
			System.out.println(" 3. ��� ����(Ű �� �Է�)");
			System.out.println(" 4. Ʈ�� �� ��� �� ���");
			System.out.println(" 5. ��� ���� ���");
			System.out.println(" 9. ����");
			System.out.println("==============");
			System.out.print(" ���� : ");
			sel = in.nextInt();
			switch (sel) {
			case 1:
				System.out.print("�Է��Ϸ��� Ű��? ");
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
				System.out.println("�߸��� ��ȣ�Դϴ�.");

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