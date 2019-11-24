/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import Beans.Processo;
import Image.Convert_Img;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateus
 */
public class Main extends javax.swing.JFrame {

    Thread threadTime = new Thread();
    SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S a");

    Convert_Img img = new Convert_Img();
    Random rd = new Random();
    int core = 0;

    Builder builder;

    public Main() {
        initComponents();
        builder = rRobin;

        SetInfoIDJpanel(rRobin);
        SetInfoIDJpanel(SJF_Imp);
        SetInfoIDJpanel(LTG_Imp);

        Radomizar();
        Initiate(rRobin);
        Repaint(0);
        front.moveToFront(rRobin);
        IconSet();
        TimeUpdate();
    }

    public final void Radomizar() {
        core = rd.nextInt(64) + 1;
        rRobin.core = core;
        for (int i = 0; i < core; i++) {
            rRobin.ExeProcessoLista.add(new Processo());
        }
        numPro.setText(String.valueOf(core));
        for (int i = 1; i < core * 4; i++) {
            //rRobin.AptoProcessoLista.add(new Processo(rRobin.TOTALID = rRobin.TOTALID + 1));
        }

        core = rd.nextInt(64) + 1;
        SJF_Imp.core = core;
        for (int i = 0; i < core; i++) {
            SJF_Imp.ExeProcessoLista.add(new Processo());
        }
        for (int i = 1; i < core * 4; i++) {
            //SJF_Imp.AptoProcessoLista.add(new Processo(SJF_Imp.TOTALID = SJF_Imp.TOTALID + 1));
        }

        core = rd.nextInt(64) + 1;
        LTG_Imp.core = core;
        for (int i = 0; i < core; i++) {
            LTG_Imp.ExeProcessoLista.add(new Processo());
        }
        for (int i = 1; i < core * 4; i++) {
            //LTG_Imp.AptoProcessoLista.add(new Processo(LTG_Imp.TOTALID = LTG_Imp.TOTALID + 1));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        front = new javax.swing.JLayeredPane();
        LTG_Imp = new so.LTG();
        SJF_Imp = new so.SJF();
        rRobin = new so.RoundRobin();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numPro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelInfoExeTime = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelInfoDeadTime = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabelInfoID = new javax.swing.JLabel();
        PlayPause = new javax.swing.JButton();
        jComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        NumIniProcess = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        front.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        front.setMaximumSize(new java.awt.Dimension(5000, 3000));

        LTG_Imp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        LTG_Imp.setMaximumSize(new java.awt.Dimension(5000, 280));
        LTG_Imp.setMinimumSize(new java.awt.Dimension(0, 280));
        LTG_Imp.setPreferredSize(new java.awt.Dimension(0, 280));

        SJF_Imp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SJF_Imp.setMaximumSize(new java.awt.Dimension(5000, 280));
        SJF_Imp.setMinimumSize(new java.awt.Dimension(0, 280));
        SJF_Imp.setName(""); // NOI18N
        SJF_Imp.setPreferredSize(new java.awt.Dimension(0, 280));

        rRobin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rRobin.setMaximumSize(new java.awt.Dimension(5000, 280));
        rRobin.setMinimumSize(new java.awt.Dimension(0, 280));
        rRobin.setName(""); // NOI18N
        rRobin.setPreferredSize(new java.awt.Dimension(0, 280));

        front.setLayer(LTG_Imp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        front.setLayer(SJF_Imp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        front.setLayer(rRobin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout frontLayout = new javax.swing.GroupLayout(front);
        front.setLayout(frontLayout);
        frontLayout.setHorizontalGroup(
            frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SJF_Imp, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LTG_Imp, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
            .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rRobin, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );
        frontLayout.setVerticalGroup(
            frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SJF_Imp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LTG_Imp, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
            .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rRobin, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cores");

        numPro.setFont(new java.awt.Font("Meiryo", 0, 12)); // NOI18N
        numPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPro.setText("64");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ExeTime");

        jLabelInfoExeTime.setFont(new java.awt.Font("Meiryo", 0, 12)); // NOI18N
        jLabelInfoExeTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoExeTime.setText("64");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DeadTime");

        jLabelInfoDeadTime.setFont(new java.awt.Font("Meiryo", 0, 12)); // NOI18N
        jLabelInfoDeadTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoDeadTime.setText("00:00:000 AM");

        ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setText("ID");

        jLabelInfoID.setFont(new java.awt.Font("Meiryo", 0, 12)); // NOI18N
        jLabelInfoID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoID.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(numPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelInfoID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelInfoDeadTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelInfoExeTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numPro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfoID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfoExeTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfoDeadTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PlayPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlayPauseMousePressed(evt);
            }
        });

        jComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Round Robin", "SJF", "LTG" }));
        jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Criar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Processos Iniciais:");

        NumIniProcess.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NumIniProcess.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        NumIniProcess.setText("20");
        NumIniProcess.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        NumIniProcess.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NumIniProcessFocusLost(evt);
            }
        });
        NumIniProcess.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NumIniProcessKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Meiryo", 1, 12)); // NOI18N
        jLabel5.setText("00:00:000 AM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(front, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(NumIniProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addComponent(front, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addComponent(PlayPause, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumIniProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jComboBox.getSelectedIndex() == 0) {
            rRobin.AptoProcessoLista.add(new Processo(rRobin.TOTALID = rRobin.TOTALID + 1));
            Repaint(0);
        }
        if (jComboBox.getSelectedIndex() == 1) {
            SJF_Imp.AptoProcessoLista.add(new Processo(SJF_Imp.TOTALID = SJF_Imp.TOTALID + 1));
            Repaint(1);
        }
        if (jComboBox.getSelectedIndex() == 2) {
            LTG_Imp.AptoProcessoLista.add(new Processo(LTG_Imp.TOTALID = LTG_Imp.TOTALID + 1));
            Repaint(2);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        //IconSet();
        if (jComboBox.getSelectedIndex() == 0) {
            Repaint(0);
            SaveLogic.Escalonador = 1;
        }
        if (jComboBox.getSelectedIndex() == 1) {
            Repaint(1);
            SaveLogic.Escalonador = 2;
        }
        if (jComboBox.getSelectedIndex() == 2) {
            Repaint(2);
            SaveLogic.Escalonador = 3;
        }
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void NumIniProcessKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumIniProcessKeyTyped
        char enter = evt.getKeyChar();
        if (!(Character.isDigit(enter))) {
            evt.consume();
        }
    }//GEN-LAST:event_NumIniProcessKeyTyped

    private void NumIniProcessFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NumIniProcessFocusLost
        if (NumIniProcess.getText().length() == 0) {
            NumIniProcess.setText("0");
        }
    }//GEN-LAST:event_NumIniProcessFocusLost

