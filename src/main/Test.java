package main;

import java.util.Random;

public class Test {
//	定义存储字符串 临时存储式子
	@SuppressWarnings("unused")
	private String test;
//	定义式子前面的一个数和后面的一个数以及随机生成四则运算符的flag变量
	private int flag;
	private double firstnum,secondnum;
	Random random = new Random();
	/**
	 * @return secondnum
	 */
	public double getSecondnum() {
		return secondnum;
	}
	/**
	 * @return firstnum
	 */
	public double getFirstnum() {

		return firstnum;
	}
//创建加法题目的方法
	public String makeplus(){
		if (mainFrame.isdecimal) {
			int flag = random.nextInt(2);
			if (flag == 0) {
				firstnum = random.nextInt(100);
				secondnum = random.nextInt(100);		
				return test=(int)firstnum+"＋"+(int)secondnum+" = "+(int)(firstnum+secondnum);
			}
			else {
				firstnum = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
				secondnum = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
				return test=firstnum+"＋"+secondnum+" = "+String.format("%.2f", (firstnum+secondnum));
			}
		}
		else {
			firstnum = random.nextInt(100);
			secondnum = random.nextInt(100);		
			return test=(int)firstnum+"＋"+(int)secondnum+" = "+(int)(firstnum+secondnum);
		}		
	}
//	创建减法题目的方法
	public String makeminus(){
		if (mainFrame.isdecimal) {
			int flag = random.nextInt(2);
			if (flag == 0) {
				firstnum = random.nextInt(100);
				secondnum = random.nextInt(100);
				if (firstnum < secondnum) {
					double tmp;
					tmp = firstnum;
					firstnum = secondnum;
					secondnum = tmp;
				}
				return test = (int)firstnum+"－"+(int)secondnum+" = "+(int)(firstnum-secondnum);
			}
			else {
				firstnum = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
				secondnum = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
				if (firstnum < secondnum) {
					double tmp;
					tmp = firstnum;
					firstnum = secondnum;
					secondnum = tmp;
				}
				return test=firstnum+"－"+secondnum+" = "+String.format("%.2f", (firstnum-secondnum));
			}
		}
		else {
			firstnum = random.nextInt(100);
			secondnum = random.nextInt(100);
			if (firstnum < secondnum) {
				double tmp;
				tmp = firstnum;
				firstnum = secondnum;
				secondnum = tmp;
			}
			return test = (int)firstnum+"－"+(int)secondnum+" = "+(int)(firstnum-secondnum);
		}
	}
//	创建乘法题目的方法	
	public String maketime(){
		if (mainFrame.isdecimal) {
			int flag = random.nextInt(2);
			if (flag == 0) {
				firstnum = random.nextInt(100);
				secondnum = random.nextInt(100);
				return test = (int)firstnum+"×"+(int)secondnum+" = "+(int)(firstnum*secondnum);
			}
			else {
				firstnum = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
				secondnum = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
				return test=firstnum+"×"+secondnum+" = "+String.format("%.2f", (firstnum*secondnum));
			}
		}
		else {
			firstnum = random.nextInt(100);
			secondnum = random.nextInt(100);
			return test = (int)firstnum+"×"+(int)secondnum+" = "+(int)(firstnum*secondnum);
		}
		
	}
//	创建除法题目的方法！
	public String makedevide(){
		if (mainFrame.isdecimal) {
			int flag = random.nextInt(2);
			if (flag == 0) {
				firstnum = random.nextInt(99)+1;
				secondnum = random.nextInt(8)+2;
				return test = (int)firstnum+"÷"+(int)secondnum+" = "+String.format("%.2f", ((double)(firstnum)/(double)(secondnum)));
			}
			else {
				firstnum = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
				secondnum = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
				return firstnum+"÷"+secondnum+" = "+String.format("%.2f", (firstnum/secondnum));
			}
		}
		else {
			firstnum = random.nextInt(99)+1;
			secondnum = random.nextInt(8)+2;
			return test = (int)firstnum+"÷"+(int)secondnum+" = "+String.format("%.2f", ((double)(firstnum)/(double)(secondnum)));
		}
		
			
	}
//	创建题目的方法
	public String maketest(){
		flag = random.nextInt(4);
		if (flag == 0 /*&& mainFrame.plus*/) {
			return this.makeplus();
		}else if (flag == 1 /*&& mainFrame.minus*/) {
			return this.makeminus();
		} else if (flag == 2 /*&& mainFrame.time*/) {
			return this.maketime();
		}else if (flag == 3 /*&& mainFrame.devide*/) {
			return this.makedevide();
		}
		return this.maketest();
		
	}
//	这是用来测试生成题目的方法
	public static void main(String[] args){
/*		Test t = new Test();	
		String m = t.maketest();
		System.out.println();
		System.out.println(m.substring(0, (m.indexOf('=')+1)));*/
/*		Random random = new Random();
		double d = Double.parseDouble(String.format("%."+random.nextInt(3)+"f", random.nextDouble()*100));
		System.out.println( d);
		System.out.println(random.nextInt(2));*/
/*		Test t = new Test();
		mainFrame.isdecimal = true;
		System.out.println(t.maketest());*/


	}
	
}
