package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import model.Player;
import thread.EnemyThread;

public class GameGUI {
	
    @FXML
    private Circle playerBall;
    
    @FXML
    private Circle enemie;
    
    @FXML
    private Button btnMove;

	private Player player;
	
	private EnemyThread enemy;
	
	private boolean win;
	
	Thread t;
	
	public GameGUI() {
		
	}
	
	public void initialize() {
		player = new Player(playerBall.getLayoutX(),playerBall.getLayoutY());
		enemy = new EnemyThread(enemie.getLayoutX(), enemie.getLayoutY(), this);
		new Thread(enemy).start();
		System.out.println(playerBall.getLayoutX()+","+	playerBall.getLayoutY());
	}
	
	
    @FXML
    void xd(KeyEvent event) {
    	switch (event.getCode()) {
		case DOWN:
			player.move(1);
			break;
		case LEFT:
			player.move(2);
			break;
		case RIGHT:
			player.move(3);
			break;
		case UP:
			player.move(4);
			break;
		}
    	System.out.println("Moved");
    	playerBall.setLayoutX(player.getPosX());
    	playerBall.setLayoutY(player.getPosY());
    	
    }
    
    @FXML
    void movePLayer(ActionEvent event) {
    	System.out.println();
    }

    public void moveStuff() {
    	while(!win) {
    		enemy.setObjX(player.getPosX());
    		enemy.setObjY(player.getPosY());
    		enemie.setLayoutX(enemy.getPosX());
    		enemie.setLayoutY(enemy.getPosY());
    	}
    }
	public void updateEnemy() {
		enemy.setObjX(player.getPosX());
		enemy.setObjY(player.getPosY());
		enemie.setLayoutX(enemy.getPosX());
		enemie.setLayoutY(enemy.getPosY());
		double x = distanceBetween();
		if(distanceBetween() < playerBall.getRadius()*2) {
			enemy.setStop(true);
		}
		 
	}
		
	public double distanceBetween() {
		double a = Math.pow(player.getPosX()-enemy.getPosX(), 2);
		double b = Math.pow(player.getPosY()-enemy.getPosY(), 2);
		
		double distance = Math.sqrt(a+b);
		System.out.println(distance);
		return distance;
	}
}