    private void PlayPauseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayPauseMousePressed
        if (jComboBox.getSelectedIndex() == 0) {
            InitiateProcess(0);
            //rRobin.Apto_Exe = rRobin.Change(rRobin.Apto_Exe);
            rRobin.Apto_Exe = true;
            rRobin.Run(rRobin.AptoProcessoLista, rRobin.ExeProcessoLista);
        } else if (jComboBox.getSelectedIndex() == 1) {
            InitiateProcess(1);
            //SJF_Imp.Apto_Exe = SJF_Imp.Change(SJF_Imp.Apto_Exe);
            SJF_Imp.Apto_Exe = true;
            SJF_Imp.Run(SJF_Imp.AptoProcessoLista, SJF_Imp.ExeProcessoLista);
        } else if (jComboBox.getSelectedIndex() == 2) {
            InitiateProcess(2);
            //LTG_Imp.Apto_Exe = LTG_Imp.Change(LTG_Imp.Apto_Exe);
            LTG_Imp.Apto_Exe = true;
            LTG_Imp.Run(LTG_Imp.AptoProcessoLista, LTG_Imp.ExeProcessoLista);
        }
        //IconSet();
    }//GEN-LAST:event_PlayPauseMousePressed

    public void Repaint(int index) {
        if (index == 0) {
            if (!rRobin.Repaint) {
                rRobin.setVisible(true);
                rRobin.Repaint = true;
                LTG_Imp.setVisible(false);
                LTG_Imp.Repaint = false;
                SJF_Imp.setVisible(false);
                SJF_Imp.Repaint = false;

                ClearBeforeInitiateStart();

                front.moveToFront(rRobin);
                numPro.setText(String.valueOf(rRobin.core));
                Initiate(rRobin);
            }
        }

        if (index == 1) {
            if (!SJF_Imp.Repaint) {
                rRobin.Repaint = false;
                rRobin.setVisible(false);
                SJF_Imp.Repaint = true;
                SJF_Imp.setVisible(true);
                LTG_Imp.Repaint = false;
                LTG_Imp.setVisible(false);

                ClearBeforeInitiateStart();

                front.moveToFront(SJF_Imp);
                numPro.setText(String.valueOf(SJF_Imp.core));
                Initiate(SJF_Imp);
            }
        }

        if (index == 2) {
            if (!LTG_Imp.Repaint) {
                rRobin.Repaint = false;
                rRobin.setVisible(false);
                SJF_Imp.Repaint = false;
                SJF_Imp.setVisible(false);
                LTG_Imp.Repaint = true;
                LTG_Imp.setVisible(true);

                ClearBeforeInitiateStart();

                front.moveToFront(LTG_Imp);
                numPro.setText(String.valueOf(LTG_Imp.core));
                Initiate(LTG_Imp);
            }
        }
    }

    public void InitiateProcess(int index) {
        if(NumIniProcess.getText().equalsIgnoreCase("0")){
           NumIniProcess.setText("120");
        }
        if (index == 0) {
            for (int i = 0; i < Integer.parseInt(NumIniProcess.getText()); i++) {
                rRobin.AptoProcessoLista.add(new Processo(rRobin.TOTALID = rRobin.TOTALID + 1));
            }
        }

        if (index == 1) {
            for (int i = 0; i < Integer.parseInt(NumIniProcess.getText()); i++) {
                SJF_Imp.AptoProcessoLista.add(new Processo(SJF_Imp.TOTALID = SJF_Imp.TOTALID + 1));
            }
        }

        if (index == 2) {
            for (int i = 0; i < Integer.parseInt(NumIniProcess.getText()); i++) {
                LTG_Imp.AptoProcessoLista.add(new Processo(LTG_Imp.TOTALID = LTG_Imp.TOTALID + 1));
            }
        }
        NumIniProcess.setText("0");
    }

    public void ClearBeforeInitiateStart() {
        ClearBeforeInitiate(rRobin);
        ClearBeforeInitiate(SJF_Imp);
        ClearBeforeInitiate(LTG_Imp);
    }

    public void ClearBeforeInitiate(Builder b) {
        for (Component component : b.AptoPai.getComponents()) {
            if (!(component.equals(b.AptoLista) || component.equals(b.Apto))) {
                b.AptoPai.remove(component);
            }
        }

        for (Component component : b.ExePai.getComponents()) {
            if (!(component.equals(b.ExeLista) || component.equals(b.Exe))) {
                b.ExePai.remove(component);
            }
        }

        for (Component component : b.FinalizadoPai.getComponents()) {
            if (!(component.equals(b.FinalizadoLista) || component.equals(b.Finalizado))) {
                b.FinalizadoPai.remove(component);
            }
        }
    }

    public void Initiate(Builder b) {
        b.Initiate(b.ExeLista.getSelectedIndex() * 16 + 1,
                b.ExePai, b.ExeProcessoLista,
                b.Exe, false);
        b.Initiate(b.AptoLista.getSelectedIndex() * 16 + 1,
                b.AptoPai, b.AptoProcessoLista,
                b.Apto, true);
        b.Initiate(b.FinalizadoLista.getSelectedIndex() * 16 + 1,
                b.FinalizadoPai, b.FinalizadoProcessoLista,
                b.Finalizado, true);
    }

    public void TimeUpdate() {
        threadTime = new Thread("threadTime") {
            @Override
            public void run() {
                while (true) {
                    String formattedDate = sdf.format(System.currentTimeMillis());
                    jLabel5.setText(formattedDate);
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
        threadTime.start();
    }

    public void SetInfoIDJpanel(Builder b) {
        b.infoDead = jLabelInfoDeadTime;
        b.infoExe = jLabelInfoExeTime;
        b.infoID = jLabelInfoID;
    }

    public void IconSet() {
        if (jComboBox.getSelectedIndex() == 0) {
            PlayPause = img.ScaledImage(PlayPause, rRobin.Apto_Exe);
        }
        if (jComboBox.getSelectedIndex() == 1) {
            PlayPause = img.ScaledImage(PlayPause, SJF_Imp.Apto_Exe);
        }
        if (jComboBox.getSelectedIndex() == 2) {
            PlayPause = img.ScaledImage(PlayPause, LTG_Imp.Apto_Exe);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private so.LTG LTG_Imp;
    private javax.swing.JTextField NumIniProcess;
    private javax.swing.JButton PlayPause;
    private so.SJF SJF_Imp;
    private javax.swing.JLayeredPane front;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelInfoDeadTime;
    private javax.swing.JLabel jLabelInfoExeTime;
    private javax.swing.JLabel jLabelInfoID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel numPro;
    private so.RoundRobin rRobin;
    // End of variables declaration//GEN-END:variables
}
