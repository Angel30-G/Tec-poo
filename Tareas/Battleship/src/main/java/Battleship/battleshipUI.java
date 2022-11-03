package Battleship;


import javax.swing. *;

import java.awt. *;

import java.awt.event.*;

public class battleshipUI {

	public void plantilla() {
		plantilla panel = new plantilla();
		panel.plantilla();
		
	}
	

}

class plantilla extends JFrame{
	public plantilla(){
		setSize(500, 500);
		setLocation(500, 100);
		setTitle("Battleship");
		
		matriz panel1 = new matriz();
		
		add(panel1);
		
		setVisible(true);
	}

	public void plantilla() {
		plantilla();
		
	}
	
}

class matriz extends JFrame implements ActionListener{
	private int filas=7;
	private int columnas=7;
	JButton[][] Cuadro;
	simpleStartup terminal = new simpleStartup();
	
	public void valorMatrix() {
		simpleStartup matriz = new simpleStartup();
		matriz.setLocationCells();
	}
	
	public void setMatrix() {
		this.setLayout(new GridLayout(filas, columnas));
		Cuadro = new JButton[filas][columnas];
		int x = 20;
		int y = 20;
		
		for(int i = 0; i < filas; i++) {
			for(int j = 0; j < columnas; j++) {
				Cuadro[i][j] = new JButton();
				Cuadro[i][j].setBackground(Color.black);
				Cuadro[i][j].setBounds(x, y, 20, 20);
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Cuadro) {
			setMatrix();
			
			
		}
		
	}
}



	/*public abstract class action implements ActionListener{
		ActionListener presionar = new ActionListener() {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			if(valorMatrix() == 0) {
				Cuadro.setBackground(Color.RED);
			}else {
				Cuadro.setBackground(Color.BLUE);
			}
			
		}
			
	}}*/





