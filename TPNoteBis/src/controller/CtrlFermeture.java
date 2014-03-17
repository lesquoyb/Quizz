package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.dao.MaConnection;

public class CtrlFermeture extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		MaConnection.fermer();
		System.exit(0);
	}



}
