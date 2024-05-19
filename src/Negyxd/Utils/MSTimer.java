package Negyxd.Utils;

public class MSTimer {
	 public long time = -1L;

	    public boolean hasTimePassed(long MS) {
	        return System.currentTimeMillis() >= this.time + MS;
	    }

	    public long hasTimeLeft(long MS) {
	        return MS + this.time - System.currentTimeMillis();
	    }

	    public void reset() {
	        this.time = System.currentTimeMillis();
	    }
}
