/**
 * 
 */
package models;

/**
 * @author joshwhite
 * 
 */
public class PlayerChit {

	private String name;
	private String character;
	private String url;
	private String hiddenUrl = "hidden.jpg";
	private boolean isHidden;

	public PlayerChit(String n, String c, String u) {
		setName(n);
		setCharacter(c);
		setUrl(u);
		setHidden(false);
	}

	public PlayerChit() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getUrl() {
		if (this.isHidden == true) {
			return this.hiddenUrl;
		} else {
			return this.url;
		}
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
}
