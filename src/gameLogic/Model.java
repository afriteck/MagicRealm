package gameLogic;

public class Model {

	int turn;
	GuiActivities gm;

	public Model() {
		gm = new GuiActivities(null);
	}

	public void playGame() {

		// while(true){

		if (gm.moved() == true) {
			gm.requestMove(gm.getPlayer1());
			System.out.println(gm.moved());
			gm.setMove(false);

			turn++;
		}
		if (gm.isHide()) {
			gm.requestHide(gm.getPlayer1(), gm.isHide(), null);
			turn++;
			gm.setHide(false);
		}
		if (gm.isAlert()) {
			gm.requestAlert(gm.getPlayer1(), null);
			turn++;

		}
		if (gm.isRest()) {
			gm.requestRest(gm.getPlayer1(), null);
			turn++;
			gm.setRest(false);

		}
		if (gm.isHire()) {
			gm.requestHire(gm.getPlayer1(), null);
			turn++;
			gm.setHire(false);

		}
		if (gm.isSearch()) {
			gm.requestSearch(gm.getPlayer1(), null);
			turn++;
			gm.setSearch(false);

		}
		if (gm.isTrade()) {
			gm.requestTrade(gm.getPlayer1());
			turn++;
			gm.setTrade(false);

		}

	}

	// }

}
