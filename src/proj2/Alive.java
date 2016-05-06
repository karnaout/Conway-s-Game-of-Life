/*
 * Khaled Arnaout
 * Project 2 
 * Alive 
 */
package proj2;

/**
 * Alive Cell
 */
public class Alive implements Cell {
	
	private boolean state;
	
	public Alive(){ 
		this.state = true;
	}

	@Override
	public boolean isAlive() {
		// Always returns true
		return this.state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (state ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Alive))
			return false;
		Alive other = (Alive) obj;
		if (state != other.state)
			return false;
		return true;
	}
}
