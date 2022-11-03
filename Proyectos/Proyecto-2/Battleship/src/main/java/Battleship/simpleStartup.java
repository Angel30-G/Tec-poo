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
     private int[][] locationCells;
     private int guessX;
     private String vertical;
     private int guessY;
     private boolean salir=false;
     private int[][] ships;
     
    public boolean isSalir() {
        return salir;
    }

    public void setSalir(boolean salir) {
        this.salir = salir;
    }
    

    public int[][] getLocationCells() {
        return locationCells;
    }

    public void setLocationCells(int[][] locationCells) {
        this.locationCells = locationCells;
    }

    public int getGuessX() {
        return guessX;
    }

    public void setGuessX(int guess) {
        this.guessX = guess;
    }
    
    public int getGuessY() {
        return guessY;
    }

    public void setGuessY(int guess) {
        this.guessY = guess;
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
    
    public void validarPosicionX(String vertical){
        this.vertical = vertical;
        switch(vertical){
            case "A":
                guessX = 0;
                break;
            case "B":
                guessX = 1;
                break;
            case "C":
                guessX = 2;
                break;
            case "D":
                guessX = 3;
                break;
            case "E":
                guessX = 4;
                break;
            case "F":
                guessX = 5;
                break;
            case "G":
                guessX = 6;
                break;
            default:
                System.out.println("Fuera del rango");
                guessX = 10;
                this.numOfHits++;
                break;
        }
    }
  
   
   public boolean ganador(){
       int victoria = 0;
       for (int i = 0; i < locationCells.length-1; i++) {
           for(int j = 0; j < locationCells.length-1; j++){
               
           
           if (locationCells[i][j]==0) {
               victoria++;
           }
           
           if (victoria==49) {
               return true;
            }
          }
       }
       return false;
   }
  
    
    public int checkYourselfN(int guessX, int guessY){
        validarPosicionX(vertical);
        if (guessX >= 7 || guessY >= 7) {
            return 0;
        }
        if(this.locationCells[guessX][guessY] == 1){
            System.out.println("Hit");
            this.locationCells[guessX][guessY] = 0;
            this.numOfHits++;
            return 1;
         }
        
        else if(this.locationCells[guessX][guessY] == 0){
            System.out.println("Miss");
            this.numOfHits++;
            return 0;
         }
         return 0;
        
    }
    
        public void checkYourself(String vertical, int guessY){
        validarPosicionX(vertical);
        if (guessX >= 7 || guessY >= 7) {
            return ;
        }
        if(this.locationCells[guessX][guessY] == 1){
            System.out.println("Hit");
            this.locationCells[guessX][guessY] = 0;
            this.numOfHits++;
         }
        
        else if(this.locationCells[guessX][guessY] == 0){
            System.out.println("Miss");
            this.numOfHits++;
         }
        
    }
    
    public void setLocationCells(){
        int posicion[][] = new int[7][7];
        setLocationCells(posicion);
        for(int i = 0; i<7; i++){
            for(int j = 0; j < 7; j++){
            this.locationCells[i][j] = (int)(Math.random()*2);
            System.out.println("Arreglo "+i+j+" --> "+ this.locationCells[i][j]);
            }
        }
  }
    
 /*   public void hitShips(){
    int contador = 0;
    this.ships = this.locationCells;
       for (int i = 0; i < locationCells.length-1; i++) {
           for(int j = 0; j < locationCells.length-1; j++){
  
                if(this.ships[0][j] == 0){
                    contador++;
                }
                if(contador == 6){
                    System.out.println("Barco destruido");
                }
            }
        }
    } */
}

