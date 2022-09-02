/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Battleship;

import java.util.Scanner;
/**
 *
 * @author gabri
 */
public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int userGuess = 1;
        simpleStartup juego = new simpleStartup();
        juego.setLocationCells();
        System.out.println("Ingrese un numero: ");
        
        do{
        userGuess = scanner.nextInt();
        
        juego.checkYourself(userGuess);
        
        juego.getNumOfHits();
        
        
        System.out.println("Digite otro numero: ");
        }while(!juego.ganador());
        
        System.out.println("Has ganado");
    }
}
