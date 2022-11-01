/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Battleship.app;

import javax.swing. *;

import java.awt. *;

import java.awt.event.*;

public class UI {
	public static void main(String args[]) {
		menu interfaz = new menu();
    	interfaz.setVisible(true);
    	interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}


class menu extends JFrame{
	public menu(){
		setSize(500, 500);
		setLocation(500, 100);
		setTitle("Battleship");
		
		MenuLamina panel1 = new MenuLamina();
		//battleshipUI matriz = new battleshipUI();
		
		add(panel1);
		//add(matriz);
		
		setVisible(true);
	}

	private void add(battleshipUI matriz) {
		// TODO Auto-generated method stub
		
	}
	
}

class MenuLamina extends JPanel implements ActionListener{
	JMenuItem cargar;
	JMenuItem nuevo;
	JMenuItem salir;
	battleshipUI matriz = new battleshipUI();
	public MenuLamina() {
		JMenuBar mibarra = new JMenuBar();
		
		JMenu jugar = new JMenu("Jugar");
		JMenu configuracion = new JMenu("Configuración");
		JMenu acerca = new JMenu("Acerca de");
		
		
		JMenuItem nuevo = new JMenuItem("Nuevo");
		
                
		cargar = new JMenuItem("Cargar");
		cargar.addActionListener(this);
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		
		jugar.add(nuevo);
		jugar.add(cargar);
		jugar.add(salir);
		
		
		mibarra.add(jugar);
		mibarra.add(configuracion);
		mibarra.add(acerca);
		
		add(mibarra);
		
		
			
		
		
		
	}
	

	
	
	
	/*public void actionPerformed1(ActionEvent e) {
		if(e.getSource()==nuevo) {
			matriz.plantilla();
		}
		
	}*/
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nuevo) {
			matriz.plantilla();
		}
		if(e.getSource()==cargar) {
			JFileChooser filechooser = new JFileChooser();
			
			filechooser.showOpenDialog(null);
			
		}
		if(e.getSource()==salir) {
			System.exit(0);
		}
		
	}
	
}
	
/*	public void actionPerformed2(ActionEvent e) {
		if(e.getSource()==salir) {
			System.exit(0);
		}
		
  }*/
	



/*
class menu_Botones extends JPanel implements ActionListener{
	JButton juego = new JButton("Juego");
	JButton acerca = new JButton("Acerca");
	
	public menu_Botones() {
		add(juego);
		add(acerca);
		
		juego.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}

class opciones extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D) g;
		Font miFuente = new Font("Arial", Font.BOLD, 26);
		g2.setFont(miFuente);
		g.drawString("BattleShip", 200, 160);
	}
}
*/
