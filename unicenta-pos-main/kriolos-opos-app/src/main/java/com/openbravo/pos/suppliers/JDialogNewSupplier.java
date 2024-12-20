//    KriolOS POS
//    Copyright (c) 2019-2023 KriolOS
//    
//
//     
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
package com.openbravo.pos.suppliers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.MessageInf;
import com.openbravo.data.loader.LocalRes;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.user.DirtyManager;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.DataLogicSales;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JFrame;

public class JDialogNewSupplier extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    
    private DataLogicSuppliers dlSupplier;
    private DataLogicSales dlSales;
    private TableDefinition tsuppliers;
    private SupplierInfoExt selectedSupplier;
    private SuppliersView suppliersView;
    
    /** Creates new form quick New Supplier
     * @param parent */
    protected JDialogNewSupplier(java.awt.Frame parent) {
        super(parent, true);
    }
    
    /** Creates new form quick New Supplier
     * @param parent */
    protected JDialogNewSupplier(java.awt.Dialog parent) {
        super(parent, true);
    } 
    
    private void init(AppView app) {

        dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");
        dlSupplier = (DataLogicSuppliers) app.getBean("com.openbravo.pos.suppliers.DataLogicSuppliers");
        tsuppliers = dlSupplier.getTableSuppliers();

        initComponents();        
        
        DirtyManager dirty = new DirtyManager();
        suppliersView = new SuppliersView(app,dirty);
        suppliersView.writeValueInsert();
        jFormPanel.setLayout(new java.awt.BorderLayout());
        jFormPanel.add(suppliersView, java.awt.BorderLayout.CENTER);
            
        getRootPane().setDefaultButton(m_jBtnOK);

    }
    
     public Object createValue() throws BasicException {
        return suppliersView.createValue();
    }

    
    public static JDialogNewSupplier getDialog(Component parent,AppView app) {
         
        Window window = getWindow(parent);
        
        JDialogNewSupplier quicknewsupplier;        
        
        if (window instanceof Frame) { 
            quicknewsupplier = new JDialogNewSupplier((Frame) window);
        } else {
            quicknewsupplier = new JDialogNewSupplier((Dialog) window);
        }
        
        quicknewsupplier.init(app);         
        
        return quicknewsupplier;
    } 
    
    protected static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window)parent;
        } else {
            return getWindow(parent.getParent());
        }
    }
    
    public SupplierInfoExt getSelectedSupplier() {
        return selectedSupplier;
    }
    
   
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        m_jBtnCancel = new javax.swing.JButton();
        m_jBtnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("label.supplier")); // NOI18N
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setResizable(false);

        jFormPanel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jFormPanel.setPreferredSize(new java.awt.Dimension(660, 310));
        jFormPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jFormPanel, java.awt.BorderLayout.NORTH);
        jFormPanel.getAccessibleContext().setAccessibleName("");

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        m_jBtnCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        m_jBtnCancel.setText(AppLocal.getIntString("button.cancel")); // NOI18N
        m_jBtnCancel.setFocusPainted(false);
        m_jBtnCancel.setFocusable(false);
        m_jBtnCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnCancel.setPreferredSize(new java.awt.Dimension(80, 45));
        m_jBtnCancel.setRequestFocusEnabled(false);
        m_jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(m_jBtnCancel);

        m_jBtnOK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBtnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        m_jBtnOK.setText(AppLocal.getIntString("button.ok")); // NOI18N
        m_jBtnOK.setFocusPainted(false);
        m_jBtnOK.setFocusable(false);
        m_jBtnOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnOK.setPreferredSize(new java.awt.Dimension(80, 45));
        m_jBtnOK.setRequestFocusEnabled(false);
        m_jBtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnOKActionPerformed(evt);
            }
        });
        jPanel2.add(m_jBtnOK);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(628, 455));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jBtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnOKActionPerformed
        try {
            Object supplier = createValue() ;  
            String m_oId = ((Object[] )supplier)[0].toString();
            
            int status = tsuppliers.getInsertSentence().exec(supplier);
            
            if (status > 0){
                selectedSupplier =  dlSales.loadSupplierExt(m_oId);
                dispose();
            }else{
                MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE, 
                       LocalRes.getIntString("message.nosave"), "Error save");
               msg.show(this);
            }
        } catch (BasicException ex) {
           MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE, 
                   LocalRes.getIntString("message.nosave"), ex);
            msg.show(this);
        }

    }//GEN-LAST:event_m_jBtnOKActionPerformed

    private void m_jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnCancelActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_m_jBtnCancelActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jFormPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton m_jBtnCancel;
    private javax.swing.JButton m_jBtnOK;
    // End of variables declaration//GEN-END:variables
    
}
