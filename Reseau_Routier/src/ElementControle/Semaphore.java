package ElementControle;

import ElementSimulation.Voiture;

public abstract class Semaphore <E extends ElementRegulation>  {

		private E e;
		public abstract void update();
		public abstract void update(Voiture v);
		public E getE() {
			return e;
		}
		public void setE(E e) {
			this.e = e;
		}
		
		
}
