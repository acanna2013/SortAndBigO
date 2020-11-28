public class StopWatch {

	private boolean isRunning;
	private long startTime;
	private long endTime;

	public StopWatch() {
		reset();
	}

	public void reset()
	{
		startTime = 0;
		endTime= 0;
		isRunning = false;
		
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void start() {
		
		startTime = System.currentTimeMillis();
		isRunning = true;

	}

	public long stop() {
		if (!isRunning()) {
			return -1;
		} else {
			endTime = System.currentTimeMillis();
			isRunning = false;
			return endTime - startTime;
		}
	}

	public long getElapsedTime() {
		if (isRunning()) {
			return (System.currentTimeMillis() - startTime);
		} else
			return (endTime - startTime);
	}
}

