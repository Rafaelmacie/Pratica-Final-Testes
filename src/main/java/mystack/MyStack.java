package mystack;

public class MyStack {
	private Node first = null;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String s) {
		if (s == null || s.trim().isEmpty()) {
			throw new IllegalArgumentException("O item não pode ser nulo ou vazio.");
		}

		Node p = new Node();

		p.item = s;

		p.next = first;

		first = p;
	}

	public String pop() {
		if (isEmpty()) {
			return "Pilha vazia.";
		}

		String s = first.item;

		first = first.next;

		return s;
	}

	public String peek() {
		if (isEmpty()) {
			return "Pilha vazia.";
		}

		return first.item;
	}

	public void print() {
		Node p;

		for (p = first; p != null; p = p.next)
			System.out.printf("%s -> ", p.item);
		System.out.printf("null.\n");
	}
}