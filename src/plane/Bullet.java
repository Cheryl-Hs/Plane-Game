package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import util.Constant;

public class Bullet extends GameObject{
	double degree;
		
	public Bullet() {
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		width = 10;
		height = 10;
	}
	
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		//子弹移动
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		//子弹遇到边界，反弹回来
		if (y>Constant.GAME_HEIGHT-height||y<30) {
			degree = -degree;
		}
		
		if(x<0||x>Constant.GAME_HEIGHT-width) {
			degree = Math.PI - degree;
		}
		
		g.setColor(c);
	}


}
