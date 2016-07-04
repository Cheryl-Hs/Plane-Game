package plane;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

/**
 * 爆炸
 * @author Administrator
 *
 */
public class Explode {
	double x, y;
	static Image[] imgs = new Image[16];
	int count;
	static {
		for(int i = 0;i<16;i++){
			imgs[i] = GameUtil.getImage("images/explode/e" + (i+1) + ".gif");
			imgs[i].getWidth(null);//一调用此方法就直接把图片加载进来
		}
	}
	
	public void draw(Graphics g) {
		if (count<=15) {
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
		
	}

	
}
