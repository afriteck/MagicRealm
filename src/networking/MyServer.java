package networking;

import gameBoard.BoardTiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import models.Counters;
import models.DamageEnum;
import models.Message;
import models.Player;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

public class MyServer {


	public static Server server;
    //static GameModel game_model;
    private static int max_players;
    //static GuiActivities gm = new GuiActivities();

	private static Counters c1 = null;
	private static Counters c2 = null;
	private static Counters c3 = null;
	private static Counters c4 = null;
    private static  BoardTiles bd;
    static ArrayList<Player>players;
    static HashMap<Connection, Player> clients;
	static ArrayList<Player> combatPlayers = new ArrayList<Player>();
    private static int turn;
    static int currentPlayer = 1 ;
    static int previous = 0;
	   static Random r  = new Random();
	   static boolean cheatmode;
	   static int numPlayers ;
	   private static ArrayList<Integer> played = new ArrayList<Integer>();


    // static boolean demo_flag = false;
   // static int markersPlaced;



    //Networking
    private static Kryo kryo;
    
    public  MyServer(){
    	
    bd = new BoardTiles();
    }

    public static void registerClasses() {
    	 kryo.register(java.util.ArrayList.class);
         kryo.register(java.util.HashMap.class);      
         kryo.register(java.util.HashMap.class);      

         kryo.register(java.awt.BorderLayout.class);      
         kryo.register(java.awt.Color.class);      
         kryo.register(java.awt.Dimension.class);      
         kryo.register(java.awt.Graphics.class);      
         kryo.register(java.awt.GridLayout.class);      
         kryo.register(java.awt.Image.class);      
         kryo.register(java.awt.Toolkit.class);      
         kryo.register(java.awt.event.ActionEvent.class);      
         kryo.register(java.awt.event.ActionListener.class);      
         kryo.register(java.awt.event.KeyEvent.class);      
         kryo.register(java.awt.event.MouseAdapter.class);      
         kryo.register(java.awt.event.MouseEvent.class);      
         kryo.register(javax.swing.BorderFactory.class);      
         kryo.register(javax.swing.ImageIcon.class);      
         kryo.register(javax.swing.JButton.class);      
         kryo.register(javax.swing.JComponent.class);      
         kryo.register(javax.swing.JFrame.class);      
         kryo.register(javax.swing.JLabel.class);      
         kryo.register(javax.swing.JOptionPane.class);      
         kryo.register(javax.swing.JPanel.class);      
         kryo.register(javax.swing.JScrollPane.class);      
         kryo.register(javax.swing.JTabbedPane.class);      
         kryo.register(javax.swing.JTextArea.class);      
         kryo.register(javax.swing.SwingUtilities.class);      
         kryo.register(javax.swing.UIManager.class);      
         kryo.register(javax.swing.border.EmptyBorder.class);      
         kryo.register(javax.swing.text.DefaultCaret.class);      
         
         
         kryo.register(java.io.FileReader.class);      
         kryo.register(java.net.URL.class);      
         kryo.register(org.json.simple.JSONObject.class);      
         
         
         kryo.register(org.json.simple.JSONArray.class);      
         kryo.register(org.json.simple.parser.JSONParser.class);      
         
         
         kryo.register(javax.swing.JTextField.class);      
         kryo.register(javax.swing.ButtonGroup.class);   
         
         kryo.register(java.awt.Container.class);   
         kryo.register(java.awt.Component.class);   
         kryo.register(javax.swing.ButtonGroup.class);   
         kryo.register(javax.swing.ButtonGroup.class);   

         


         
         kryo.register(gameBoard.BoardTiles.class);
         kryo.register(gameBoard.Clearing.class);
         kryo.register(gameBoard.InitBoardTiles.class);
         kryo.register(gameBoard.Tiles.class);
         kryo.register(gameLogic.Dice.class);
         kryo.register(gameLogic.GuiActivities.class);
         kryo.register(gameLogic.Iteration1Board.class);
         kryo.register(gameLogic.Locate.class);
         kryo.register(gameLogic.LocateEnum.class);
         kryo.register(gameLogic.Loot.class);
         kryo.register(gameLogic.LootEnum.class);
         kryo.register(gameLogic.MagicSightEnum.class);
         kryo.register(gameLogic.Model.class);
         kryo.register(gameLogic.Peer.class);
         kryo.register(gameLogic.PeerEnum.class);
         kryo.register(gameLogic.SearchTable.class);
         kryo.register(gui.CombatGui.class);
         kryo.register(gui.Gui.class);
         kryo.register(gui.HexCell.class);
         kryo.register(models.Amazon.class);
         kryo.register(models.Armor.class);
         kryo.register(models.BlackKnight.class);
         kryo.register(models.BreastPlates.class);
         kryo.register(models.BroadSword.class);
         kryo.register(models.Business.class);
         kryo.register(models.Captain.class);
         kryo.register(models.Chapel.class);
         kryo.register(models.Message.class);


         kryo.register(models.CharacterContainer.class);
         kryo.register(models.Counters.class);
         kryo.register(models.CrossBow.class);
         kryo.register(models.DamageEnum.class);
         kryo.register(models.Dwarf.class);
         kryo.register(models.Dwelling.class);
         kryo.register(models.Elf.class);
         kryo.register(models.Entity.class);
         kryo.register(models.Fight.class);
         kryo.register(models.Follow.class);
         kryo.register(models.GreatAxe.class);
         kryo.register(models.GreatSword.class);
         kryo.register(models.GuardHouse.class);
         kryo.register(models.Helmet.class);
         kryo.register(models.Hide.class);
         kryo.register(models.House.class);
         kryo.register(models.Income.class);
         kryo.register(models.Inn.class);


         kryo.register(models.LightBow.class);
         kryo.register(models.Mace.class);
         kryo.register(models.Monster.class);
         kryo.register(models.Move.class);
         kryo.register(models.Player.class);
         kryo.register(models.PlayerChit.class);
         kryo.register(models.Search.class);
         kryo.register(models.Shields.class);
         kryo.register(models.ShortSword.class);
         kryo.register(models.Spear.class);
         kryo.register(models.SuitsOfArmor.class);
         kryo.register(models.Swordsman.class);
         kryo.register(models.Things.class);
         kryo.register(models.ThrustingSword.class);
         kryo.register(models.TreasureChit.class);
         kryo.register(models.WarningChit.class);
         kryo.register(models.Weapons.class);

          kryo.register(models.WarningChit.Smoke.class);
          kryo.register(models.WarningChit.Bones.class);
          kryo.register(models.WarningChit.Dank.class);
          kryo.register(models.WarningChit.Ruins.class);
          kryo.register(models.WarningChit.Stink.class);

          kryo.register(java.util.LinkedList.class);
         
         
         kryo.register(natives.Archer.class);
         kryo.register(natives.Assasin.class);
         kryo.register(natives.Bashkars.class);
         kryo.register(natives.Company.class);
         kryo.register(natives.Crossbowman.class);
         kryo.register(natives.GreatAxeman.class);
         kryo.register(natives.GreatSwordsman.class);
         kryo.register(natives.Guard.class);
         kryo.register(natives.Knight.class);
         kryo.register(natives.Lancer.class);
         kryo.register(natives.Lancers.class);
         kryo.register(natives.Native.class);
         kryo.register(natives.NativeGroup.class);
         kryo.register(natives.Order.class);
         kryo.register(natives.Patrol.class);
         kryo.register(natives.Pikeman.class);
         kryo.register(natives.Raider.class);
         kryo.register(natives.Rogues.class);
         kryo.register(natives.ShortSwordsman.class);
         kryo.register(natives.Soldiers.class);
         kryo.register(natives.Swordsman.class);
         kryo.register(natives.Woodfolk.class);
        
         
         kryo.register(networking.MyServer.class);
         kryo.register(javax.swing.JPasswordField.class);
         kryo.register(javax.swing.ActionMap.class);
         kryo.register(javax.swing.text.JTextComponent.class);
         kryo.register(String[].class);

    
    }

    
    
    
    
