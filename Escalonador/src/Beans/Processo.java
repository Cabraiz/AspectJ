/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Mateus
 */
public class Processo {

    public int ID;
    public double exe;//(4/20)
    public Timestamp deadline;//(4/20)
    public long createTime;
    public int prior;//(0/3) 

    public long markerTime;

    Random rd = new Random();

    public Processo() {
    }

    public Processo(int ID, double execucao, Timestamp deadline, int prioridade, long createTime, long markerTime) {
        this.ID = ID;
        this.exe = execucao;
        this.deadline = deadline;
        this.createTime = createTime;
        this.prior = prioridade;
        this.markerTime = markerTime;
    }

    public Processo(int ID) {
        this.ID = ID;
        this.exe = rd.nextInt(17) + 4;

        int sec = rd.nextInt(17) + 4;

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Timestamp(System.currentTimeMillis()).getTime());
        cal.add(Calendar.SECOND, sec);

        this.deadline = new Timestamp(cal.getTime().getTime());

        this.prior = rd.nextInt(4);

        this.createTime = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public Processo(int ID, double execucao, Timestamp deadline, int prioridade, long createTime) {
        this.ID = ID;

        this.exe = execucao;

        this.deadline = deadline;

        this.prior = prioridade;

        this.createTime = createTime;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Random getRd() {
        return rd;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }

    public double getExe() {
        return exe;
    }

    public void setExe(double exe) {
        this.exe = exe;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public int getPrioridade() {
        return prior;
    }

    public void setPrioridade(int prioridade) {
        this.prior = prioridade;
    }

}
