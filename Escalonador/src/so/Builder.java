/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import Beans.Processo;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Mateus
 */
public abstract class Builder extends javax.swing.JPanel {

    JPanel ExePai;
    JPanel Exe;
    JPanel Apto;
    JPanel AptoPai;
    JPanel Finalizado;
    JPanel FinalizadoPai;
    JComboBox ExeLista;
    JComboBox AptoLista;
    JComboBox FinalizadoLista;

    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S a");
    DecimalFormatSymbols dfSymbols = new DecimalFormatSymbols();
    DecimalFormat df = new DecimalFormat();

    int TOTALID = 0;

    Thread threadGo = new Thread();
    Thread threadBack = new Thread();

    ArrayList<Processo> AptoProcessoLista = new ArrayList<>();
    ArrayList<Processo> ExeProcessoLista = new ArrayList<>();
    ArrayList<Processo> FinalizadoProcessoLista = new ArrayList<>();

    public boolean Apto_Exe = false;
    public boolean Repaint = false;

    int diff = 2;

    int core;

    JLabel infoExe;
    JLabel infoDead;
    JLabel infoID;

    boolean drawGreen = false;
    boolean drawRed = false;

    String drawGreenStr = "#66BB6A";
    String drawRedStr = "#E53935";

    double dd;

    public Builder() {
        dfSymbols.setDecimalSeparator('.');
        df.setGroupingUsed(false);
        df = new DecimalFormat("0.00", dfSymbols);
    }

