package com.ynwi.ssh.action;

public class Pointer implements Comparable<Pointer>{
	private double x;
	private double y;
	public Pointer(double x, Double y){
		this.setX(x);
		this.setY(y);
	}
	
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}
	public double pTopDist(Pointer p){
		double res;
		res = Math.sqrt(Math.pow(this.getX()-p.getX(), 2)+Math.pow(this.getY()-p.getY(), 2));
		return res;
	}
	public double pToLineDist(Pointer A, Pointer B) {
	    double normalLength = Math.sqrt((B.getX()-A.getX())*(B.getX()-A.getX())+(B.getY()-A.getY())*(B.getY()-A.getY()));
	    return Math.abs((this.getX()-A.getX())*(B.getY()-A.getY())-(this.getY()-A.getY())*(B.getX()-A.getX()))/normalLength;
	  }
	@Override
	public int compareTo(Pointer o) {
		// TODO Auto-generated method stub
		double accuracy = 0.001;
		if((Math.abs(this.getX() - o.getX()) < Constant.ACCURACY ) 
				&& (Math.abs(this.getY() - o.getY()) < Constant.ACCURACY)){
			return 0;
		}
		return 1;
	}
}
