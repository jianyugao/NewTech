package com.ynwi.ssh.action;

public class RectangleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pointer p1 = new Pointer(0.0, 0.0);
		Pointer p2 = new Pointer(2.0, 0.0);
		Pointer p3 = new Pointer(1.0, 1.0);
		Pointer p4 = new Pointer(1.0, -1.0);
		Retangle retangle = new Retangle(p1, p3, p2, p4);
		boolean isR = retangle.isRectangle();
		System.out.println("the input is Rectangle " + isR);
		Pointer test = new Pointer(3.0, 0.0);
		System.out.println("the pointer is not contained " + retangle.isNotContained(test));
	}

}
