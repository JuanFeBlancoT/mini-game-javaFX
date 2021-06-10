package model;

public class Player implements Runnable{

	private double posX, posY;	
	private boolean movingStatus;
	
	public Player(double layoutX, double layoutY) {
		posX = layoutX;
		posY = layoutY;
	}

	@Override
	public void run() {
		posX+=2;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public boolean isMovingStatus() {
		return movingStatus;
	}

	public void setMovingStatus(boolean movingStatus) {
		this.movingStatus = movingStatus;
	}

	public void move(int i) {
		switch(i) {
		case 1:
			posY+=5;
			break;
		case 2:
			posX-=5;
			break;
		case 3:
			posX+=5;
			break;
		case 4:
			posY-=5;
			break;
		}		
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	
	
}
