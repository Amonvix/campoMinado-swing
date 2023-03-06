package com.amon.cm.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.amon.cm.modelo.Campo;
import com.amon.cm.modelo.CampoEvento;
import com.amon.cm.modelo.CampoObservador;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador,MouseListener{
	
	private Campo campo;
	private final Color BG_PADRAO = new Color(184,184,184);
	private final Color BG_MARCAR = new Color(8,179,247);
	private final Color BG_EXPLODIR = new Color(189,66,68);
	private final Color TEXTO_VERDE = new Color(0,255,0);
	
	public BotaoCampo(Campo campo) {
		this.campo= campo;
		setBackground(BG_PADRAO);
		setOpaque(true);
		setBorder(BorderFactory.createBevelBorder(0));
		
		addMouseListener(this);
		campo.registrarObservador(this);
	}

	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		switch (evento) {
		case ABRIR:
			aplicarEstiloAbrir();
			break;
		case MARCAR:
			aplicarEstiloMarcar();
			break;
		case EXPLODIR:
			aplicarEstiloExplodir();
			break;
			
		default:
			aplicarEstiloPadrao();
		}		
	}

	private void aplicarEstiloPadrao() {
		setBackground(BG_PADRAO);
		setOpaque(true);
		setBorder(BorderFactory.createBevelBorder(0));
		setText("");
	}

	private void aplicarEstiloExplodir() {		
		setBackground(BG_EXPLODIR);
		setForeground(Color.WHITE);
		setText(" ! ");
		
		}
		
	

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCAR);
		setForeground(Color.BLACK);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setText("M");
	}

	private void aplicarEstiloAbrir() {		
		
		
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		if(campo.isMinado()) {
			setBackground(BG_EXPLODIR);
			setText("X");
			return;
			
		}
		
		switch (campo.minasNaVizinhaca()) {
		case 1: 
			setForeground(TEXTO_VERDE);
			break;
		case 2: 
			setForeground(Color.BLUE);
			break;
		case 3: 
			setForeground(Color.BLACK);
			break;
		case 4: 
		case 5: 
		case 6:	
			setForeground(Color.RED);
			break;		
		default:
			setForeground(Color.PINK);;
		}
		String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhaca() + "": "";
		setText(valor);
	}
	
	// EVENTOS DO MOUSE
	
	public void mousePressed(MouseEvent e) {	
		if(e.getButton()==1) {
			campo.abrir();
		}else {
			campo.alternarQuadrado();
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}		
}
