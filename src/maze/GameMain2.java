package maze;

import maze.algo.*;
import maze.items.*;
import maze.actions.*;
import maze.interfaces.*;
import maze.exceptions.*;
import java.util.Scanner;
import maze.characters.mobile.*;
import maze.characters.immobile.*;

/** A main class that will play the game */
public class GameMain2 {

  /** The main method
   * @param args the argument
   */
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    MazeGenerator bt = new BinaryTree();
    MazeGenerator sw = new Sidewinder();

    try {

      System.out.println("Please choose a size for the board. \n");
      System.out.println("The width : ");
      int width = scan.nextInt();
      System.out.println("The height : ");
      int height = scan.nextInt();

      if(width > 0 || height > 0) {
        Board b = new Board(width, height);

        Hero hero = new Hero("hero");
        Quest quest = new Quest(b, hero);

        Game game = new Game(b, quest);
        hero.setGame(game);
        game.addHero(hero);

        // initialization of all items and characters of the game

        int size = 9;
        int sizeItems = 13;
        InteractiveCharacter[] tab = new InteractiveCharacter[size];
        InteractiveCharacter[] tab2 = new InteractiveCharacter[size+1];
        InteractiveCharacter[] tab3 = new InteractiveCharacter[size];

        Item[] tabItems = new Item[sizeItems+1];
        Item[] tabItems2 = new Item[sizeItems];

        // creation of several jewels
        for(int i = 1; i < sizeItems+1; i++) {
          tabItems[i] = new Jewel("jewel");
        }

        // creation of several scrolls
        for(int i = 1; i < sizeItems; i++) {
          tabItems2[i] = new Scroll("scroll");
        }

        // putting each jewel to a random cell
        for(int i = 1; i < tabItems.length; i++) {
          b.getRandomCell().setItem(tabItems[i]);
        }

        // putting each scroll to a random cell
        for(int i = 1; i < tabItems2.length; i++) {
          b.getRandomCell().setItem(tabItems2[i]);
        }

        for(int i = 1; i < size; i++){
          tab[i] = new Trader("trader");
        }

        for(int i = 1; i < size+1; i++){
          tab2[i] = new Sphynx("sphynx");
        }

        for(int i = 1; i < size; i++){
          tab3[i] = new Bishop("bishop");
        }

        for(int i = 1; i < tab.length; i++) {
          b.getRandomCell().setCharacter(tab[i]);
        }

        for(int i = 1; i < tab2.length; i++) {
          b.getRandomCell().setCharacter(tab2[i]);
        }

        for(int i = 1; i < tab3.length; i++) {
          b.getRandomCell().setCharacter(tab3[i]);
        }


        // initialization of all actions of the game
        HeroAction help = new Help();
        HeroAction pick = new PickUp();
        HeroAction interact = new Interact();
        HeroAction look = new LookAround();
        HeroAction move = new Move();
        HeroAction use = new UseObject();

        // adding all actions to the hero's list of actions
        hero.getAllActions().add(help);
        hero.getAllActions().add(pick);
        hero.getAllActions().add(interact);
        hero.getAllActions().add(look);
        hero.getAllActions().add(move);
        hero.getAllActions().add(use);

        System.out.println("Now, choose a maze generation algorithm : \n");
        System.out.println("(1) BinaryTree, (2) Sidewinder \n");
        int nb = scan.nextInt();

        if(nb == 1) {
          System.out.println("You chose the BinaryTree algorithm");
          b.selectMaze(bt);
          game.play(hero);
        }
        else if(nb == 2) {
          System.out.println("You chose the Sidewinder algorithm");
          b.selectMaze(sw);
          game.play(hero);
        }
        else {
          System.out.println("ERROR : You have to choose an existing algorithm.");
        }
      }
      else if(width < 0 || height < 0)
        System.out.println("ERROR :The board's size cannot be a negative integer !");
    }

    catch(UnknownCellException e) {
      System.out.println(e.getMessage());
    }
    catch(UnknownAlgorithmException e) {
      System.out.println(e.getMessage());
    }
  }
}
