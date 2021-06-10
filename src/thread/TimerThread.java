package thread;

import ui.GameGUI;

public class TimerThread implements Runnable{

	public int seconds, minutes;
	private boolean count;
	private GameGUI gui;
	
	public TimerThread(GameGUI gui) {
		seconds = 0;
		minutes = 0;
		this.gui = gui;
	}

	@Override
	public void run() {
		while(!count) {
			seconds++;
			if(seconds == 60) {
				seconds = 0;
				minutes++;
			}
			
			gui.setText();
			//System.out.println(minutes+":"+seconds);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	

}
