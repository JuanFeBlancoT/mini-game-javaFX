package thread;

import ui.GameGUI;

public class TimerThread extends Thread{

	public int seconds, minutes;
	private boolean count;
	
	public TimerThread(GameGUI gui) {
		seconds = 0;
		minutes = 0;
	}

	@Override
	public void run() {
		while(!count) {
			seconds++;
			if(seconds == 60) {
				seconds = 0;
				minutes++;
			}
			
			System.out.println(minutes+":"+seconds);
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
