package gameLogic;

import java.awt.Container;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Model {

int turn ;
GuiActivities gm;

public Model(){
	gm = new GuiActivities(null);
}



public void playGame(JTextArea txt, Container cp){
	
	if(turn == 4){
	JOptionPane.showMessageDialog(null, "you have maxed your activities for the day");

		/*
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
		if(gm.moved() == true){
			if(gm.requestMove(gm.getPlayer1()))
				turn++;
			gm.setMove(false);

			System.out.println(turn);

		}if(gm.isHide()){
				if(gm.requestHide(gm.getPlayer1(), gm.getRolled(), txt))
				turn++;
				gm.setHide(false);

		}if(gm.isAlert()){
					if(gm.requestAlert(gm.getPlayer1(), txt))
					turn++;
					gm.setAlert(false);


		} if(gm.isRest()){
					if(gm.requestRest(gm.getPlayer1(), txt))
					turn++;
					gm.setRest(false);

		}if(gm.isHire()){
					if(gm.requestHire(gm.getPlayer1(), txt))
					turn++;
					gm.setHire(false);


		} if(gm.isSearch()){
					/*if(gm.requestSearch(gm.getPlayer1(), cp))
					turn++;
					gm.setSearch(false);*/

		} if(gm.isTrade()){
			//gm.intializeTrade(cp);
			if(gm.requestTrade(gm.getPlayer1()))
					turn++;
					gm.setTrade(false);


			
		}
		
	}

	
//}



}
