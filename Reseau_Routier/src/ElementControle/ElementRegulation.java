package ElementControle;

public abstract class ElementRegulation <S extends Semaphore>{
	S s;

	public S getS() {
		return s;
	}

	public void setS(S s) {
		this.s = s;
	}
	
	public abstract void update();
}
