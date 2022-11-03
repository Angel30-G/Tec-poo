package Battleship;

import java.util.Scanner;
import javax.swing. *;
/**
 *
 * @author gabri
 * 
 */
import java.io.File;

public class partida {
	public void jugar() {
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    String userGuess1 = "";
    int userGuess2 = 1;
    simpleStartup juego = new simpleStartup();
    juego.setLocationCells();
    
    do{
    System.out.println("Ingrese la coordenada X: "); //Utilizar letras mayusculas
    userGuess1 = scanner2.nextLine();
    System.out.println("Ingrese la coordenada Y: ");//Ingresar algun numero
    userGuess2 = scanner.nextInt();
    
    
    juego.checkYourself(userGuess1,userGuess2);
    
    juego.getNumOfHits();
    //juego.hitShips();
    
    
    System.out.println(" ");
    }while(!juego.ganador());
    
    System.out.println("Has ganado");
  }
}
