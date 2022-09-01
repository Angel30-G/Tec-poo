/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Battleship;

/**
 *
 * @author gabri
 */
public class simpleStartup {
     private int[] locationCells;
     private int guess;
     private boolean salir=false;
     
    public boolean isSalir() {
        return salir;
    }

    public void setSalir(boolean salir) {
        this.salir = salir;
    }
    

    public int[] getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void getNumOfHits() {
        System.out.println("Intentos: "+numOfHits);
    }

    public void setNumOfHits(int numOfHits) {
        this.numOfHits = numOfHits;
    }
     private int numOfHits = 0;
     

     
    public simpleStartup() {
        
    }
  
   
   public boolean ganador(){
       int victoria = 0;
       for (int i = 0; i < locationCells.length-1; i++) {
           
           if (locationCells[i]==0) {
               victoria++;
           }
           
           if (victoria==6) {
               return true;
           }
       }
       return false;
   }
  
    
    public void checkYourself(int guess){
        if (guess >= 7) {
            return ;
        }
        if(this.locationCells[guess] == 1){
            System.out.println("Hit");
            this.locationCells[guess] = 0;
            this.numOfHits++;
         }
        
        else if(this.locationCells[guess] == 0){
            System.out.println("Miss");
            this.numOfHits++;
         }
        
    }
    
    public void setLocationCells(){
        int posicion[] = new int[7];
        setLocationCells(posicion);
        for(int i = 0; i<7; i++){
            this.locationCells[i] = (int)(Math.random()*2);
            System.out.println("Arreglo "+i+" --> "+ this.locationCells[i]);
        }
  }
 
}

