package com.liu.learn.effectivejava.gujiaclass;

public class GuiJiaClassTest {

	public static void main(String[] args) {
		FooBar fooBar = new FooBar();
		fooBar.setVal("liu");
		System.out.println(fooBar.getVal());
		fooBar.foo();
	}

}
