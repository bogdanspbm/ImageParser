/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package widgets;

/**
 *
 * @author crewd
 */
public class JURLPanel extends javax.swing.JPanel {

    /**
     * Creates new form JURLPanel
     */
    public JURLPanel(String URL, boolean status) {
        initComponents();
        tName.setText(URL);
        if(status){
            tBanned.setVisible(false);
        } else {
            tOk.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tName = new javax.swing.JLabel();
        tOk = new javax.swing.JLabel();
        tBanned = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(2147483647, 20));
        setMinimumSize(new java.awt.Dimension(98, 20));
        setPreferredSize(new java.awt.Dimension(300, 20));
        setLayout(new java.awt.GridBagLayout());

        tName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(tName, gridBagConstraints);

        tOk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tOk.setForeground(new java.awt.Color(0, 153, 0));
        tOk.setText("OK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(tOk, gridBagConstraints);

        tBanned.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tBanned.setForeground(new java.awt.Color(204, 0, 0));
        tBanned.setText("BANNED");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(tBanned, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel tBanned;
    private javax.swing.JLabel tName;
    private javax.swing.JLabel tOk;
    // End of variables declaration//GEN-END:variables
}
