/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

/**
 *
 * @author Mateus
 */
public class SaveLogic {
    static int Escalonador = 1;
    
    static int quantum;

    public int getEscalonador() {
        return Escalonador;
    }

    public void setEscalonador(int Escalonador) {
        this.Escalonador = Escalonador;
    }

    
    public static int getQuantum() {
        return quantum;
    }

    public static void setQuantum(int quantum) {
        SaveLogic.quantum = quantum;
    }
    
    
}
