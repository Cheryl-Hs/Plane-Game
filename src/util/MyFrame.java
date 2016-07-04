package util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {
	
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);     //设置窗口大小
		setLocation(100, 100);  //设置窗口位置
		setVisible(true);       //设置窗口可视化
		
		new PaintThread().start();  //启动重画线程
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
	//双缓冲，让界面不闪，如果是swing，则不需要此段代码，swing自动处理此问题
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();

		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	
	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类，方便外部类直接访问
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread {
		
		public void run() {
			while(true) {
				repaint();  //重画窗口
				try {
					Thread.sleep(40);    //休息一会，  40ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   
			}
		}
	}
}