    public void Initiate(int i, JPanel paiJPanel, ArrayList<Processo> processoLista,
            JPanel painel, boolean b) {
        //Booleano 1 - Se é para encher a lista com processos

        Processo p;
        JPanel tempPanel = painel;
        JLabel(painel, 0);
        String k = String.valueOf(i);
        if (processoLista.size() >= i) {
            if (processoLista.get(i - 1).ID != 0) {
                k = PrintExe(processoLista, paiJPanel, 1);
                p = processoLista.get(i - 1);
                if (paiJPanel == FinalizadoPai) {
                    if (p.exe < 0) {
                        painel.setBackground(Color.decode(drawGreenStr));
                    } else {
                        painel.setBackground(Color.decode(drawRedStr));
                    }
                }
                JLabel(painel, p.ID);
            }
        }
        painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                k, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));

        for (int j = 1 + i; j < 16 + i; j++) {
            if ((!b && j <= processoLista.size()) || b) {
                if (j <= processoLista.size()) {
                    FinalizadosMethod(paiJPanel, processoLista.get(j - 1));
                }

                k = PrintExe(processoLista, paiJPanel, j);

                if (j % (8 + i) == 0) {
                    //tempPanel = CreateVer(painel, String.valueOf(j));
                    tempPanel = CreateVer(painel, k);
                } else {
                    //tempPanel = CreateHor(tempPanel, String.valueOf(j));
                    tempPanel = CreateHor(tempPanel, k);
                }
                JLabel jl = (JLabel) tempPanel.getComponent(0);

                if (j <= processoLista.size()) {
                    p = processoLista.get(j - 1);
                    if (p.ID != 0) {
                        jl.setText("P" + p.ID);
                    }
                }
                paiJPanel.add(tempPanel);
            }
        }
        AddPags(AptoLista, AptoProcessoLista);
        AddPags(ExeLista, ExeProcessoLista);
        AddPags(FinalizadoLista, FinalizadoProcessoLista);
        revalidate();
        repaint();
    }

    public JPanel CreateHor(JPanel jp, String title) {
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel();

        jp2.setBounds(jp.getBounds().x + jp.getBounds().width, jp.getBounds().y,
                jp.getBounds().width, jp.getBounds().height);

        jp2 = CreateGeneric(jp2, jl2, title);
        return jp2;
    }

    public JPanel CreateVer(JPanel jp, String title) {
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel();

        jp2.setBounds(jp.getBounds().x, jp.getBounds().y + jp.getBounds().height,
                jp.getBounds().width, jp.getBounds().height);

        jp2 = CreateGeneric(jp2, jl2, title);
        return jp2;
    }

    public JPanel CreateGeneric(JPanel jp, JLabel jl, String title) {
        if (drawGreen) {
            jp.setBackground(Color.decode(drawGreenStr));
            drawGreen = false;
        }
        if (drawRed) {
            jp.setBackground(Color.decode(drawRedStr));
            drawRed = false;
        }
        jp.setVisible(true);
        jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                title, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
        jp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AptoMousePressed(evt);
            }
        });
        jp.setLayout(new GridBagLayout());
        jp.add(jl);
        jl.setFont(new java.awt.Font("Tahoma", 0, 12));
        return jp;
    }

    public void AptoMousePressed(java.awt.event.MouseEvent evt) {
        JPanel pan = (JPanel) evt.getSource();
        JLabel jl = (JLabel) pan.getComponent(0);
        if (jl.getText().length() > 0) {
            int k = Integer.parseInt(jl.getText().substring(1, jl.getText().length()));
            infoID.setText(String.valueOf(k));
            ArrayList<Processo> aptoTempList = new ArrayList<>(AptoProcessoLista);
            ArrayList<Processo> exeTempList = new ArrayList<>(ExeProcessoLista);
            ArrayList<Processo> finalizadoTempList = new ArrayList<>(FinalizadoProcessoLista);
            for (Processo p : aptoTempList) {
                if (p.getID() == k) {
                    Write(p);
                }
            }
            for (Processo p : exeTempList) {
                if (p.getID() == k) {
                    Write(p);
                }
            }
            for (Processo p : finalizadoTempList) {
                if (p.getID() == k) {
                    Write(p);
                }
            }
        }
    }

    public String PrintExe(ArrayList<Processo> processoLista, JPanel paiJPanel, int j) {
        String k = String.valueOf(j);
        Processo p;
        if (j <= processoLista.size()) {
            if (paiJPanel == ExePai || paiJPanel == AptoPai) {
                if (SaveLogic.Escalonador == 1 && paiJPanel != AptoPai) {
                    p = processoLista.get(j - 1);
                    if (p.ID != 0) {
                        k = String.valueOf(df.format((dd = System.currentTimeMillis() - p.createTime) / 1000));
                    }
                } else if (SaveLogic.Escalonador == 2) {
                    p = processoLista.get(j - 1);
                    if (p.ID != 0) {
                        k = String.valueOf(df.format(p.exe));
                    }
                } else if (SaveLogic.Escalonador == 3) {
                    p = processoLista.get(j - 1);
                    if (p.ID != 0) {
                        k = String.valueOf(df.format((dd = p.deadline.getTime() - System.currentTimeMillis()) / 1000));
                    }
                }
            }
        }
        return k;
    }

    public void Write(Processo p) {
        infoExe.setText(String.valueOf(df.format(p.getExe())) + "s");
        Date date = new Date(p.getDeadline().getTime());
        String formattedDate = sdf.format(date);
        infoDead.setText(formattedDate);
    }

    public void FinalizadosMethod(JPanel painel, Processo p) {
        if (painel == FinalizadoPai) {
            if (p.exe < 0) {
                drawGreen = true;
            } else {
                drawRed = true;
            }
        }
    }

    public void JLabel(JPanel jp, int i) {
        JLabel jl;
        if (jp.getComponentCount() == 0) {
            jl = new JLabel();
            jl.setFont(new java.awt.Font("Tahoma", 0, 12));
            jp.add(jl);
            jl.setHorizontalAlignment(SwingConstants.CENTER);
        } else {
            jl = (JLabel) jp.getComponent(0);
        }
        if (i != 0) {
            jl.setText("P" + i);
        } else {
            jl.setText("");
        }
    }

    public void AddPags(JComboBox js, ArrayList<Processo> ProcessoLista) {
        int i = ProcessoLista.size();
        while (js.getItemCount() * 16 < i) {
            js.addItem("Pag " + (js.getItemCount() + 1));
        }
    }

    public boolean Change(boolean b) {
        if (!b) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    public void RunPaint() {
        for (Component component : AptoPai.getComponents()) {
            if (!(component.equals(AptoLista) || component.equals(Apto))) {
                AptoPai.remove(component);
            }
        }

        for (Component component : ExePai.getComponents()) {
            if (!(component.equals(ExeLista) || component.equals(Exe))) {
                ExePai.remove(component);
            }
        }

        for (Component component : FinalizadoPai.getComponents()) {
            if (!(component.equals(FinalizadoLista) || component.equals(Finalizado))) {
                FinalizadoPai.remove(component);
            }
        }

        ArrayList<Processo> exeTempList = new ArrayList<>(ExeProcessoLista);
        ArrayList<Processo> aptoTempList = new ArrayList<>(AptoProcessoLista);
        ArrayList<Processo> finalizadoTempList = new ArrayList<>(FinalizadoProcessoLista);

        try {
            SwingUtilities.invokeAndWait(() -> {

                Initiate(FinalizadoLista.getSelectedIndex() * 16 + 1, FinalizadoPai,
                        finalizadoTempList, Finalizado, true);
                Initiate((ExeLista.getSelectedIndex() * 16) + 1, ExePai,
                        exeTempList, Exe, false);
                Initiate((AptoLista.getSelectedIndex() * 16) + 1, AptoPai,
                        aptoTempList, Apto, true);
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
