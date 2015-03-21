/**
 * 
 */
package models;

/**
 * @author joshwhite
 *
 */
public class TreasureChit {
	
	private boolean visisble;

	public TreasureChit(){
		//constructor
		setVisisble(false);
	}

	public boolean isVisisble() {
		return visisble;
	}

	public void setVisisble(boolean visisble) {
		this.visisble = visisble;
	}
}
