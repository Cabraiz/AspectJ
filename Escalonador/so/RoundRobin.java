package so;

import java.util.*;
import Beans.*;

/**
 * @author Mateus
 */
public class RoundRobin extends CreateFather {

	java.util.Random rd = new Random();
	public static boolean Apto_Exe = false;
	public static boolean Exe_Verify = true;
	/**
	 * public static boolean Exe_Verify = true;
	 */
	public int quantum = 0;
	/**
	 * (2/20)
	 */
	int core;
	Thread threadGo = new Thread();
	Thread threadBack = new Thread();
	/**
	 * Variables declaration - do not modify
	 */
	public javax.swing.JPanel Apto;
	public javax.swing.JComboBox<String> AptoLista;
	public javax.swing.JPanel AptoPai;
	public javax.swing.JPanel Exe;
	public javax.swing.JComboBox<String> ExeLista;
	public javax.swing.JPanel ExePai;
	Collection<Processo> AptoProcessoLista = new ArrayList<>();
	Collection<Processo> ExeProcessoLista = new ArrayList<>();

	public RoundRobin() {
		// TODO - implement RoundRobin.RoundRobin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param i
	 * @param paiJPanel
	 * @param processoLista
	 * @param p
	 * @param b
	 */
	public void Initiate(int i, javax.swing.JPanel paiJPanel, java.util.ArrayList<Processo> processoLista, javax.swing.JPanel p, boolean b) {
		// TODO - implement RoundRobin.Initiate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param js
	 * @param AptoProcessoLista
	 */
	public void AddPags(javax.swing.JComboBox js, java.util.ArrayList<Processo> AptoProcessoLista) {
		// TODO - implement RoundRobin.AddPags
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param b
	 */
	public boolean Change(boolean b) {
		// TODO - implement RoundRobin.Change
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param aptoLista
	 * @param exeLista
	 */
	public void Run(java.util.ArrayList<Processo> aptoLista, java.util.ArrayList<Processo> exeLista) {
		// TODO - implement RoundRobin.Run
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		// TODO - implement RoundRobin.initComponents
		throw new UnsupportedOperationException();
	}

	/**
	 * </editor-fold>
	 * @param evt
	 */
	private void AptoListaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO - implement RoundRobin.AptoListaActionPerformed
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param evt
	 */
	private void ExeListaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO - implement RoundRobin.ExeListaActionPerformed
		throw new UnsupportedOperationException();
	}

}