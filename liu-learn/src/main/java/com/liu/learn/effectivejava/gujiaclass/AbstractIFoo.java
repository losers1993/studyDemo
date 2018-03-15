package com.liu.learn.effectivejava.gujiaclass;

public abstract class AbstractIFoo implements IFoo{
	
	private String val;
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@Override
	public void foo() {
		System.out.println("骨架类实现foo");
	}
	
}
