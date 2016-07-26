package com.ynwi.ssh.action;

import javax.crypto.interfaces.PBEKey;


public class Retangle {
	private Pointer leftUp;
	private Pointer leftDown;
	private Pointer rightUp;
	private Pointer rightDown;
	
	private Pointer fromPointer;
	private Pointer next1Pointer;
	private Pointer next2Pointer;
	private Pointer opPointer;
	public static final double ACCURACY = 0.001;
	public Retangle(Pointer leftUp, Pointer leftDown, Pointer rightUp, Pointer rightDown) {
		super();
		this.leftUp = leftUp;
		this.leftDown = leftDown;
		this.rightUp = rightUp;
		this.rightDown = rightDown;
	}
	
	/**
	 * see if these four points can construct a rectangle
	 * 1. if the middle point is overlapped
	 * 2. there is a right angle in it
	 */
	private void setFourPointer(Pointer fromPointer, Pointer next1Pointer, Pointer next2Pointer, Pointer opPointer){
		this.fromPointer = fromPointer;
		this.next1Pointer = next1Pointer;
		this.next2Pointer = next2Pointer;
		this.opPointer = opPointer;
	}
	
	public boolean isRectangle(){
		if(leftUp == null || leftDown == null || rightUp == null || rightDown == null){
			System.out.println("the rectangel has not correctly initialized");
			return false;
		}
		
		if(calMid(leftUp, leftDown).compareTo(calMid(rightUp, rightDown)) == 0){
			if(isRightAngle(leftUp, rightDown, rightUp)){
				System.out.println("case1");
				setFourPointer(leftUp, rightDown, rightUp, leftDown);
				return true;
			}
		}
		
		if(calMid(leftUp, rightDown).compareTo(calMid(rightUp, leftDown)) == 0){
			if(isRightAngle(leftUp, leftDown, rightUp)){
				System.out.println("case2");
				setFourPointer(leftUp, leftDown, rightUp, rightDown);
				return true;
			}
		}
		
		if(calMid(leftUp, rightUp).compareTo(calMid(leftDown, rightDown)) == 0){
			if(isRightAngle(leftUp, leftDown, rightDown)){
				System.out.println("case3");
				setFourPointer(leftUp, leftDown, rightDown, rightUp);
				return true;
			}
		}
		
		return false;
	}
	
	private Pointer calMid(Pointer pA, Pointer pB){
		return new Pointer((pA.getX() + pB.getX()) / 2,(pB.getY() + pA.getY())/2);
	}
	
	
	public boolean isNotContained(Pointer p){
		boolean res = true;
		double fn1 = p.pToLineDist(this.fromPointer, this.next1Pointer);
		double on2 = p.pToLineDist(this.next2Pointer, this.opPointer);
		double len = this.fromPointer.pTopDist(next2Pointer);
		if(Math.abs(len-fn1-on2)>ACCURACY){
			System.out.println("false1");
			res = false;
		}
		double fn2 = p.pToLineDist(this.fromPointer, this.next2Pointer);
		double on1 = p.pToLineDist(this.next1Pointer, this.opPointer);
		double wid = this.fromPointer.pTopDist(next1Pointer);
		if(Math.abs(wid-fn2-on1)>ACCURACY){
			System.out.println("false2");
			res = false;
		}
		
		return !res;
	}
	private boolean isRightAngle(Pointer from, Pointer po, Pointer pt){
		if(po.getX() - from.getX() <= ACCURACY){
			if(pt.getY() - from.getY() <= ACCURACY){
				System.out.println("po case");
				return true;
			}
		}
		
		if(pt.getX() - from.getX() <= ACCURACY){
			if(po.getY() - from.getY() <= ACCURACY){
				System.out.println("pt case");
				return true;
			}
		}
		
		double mul = (pt.getY() - from.getY())/(pt.getX() - from.getX()) *
				(po.getY() - from.getY() / (po.getX() - from.getX()));
		System.out.println("the pt rate is " + (pt.getY() - from.getY())/(pt.getX() - from.getX()) );
		System.out.println("the po rate is " + (po.getY() - from.getY())/(po.getX() - from.getX()) );
		System.out.println("the nul rate is " + mul);
		if(Math.abs(Math.abs(mul) - 1)< ACCURACY){
			System.out.println("mul abs value "+Math.abs(mul));
			return true;
		}
		
		return false;
	}
	
}