    static class ClientConnection extends Connection {

    }



    public static void main(String[] args) {
    	
    	players = new ArrayList<Player>();
    	clients = new HashMap<Connection, Player>();

        if (args.length == 1) {
          try {
            max_players = Integer.parseInt(args[0]);
          } catch (NumberFormatException e) {
            System.err.println("Invalid command line argument - integer required");
            System.exit(1);
          }
        } else if (args.length == 2) {
          try {
            max_players = Integer.parseInt(args[0]);
          } catch (NumberFormatException e) {
            System.err.println("Invalid command line argument  - integer required");
            System.exit(1);
          }
          System.out.println("Demo flag detected");
         // demo_flag = true;
        } else {
          max_players = 1;
        }

       // markersPlaced = 0;

        System.out.println("Game configured for " + max_players + " players");

        // Initialize game model manager
       // game_model = new GameModel();
        server = new Server(122768, 106384) {
            protected Connection newConnection() {
                return new ClientConnection();
            }
        };
        kryo = server.getKryo();
        kryo.setReferences(true);
        registerClasses();

        Log.set(Log.LEVEL_DEBUG);

        Log.info("Starting server...");

        server.addListener(new Listener() {
            
        	
public void received(Connection connection, Object object) {

	
            	if (object instanceof BoardTiles) {
                //  if (markersPlaced == max_players) {
                    System.out.println("Received game model");
                   // bd = (BoardTiles) object; //removed class def
                    
                    connection.sendTCP(new Message("Sent game your current board to all "));
                     setBd(((BoardTiles) object));
                    server.sendToTCP(connection.getID(), ((BoardTiles) object));
                    server.sendToAllExceptTCP(connection.getID(),((BoardTiles) object));
                    connection.sendTCP(new Message("sending not turn"));

                    //currentPlayer = turn();
                   // int previous = currentPlayer;
                    	
                    	server.sendToTCP(turn(), new Message("sending your turn"));
                    	 server.sendToAllTCP(new Message("sending player"+currentPlayer + " is currentlyPlaying"));
                     	
                    	 if(currentPlayer != connection.getID())
                             server.sendToTCP(currentPlayer, new Message("sending not current turn"));

                        
                    	 // 	
                    //Increase turn and phase
                    //if (game_model.getTurn() == max_players) {
                      //  game_model.increaseTurn();
                        //game_model.increasePhase();
                        //game_model.calculateIncome(); // calculates income at the end of each phase
                    //} 
                        /*
                    else {
                        game_model.increaseTurn();
                    }

                    System.out.println("Turn changed to: " + game_model.getTurn());
                    System.out.println("Phase changed to: " + game_model.getPhase());

                    server.sendToAllTCP(game_model);
                  } else {
                    game_model = (GameModel) object; // removed class def
                    System.out.println("Markers set by Player " + markersPlaced);
                    markersPlaced++;
                    if (markersPlaced == max_players) {
                      System.out.println("All markers placed - before phases begin");
                      if (demo_flag) {
                        populateDemoHands();
                      } else {
                        populatePlayerHands();
                      }
                    }
                    server.sendToAllTCP(game_model);
                  }
               
                */
            	}else if(object instanceof Player){
            		
            		//players.add((Player)object);
            		clients.put(connection, (Player)object);
            		//System.out.println(clients + clients.get(connection).getCharacter().getName() + clients.get(connection).getCharacter().getCharacterArmory().get(0).getName());
                
                
            	} else if (object instanceof Message) {
                    if (((Message) object).toString().contains("sending")) {
                        //Client has just sent a message
                        System.out.println("Client sent: " + object.toString());
                    
                    } 
                    else if(((Message) object).toString().contains("notselected")){
                    	server.sendToTCP(connection.getID(),  new Message("select"));
                    }
                    
                    else if(((Message) object).toString().contains("in cheatmode")){
                    	server.sendToAllTCP(new Message("cheatmode"));
                    	cheatmode = true;
                    	
                    }
                    
                    else if(((Message) object).toString().contains("Amazon")){
                    	server.sendToAllTCP(new Message("Player"+connection.getID()+"chose amazon"));                    	
                    }
                    
                    else if(((Message) object).toString().contains("Elf")){
                    	server.sendToAllTCP(new Message("Player"+connection.getID()+"chose elf"));                    	
                    }
                    else if(((Message) object).toString().contains("Dwarf")){
                    	server.sendToAllTCP(new Message("Player"+connection.getID()+"chose dwarf"));                    	
                    }
                    else if(((Message) object).toString().contains("Captain")){
                    	server.sendToAllTCP(new Message("Player"+connection.getID()+"chose captain"));                    	
                    }
                    
                    else if(((Message) object).toString().contains("Swordsman")){
                    	server.sendToAllTCP(new Message("Player"+connection.getID()+"chose Swordsman"));                    	
                    }
                    else if(((Message) object).toString().contains("Black Knight")){
                    	server.sendToAllTCP(new Message("Player"+connection.getID()+"chose blackknight"));                    	
                    }
                    
                    else if(((Message) object).toString().contains("not cheatmode")){
                    	server.sendToAllTCP(new Message("not cheatmode"));
                    	cheatmode = false;
                    }
                    else if(((Message) object).toString().contains("selected")){
                    	server.sendToAllExceptTCP(connection.getID(), new Message("your turn"));
                    	server.sendToTCP(connection.getID(),  new Message("ok"));

                    }
                    else if(((Message) object).toString().contains("block me")){
                    	server.sendToTCP(connection.getID(),  new Message("sending you have been blocked"));
                    	
                    }
                    else if(((Message) object).toString().contains("i was blocked")){
                    	server.sendToTCP(connection.getID(),  new Message("sending please unblock"));
                    	
                    } else if (((Message) object).toString().contains(
							"character chits")) {
						Player p1 = clients.get(connection);
						combatPlayers.add(p1);
						Player p2;

						for (Connection key : clients.keySet()) {
							if (clients.get(key).getCharacter()
									.getClearingLocation() == p1.getCharacter()
									.getClearingLocation()
									&& !clients.get(key).getCharacter()
											.equals(p1.getCharacter())) {
								combatPlayers.add(clients.get(key));
								server.sendToTCP(key.getID(), new Message(
										"sending you are now in combat"));

								//combatPlayers.add(clients.get(key));
							}
						}

						p2 = combatPlayers.get(combatPlayers.size() - 1);
						combatResolution(p1, p2);
					} else {
                        //if (game_model.registerPlayer(max_players)) {
                            System.out.println("New listener created from: " + connection);
                            
                            connection.sendTCP(new Message( connection + "Welcome!"));
                          server.sendToAllTCP(new Message(connection + "is connected"));      
                           server.sendToAllTCP(new Message(connection + "is connected" + cheatmode));                           
                           //server.sendToAllTCP(new Message("sending your turn"));
                          server.sendToAllExceptTCP(currentPlayer, new Message("not turn "));
                           

                           
                           
                           
                           

                   
                } 
            } else {  // keepalive packets
                System.out.println("Other: " + object.toString());
       


                        
                    //else {
                         //   connection.sendTCP(new Message("Cannot join game"));
                       // }
                    }
                } 
        	

            @Override
            public void disconnected(Connection connection) {
                System.out.println("Connection: " + connection + " disconnected");
            }
        });
        try {
            server.bind(9999);
            System.out.println("Server started and bound to port 9999...");
        } catch (IOException ex) {
            //Logger.getLogger(KingsnThings.class.getName()).log(Level.SEVERE, null, ex);
        }
        server.start();

       // while (game_model.numPlayers() < max_players) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(KingsnThings.class.getName()).log(Level.SEVERE, null, ex);
            }
    }



	public static BoardTiles getBd() {
		return bd;
	}



	public static void setBd(BoardTiles bd) {
		MyServer.bd = bd;
	}
            
	public static int turn() { // sets players random selection between 4
		
		if(played.size() > numPlayers){
			played.clear();
			}
		Random rand = new Random();
		currentPlayer = rand.nextInt(numPlayers) + 1;
		if (played.contains(currentPlayer)){
			turn();
		}
		played.add(currentPlayer);
		return currentPlayer;
	}
	   
	   public static int next() {
		ArrayList<Integer> usedNumbers = new ArrayList<Integer>();

		Integer res = r.nextInt(2) + 1;
		if (usedNumbers.contains(res)) {

			next();
		}
		usedNumbers.add(res);

		if (usedNumbers.size() == 1) {
			usedNumbers.clear();
		}
		return res;
	}

	public static void combatResolution(Player p1, Object obj) {
		System.out.println("Here");

		// Last used counters for player 1
		if (p1.getCharacter().getFatiguedCounter().size() > 0) {
			c1 = p1.getCharacter().getFatiguedCounter()
					.get(p1.getCharacter().getFatiguedCounter().size() - 1);
			c2 = p1.getCharacter().getFatiguedCounter()
					.get(p1.getCharacter().getFatiguedCounter().size() - 2);
		}
		// Last used counters for player 2
		if (obj instanceof Player) {
			if (((Player) obj).getCharacter().getFatiguedCounter().size() > 0) {
				c3 = ((Player) obj)
						.getCharacter()
						.getFatiguedCounter()
						.get(((Player) obj).getCharacter().getFatiguedCounter()
								.size() - 1);
				c4 = ((Player) obj)
						.getCharacter()
						.getFatiguedCounter()
						.get(((Player) obj).getCharacter().getFatiguedCounter()
								.size() - 2);
			}
		}

		if (c1.getType() == "FIGHT" && c3.getType() == "MOVE") {
			if (c1.getStrength().equals(DamageEnum.TREMENDOUS)
					&& (c3.getStrength().equals(DamageEnum.HEAVY)
							|| c3.getStrength().equals(DamageEnum.MEDIUM) || c3
							.getStrength().equals(DamageEnum.LIGHT))) {
				// say initiating player won out
				System.out.println("Player 1 won");
			} else if (c1.getStrength().equals(DamageEnum.HEAVY)
					&& (c3.getStrength().equals(DamageEnum.MEDIUM) || c3
							.getStrength().equals(DamageEnum.LIGHT))) {
				System.out.println("Player 1 won -- 2");
			} else if (c1.getStrength().equals(DamageEnum.MEDIUM)
					&& c3.getStrength().equals(DamageEnum.LIGHT)) {
				System.out.println("Player 1 won -- 3");
			} else {
				// Strength are the same
				if(c1.getSpeed() < c3.getSpeed()) {
					System.out.println("Player 1 won -- Speed Higher");
				} else {
					/*if(p1.getCharacter().getWeapons().getDamage() > ((Player) obj).getCharacter().getWeapons().getLength()) {
						System.out.println("Player 1 won -- Weapon Length Longer");
					} else {
						// initiated player wins
						System.out.println("Player 2 won");
					}*/
				}
			}
		}

		if (c2.getType() == "MOVE" && c4.getType() == "FIGHT") {

		}
	}

      // private ArrayList<Integer> usedNumbers;
       //private Random r;
      // private int maxNumber;

      /* public RandomNumberGenerator(int maxNumber) {
           r = new Random();
           usedNumbers = new ArrayList<Integer>();
           this.maxNumber = maxNumber;
       */ 
       //}
       
       // }

        //Load up each player's hands with cards
        //populatePlayerHands();
        //distributePlayerMarkers();

        //server.sendToAllTCP(game_model);
    }







