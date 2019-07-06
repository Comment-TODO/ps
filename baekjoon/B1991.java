package baekjoon;

import java.io.*;

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.left = null;
		this.right = null;
		this.data = data;
	}
}

public class B1991 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		String tmp = br.readLine();
		int mid = tmp.charAt(0);
		int left = tmp.charAt(2);
		int right = tmp.charAt(4);
		Node root = new Node(mid);
		if ((char) left != '.') {
			root.left = new Node(left);
		}
		if ((char) right != '.') {
			root.right = new Node(right);
		}

		while (num-- > 1) {
			tmp = br.readLine();
			mid = tmp.charAt(0);
			left = tmp.charAt(2);
			right = tmp.charAt(4);

			Node chkNode = root;
			setNode(chkNode, left, mid, right);
		}

		preNode(root);
		System.out.println();
		midNode(root);
		System.out.println();
		postNode(root);
	}

	static void setNode(Node chkNode, int left, int mid, int right) {
		if (chkNode != null) {
			if (chkNode.left != null && chkNode.left.data == mid) {
				if ((char) left != '.')
					chkNode.left.left = new Node(left);
				if ((char) right != '.')
					chkNode.left.right = new Node(right);
				return;
			} else if (chkNode.right != null && chkNode.right.data == mid) {
				if ((char) left != '.')
					chkNode.right.left = new Node(left);
				if ((char) right != '.')
					chkNode.right.right = new Node(right);
				return;
			}
			if (chkNode.left != null)
				setNode(chkNode.left, left, mid, right);
			if (chkNode.right != null)
				setNode(chkNode.right, left, mid, right);
		}
	}

	static void preNode(Node node) {
		System.out.print((char) node.data);
		if (node.left != null)
			preNode(node.left);
		if (node.right != null)
			preNode(node.right);

	}

	static void midNode(Node node) {
		if (node.left != null)
			midNode(node.left);
		System.out.print((char) node.data);
		if (node.right != null)
			midNode(node.right);

	}

	static void postNode(Node node) {
		if (node.left != null)
			postNode(node.left);
		if (node.right != null)
			postNode(node.right);
		System.out.print((char) node.data);
	}
}