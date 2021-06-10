package thread;

import ui.GameGUI;

public class EnemyThread implements Runnable{

	
	private double posX, posY, objX, objY, speed;
	private boolean dir, stop;
	private GameGUI gameUI;
	
	public EnemyThread(double d, double e, GameGUI GU) {
		posX = d;
		posY = e;
		speed = 5;
		gameUI = GU;
	}
	
	public void chase() {
		if(dir) {
			if(objX < posX) {
				posX-=speed;
			}else {
				posX+=speed;
			}
			dir = !dir;
		}else {
			if(objY < posY) {
				posY-=speed;
			}else {
				posY+=speed;
			}
			dir = !dir;
		}
		
	}
	
	@Override
	public void run() {
		while(!stop) {
			chase();
			//System.out.println(posX+","+posY);
			gameUI.updateEnemy();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getObjX() {
		return objX;
	}

	public void setObjX(double objX) {
		this.objX = objX;
	}

	public double getObjY() {
		return objY;
	}

	public void setObjY(double objY) {
		this.objY = objY;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

}
