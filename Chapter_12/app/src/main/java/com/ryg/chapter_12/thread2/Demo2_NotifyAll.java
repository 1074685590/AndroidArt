package com.ryg.chapter_12.thread2;

public class Demo2_NotifyAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Printer2 p = new Printer2();
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print1();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print2();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print3();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
/*1,��ͬ���������,���ĸ�������,�����ĸ��������wait����
 * 2,Ϊʲôwait������notify����������Object������?
 * 	��Ϊ������������������,Object�����е���Ļ���,����wait������notify������Ҫ������Object�������
 * 3,sleep������wait����������?
 * a,sleep�������봫�����,��������ʱ��,ʱ�䵽���Զ�����
 *   wait�������Դ������Ҳ���Բ��������,������������ڲ�����ʱ�������ȴ�,�������������ֱ�ӵȴ�
 * b,sleep������ͬ��������ͬ���������,���ͷ���,˯����Ҳ������˯
 * 	wait������ͬ����������ͬ���������,�ͷ���
 */ 
class Printer2 {
	private int flag = 1;
	public void print1() throws InterruptedException {							
		synchronized(this) {
			while(flag != 1) {
				this.wait();					//��ǰ�̵߳ȴ�
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("Ա");
			System.out.print("\r\n");
			flag = 2;
			//this.notify();						//������ѵ����ȴ����߳�
			this.notifyAll();
		}
	}
	
	public void print2() throws InterruptedException {
		synchronized(this) {
			while(flag != 2) {
				this.wait();					//�߳�2�ڴ˵ȴ�
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("\r\n");
			flag = 3;
			//this.notify();
			this.notifyAll();
		}
	}
	
	public void print3() throws InterruptedException {
		synchronized(this) {
			while(flag != 3) {
				this.wait();						//�߳�3�ڴ˵ȴ�,if�����������ȴ�,������������
													//whileѭ����ѭ���ж�,ÿ�ζ����жϱ��
			}
			System.out.print("i");
			System.out.print("t");
			System.out.print("h");
			System.out.print("e");
			System.out.print("i");
			System.out.print("m");
			System.out.print("a");
			System.out.print("\r\n");
			flag = 1;
			//this.notify();
			this.notifyAll();
		}
	}
}

