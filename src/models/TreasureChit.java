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
	private static final String fpath = "/actions/trade.gif";
	private int notoriety;
	private int gold;
	private int fame;

	public TreasureChit(){
		//constructor
		setVisisble(false);
	}
	
	public TreasureChit(int n, int g, int f){
		//constructor
		setVisisble(false);
		this.notoriety = n;
		this.gold = g;
		this.fame = f;
	}

	public boolean isVisisble() {
		return visisble;
	}

	public void setVisisble(boolean visisble) {
		this.visisble = visisble;
	}

	public int getNotoriety() {
		return notoriety;
	}

	public void setNotoriety(int notoriety) {
		this.notoriety = notoriety;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getFame() {
		return fame;
	}

	public void setFame(int fame) {
		this.fame = fame;
	}

	public String getFpath() {
		return fpath;
	}
}
