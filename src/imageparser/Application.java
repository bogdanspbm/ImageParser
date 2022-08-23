package imageparser;

import java.io.File;
import java.util.List;
import javax.swing.JLabel;
import utils.ExcelEditor;
import static utils.FileChooser.openFile;
import utils.GlobalFunctions;
import static utils.GlobalFunctions.urlToSearchURL;
import utils.URLDatabase;
import utils.URLParser;
import widgets.JURLPanel;

public class Application extends javax.swing.JFrame {

    URLDatabase database = new URLDatabase();
    ExcelEditor editor;
    boolean saveFlag = false;

    public Application() {
        initComponents();
    }

    private void setLineCount() {
        int count = database.getLinesCount();
        tLineCount.setText("Файл содержит " + count + " строк");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bFileSchoose = new javax.swing.JButton();
        bParseURLS = new javax.swing.JButton();
        pProcess = new javax.swing.JPanel();
        sScroll = new javax.swing.JScrollPane();
        pContent = new javax.swing.JPanel();
        tLineCount = new javax.swing.JLabel();
        bSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 300));
        setPreferredSize(new java.awt.Dimension(600, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        bFileSchoose.setText("Выбор файла");
        bFileSchoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFileSchooseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(bFileSchoose, gridBagConstraints);

        bParseURLS.setText("Начать");
        bParseURLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bParseURLSActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(bParseURLS, gridBagConstraints);

        pProcess.setBackground(new java.awt.Color(230, 230, 230));
        pProcess.setLayout(new java.awt.GridBagLayout());

        sScroll.setBackground(new java.awt.Color(230, 230, 230));
        sScroll.setBorder(null);
        sScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sScroll.setToolTipText("");
        sScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pContent.setBackground(new java.awt.Color(230, 230, 230));
        pContent.setMaximumSize(new java.awt.Dimension(10000, 100000));
        pContent.setLayout(new javax.swing.BoxLayout(pContent, javax.swing.BoxLayout.PAGE_AXIS));
        sScroll.setViewportView(pContent);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pProcess.add(sScroll, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        getContentPane().add(pProcess, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        getContentPane().add(tLineCount, gridBagConstraints);

        bSave.setText("Сохранить");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        getContentPane().add(bSave, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bFileSchooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFileSchooseActionPerformed
        database.parseFile(openFile(this));
        setLineCount();
    }//GEN-LAST:event_bFileSchooseActionPerformed

    private void bParseURLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bParseURLSActionPerformed
        File outputFile = openFile(this);
        editor = new ExcelEditor(outputFile.getAbsolutePath());
        startParsingURLs();
    }//GEN-LAST:event_bParseURLSActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        saveFlag = true;
    }//GEN-LAST:event_bSaveActionPerformed

    private void startParsingURLs() {

        if (database.getURLs() != null) {
            Runnable task = new Runnable() {
                public void run() {
                    for (int i = editor.getLastRow(); i < database.getURLs().size(); i++) {
                        
                        tLineCount.setText("Обработано " + (i + 1) + " / " + database.getURLs().size());
                        
                        String url = database.getURLs().get(i);
                        URLParser parser = new URLParser(url);

                        boolean flag = parser.parse();
                        pContent.add(new JURLPanel(url, flag));
                        editor.addRow(GlobalFunctions.getRowByURL(url, flag));

                        if (saveFlag && editor != null) {
                            saveFlag = false;
                            editor.saveFile();
                            pContent.add(new JURLPanel("Файл сохранен", true));
                        }

                        pContent.updateUI();
                    }
                    editor.saveFileAndClose();
                }

            };
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFileSchoose;
    private javax.swing.JButton bParseURLS;
    private javax.swing.JButton bSave;
    private javax.swing.JPanel pContent;
    private javax.swing.JPanel pProcess;
    private javax.swing.JScrollPane sScroll;
    private javax.swing.JLabel tLineCount;
    // End of variables declaration//GEN-END:variables
}
