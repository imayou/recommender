package com.ifa.recommender.domain;

public class Rating {
	private int yw;//意外 
	private int jc;//家财 
	private int cf;//车服 
	private int zj;//重疾 
	private int zr;//责任 
	
	public void ywAdd(){
		this.yw++;
	}
	public void jcAdd(){
		this.jc++;
	}
	public void cfAdd(){
		this.cf++;
	}
	public void zjAdd(){
		this.zj++;
	}
	public void zrAdd(){
		this.zr++;
	}
	public void ywReduce() {
		this.yw--;
	}
	public void jcReduce() {
		this.jc--;
	}
	public void cfReduce() {
		this.cf--;
	}
	public void zjReduce() {
		this.zj--;
	}
	public void zrReduce() {
		this.zr--;
	}
	
	public int getYw() {
		return yw;
	}
	public void setYw(int yw) {
		this.yw = yw;
	}
	public int getJc() {
		return jc;
	}
	public void setJc(int jc) {
		this.jc = jc;
	}
	public int getCf() {
		return cf;
	}
	public void setCf(int cf) {
		this.cf = cf;
	}
	public int getZj() {
		return zj;
	}
	public void setZj(int zj) {
		this.zj = zj;
	}
	public int getZr() {
		return zr;
	}
	public void setZr(int zr) {
		this.zr = zr;
	}
}
