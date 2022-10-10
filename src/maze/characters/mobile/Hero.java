package maze.characters.mobile;

import maze.*;
import java.util.*;
import maze.items.*;
import maze.exceptions.*;
import maze.interfaces.HeroAction;

/** A class that represents a hero which is a mobile character */
public class Hero extends MobileCharacter {

  /** the hero's inventory */
  private List<Item> inventory;

  /** the number of jewels */
  private int nbOfJewels;

  /** the number of gold coins */
  private int goldCoins;

  /** the game where the hero will be modeled */
  private Game game;

  /** list of actions available */
  private List<HeroAction> actions;


  /** A hero is defined by its name, its position, and the game. Initially the hero has no jewels
   * and no gold coins.
   * @param name the hero's name
   * @param position the hero's position
   */
  public Hero(String name, Cell position) {
    super(name, position);
    this.nbOfJewels = 0;
    this.goldCoins = 0;
    this.inventory = new ArrayList<>();
    this.actions = new ArrayList<>();
  }


  /** A hero with no current cell (== null), and no game. Initially the hero has no jewels
   * and no gold coins.
   * @param name the hero's name
   */
   public Hero(String name) {
     super(name, null);
     this.nbOfJewels = 0;
     this.goldCoins = 0;
     this.inventory = new ArrayList<>();
     this.actions = new ArrayList<>();
   }


   /** Returns the game where the hero is modeled
    * @return the game where the hero is modeled
    */
   public Game getGame() {
     return this.game;
   }

   /** Sets the game where the hero is modeled
    * @param game the game where the hero is modeled
    */
   public void setGame(Game game) {
     this.game = game;
   }


  /** Returns the list of objects
   * @return the hero's inventory
   */
  public List<Item> getInventory() {
    return this.inventory;
  }

  /** Returns the number of jewels that the hero has
   * @return the number of jewels that the hero has
   */
  public int getNbOfJewels() {
    return this.nbOfJewels;
  }

  /** Returns the number of gold coins that the hero has
   * @return the number of gold coins that the hero has
   */
  public int getGold() {
    return this.goldCoins;
  }

  /** Sets the amount of gold coin
   * @param gold the amount to set
   */
  public void setGoldCoins(int gold) {
    this.goldCoins = gold;
  }

  /** Sets the quantity of jewel
   * @param newQuantity the new quantity of jewel
   */
  public void setQuantityOfJewels(int newQuantity) {
    this.nbOfJewels = newQuantity;
  }


  /**
   * Does the action chosen by the hero
   * @throws UnknownCellException if coordinates (x,y) are not valid for the board
   */
  public void doAction() throws UnknownCellException {
    System.out.println("What do you want to do ? (Press `help` to have more informations) \n");
    HeroAction action = this.chooseAction();
    action.apply(this);
  }


  /** Chooses an action (which is possible)
   * @return the action chosen
   */
  public HeroAction chooseAction() {
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    for(HeroAction action : this.possibleActions()) {
      if(str.equals(action.toString())) {
        return action;
      }
    }
    System.out.println("Wrong action written ! Try again : \n");
    return this.chooseAction();
  }


  /** Returns the list of possible actions
   * @return the list of possible actions
   */
  public List<HeroAction> possibleActions() {
    List<HeroAction> possible = new ArrayList<>();
    for(HeroAction a : this.actions) {
      if(a.isPossible(this)) {
        possible.add(a);
      }
    }
    return possible;
  }


  /**
   * Displays all possible actions
   */
  public void displayPossibleActions() {
    for(HeroAction act : this.possibleActions()) {
      System.out.println(act + " - " + act.description());
    }
  }


  /** Returns list of all actions
   * @return list of all actions
   */
  public List<HeroAction> getAllActions() {
    return this.actions;
  }

}
