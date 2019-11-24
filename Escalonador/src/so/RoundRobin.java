/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import Beans.Processo;
import java.awt.Component;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mateus
 */
public class RoundRobin extends Builder {

    Random rd = new Random();

    public int quantum = 0;//(2/20)

    public RoundRobin() {
        initComponents();
        SaveLogic.quantum = rd.nextInt(19) + 2;
        super.ExeLista = ExeLista;
        super.AptoLista = AptoLista;
        super.FinalizadoLista = FinalizadoLista;
        super.AptoPai = AptoPai;
        super.ExePai = ExePai;
        super.FinalizadoPai = FinalizadoPai;
        super.Apto = Apto;
        super.Exe = Exe;
        super.Finalizado = Finalizado;
    }

    public void Run(ArrayList<Processo> aptoLista, ArrayList<Processo> exeLista) {
            threadBack = new Thread("threadBack") {
                @Override
                public void run() {
                    while (true) {
                        while (Apto_Exe) {
                            if (Repaint) {
                                RunPaint();
                            }
                            try {
                                sleep(100);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };
            threadBack.start();

            threadGo = new Thread("threadGo") {
                @Override
                public void run() {
                    while (true) {
                        while (Apto_Exe) {
                            for (int i = 0; exeLista.size() > i && aptoLista.size() > i; i++) {
                                Processo p = aptoLista.get(0);
                                for (int j = 0; j < exeLista.size(); j++) {
                                    long nowTime = System.currentTimeMillis();
                                    if (p.deadline.getTime() < nowTime) {
                                        FinalizadoProcessoLista.add(p);
                                        aptoLista.remove(p);
                                        break;
                                    }
                                    if (exeLista.get(j).ID == 0) {
                                        exeLista.set(j, new Processo(p.ID, p.exe,
                                                p.deadline, p.prior, nowTime, nowTime));
                                        aptoLista.remove(0);
                                        break;
                                    }
                                }
                            }

                            for (Processo p : exeLista) {
                                if (p.createTime != 0) {
                                    long nowTime = System.currentTimeMillis();
                                    double runTime = (double) (nowTime - p.markerTime) / 1000;

                                    if (nowTime > p.createTime + SaveLogic.quantum * 1000 || p.exe < 0) {
                                        if (p.exe < 0) {
                                            FinalizadoProcessoLista.add(p);
                                            exeLista.set(exeLista.indexOf(p), new Processo());
                                        } else {
                                            aptoLista.add(new Processo(p.ID, p.exe - runTime,
                                                    p.deadline, p.prior, p.createTime));
                                            exeLista.set(exeLista.indexOf(p), new Processo());
                                        }
                                    } else {
                                        exeLista.set(exeLista.indexOf(p),
                                                new Processo(p.ID, p.exe - runTime,
                                                        p.deadline, p.prior, p.createTime, nowTime));
                                    }
                                }
                            }

                        }
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            };
            threadGo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AptoPai = new javax.swing.JPanel();
        Apto = new javax.swing.JPanel();
        AptoLista = new javax.swing.JComboBox<>();
        ExePai = new javax.swing.JPanel();
        Exe = new javax.swing.JPanel();
        ExeLista = new javax.swing.JComboBox<>();
        FinalizadoPai = new javax.swing.JPanel();
        Finalizado = new javax.swing.JPanel();
        FinalizadoLista = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));

        AptoPai.setBorder(javax.swing.BorderFactory.createTitledBorder("Aptos"));

        Apto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Apto.setName(""); // NOI18N
        Apto.setPreferredSize(new java.awt.Dimension(50, 40));
        Apto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AptoMousePressedPri(evt);
            }
        });
        Apto.setLayout(new java.awt.GridLayout(1, 0));

        AptoLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AptoLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pag 1" }));
        AptoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AptoListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AptoPaiLayout = new javax.swing.GroupLayout(AptoPai);
        AptoPai.setLayout(AptoPaiLayout);
        AptoPaiLayout.setHorizontalGroup(
            AptoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AptoPaiLayout.createSequentialGroup()
                .addComponent(Apto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(AptoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        AptoPaiLayout.setVerticalGroup(
            AptoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(AptoPaiLayout.createSequentialGroup()
                .addGroup(AptoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Apto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AptoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        ExePai.setBorder(javax.swing.BorderFactory.createTitledBorder("Executando"));

        Exe.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Exe.setName(""); // NOI18N
        Exe.setPreferredSize(new java.awt.Dimension(50, 40));
        Exe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExeMousePressed(evt);
            }
        });
        Exe.setLayout(new java.awt.GridLayout(1, 0));

        ExeLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ExeLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pag 1" }));
        ExeLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExeListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExePaiLayout = new javax.swing.GroupLayout(ExePai);
        ExePai.setLayout(ExePaiLayout);
        ExePaiLayout.setHorizontalGroup(
            ExePaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExePaiLayout.createSequentialGroup()
                .addComponent(Exe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(ExeLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ExePaiLayout.setVerticalGroup(
            ExePaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExePaiLayout.createSequentialGroup()
                .addGroup(ExePaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Exe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExeLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        FinalizadoPai.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizados"));

        Finalizado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Finalizado.setName(""); // NOI18N
        Finalizado.setPreferredSize(new java.awt.Dimension(50, 40));
        Finalizado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FinalizadoMousePressedPri(evt);
            }
        });
        Finalizado.setLayout(new java.awt.GridLayout(1, 0));

        FinalizadoLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FinalizadoLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pag 1" }));
        FinalizadoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizadoListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FinalizadoPaiLayout = new javax.swing.GroupLayout(FinalizadoPai);
        FinalizadoPai.setLayout(FinalizadoPaiLayout);
        FinalizadoPaiLayout.setHorizontalGroup(
            FinalizadoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FinalizadoPaiLayout.createSequentialGroup()
                .addComponent(Finalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(FinalizadoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        FinalizadoPaiLayout.setVerticalGroup(
            FinalizadoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FinalizadoPaiLayout.createSequentialGroup()
                .addGroup(FinalizadoPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Finalizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinalizadoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AptoPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExePai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FinalizadoPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AptoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FinalizadoPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AptoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AptoListaActionPerformed
        for (Component component : AptoPai.getComponents()) {
            if (!(component.equals(AptoLista) || component.equals(Apto))) {
                AptoPai.remove(component);
            }
        }
        //0-1-2 // 1-17
        Initiate((AptoLista.getSelectedIndex() * 16) + 1, AptoPai,
                AptoProcessoLista, Apto, true);
    }//GEN-LAST:event_AptoListaActionPerformed

    private void ExeListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExeListaActionPerformed
        for (Component component : ExePai.getComponents()) {
            if (!(component.equals(ExeLista) || component.equals(Exe))) {
                ExePai.remove(component);
            }
        }
        //0-1-2 // 1-17
        Initiate((ExeLista.getSelectedIndex() * 16) + 1, ExePai,
                ExeProcessoLista, Exe, false);
    }//GEN-LAST:event_ExeListaActionPerformed

    private void AptoMousePressedPri(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AptoMousePressedPri
        AptoMousePressed(evt);
    }//GEN-LAST:event_AptoMousePressedPri

    private void ExeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExeMousePressed
        AptoMousePressed(evt);
    }//GEN-LAST:event_ExeMousePressed

    private void FinalizadoMousePressedPri(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinalizadoMousePressedPri
        AptoMousePressed(evt);
    }//GEN-LAST:event_FinalizadoMousePressedPri

    private void FinalizadoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizadoListaActionPerformed
        for (Component component : FinalizadoPai.getComponents()) {
            if (!(component.equals(FinalizadoLista) || component.equals(Finalizado))) {
                FinalizadoPai.remove(component);
            }
        }
        Initiate((FinalizadoLista.getSelectedIndex() * 16) + 1, FinalizadoPai,
                FinalizadoProcessoLista, Finalizado, true);
    }//GEN-LAST:event_FinalizadoListaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Apto;
    public javax.swing.JComboBox<String> AptoLista;
    public javax.swing.JPanel AptoPai;
    public javax.swing.JPanel Exe;
    public javax.swing.JComboBox<String> ExeLista;
    public javax.swing.JPanel ExePai;
    public javax.swing.JPanel Finalizado;
    public javax.swing.JComboBox<String> FinalizadoLista;
    public javax.swing.JPanel FinalizadoPai;
    // End of variables declaration//GEN-END:variables
}
