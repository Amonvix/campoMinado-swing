package com.amon.cm.visao;

import javax.swing.JFrame;

import com.amon.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame{
	
	public TelaPrincipal() {
		Tabuleiro tabuleiro= new Tabuleiro(16, 30, 25);
		
		add(new PainelTabuleiro(tabuleiro));
		
		setTitle("Campo Minado");
		setSize(690, 438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new TelaPrincipal();
		
		
	}

	
}
