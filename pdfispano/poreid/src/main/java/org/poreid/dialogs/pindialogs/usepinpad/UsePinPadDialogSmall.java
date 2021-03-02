/*
 * The MIT License
 *
 * Copyright 2014, 2015, 2016 Rui Martinho (rmartinho@gmail.com), António Braz (antoniocbraz@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.poreid.dialogs.pindialogs.usepinpad;

import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import org.poreid.common.Util;
import org.poreid.config.POReIDConfig;

/**
 *
 * @author POReID
 */
public class UsePinPadDialogSmall extends javax.swing.JDialog {    
    private final String pinLabel;
    private Image image;
    private final ResourceBundle bundle;
    private final PinOperation pinOp;
    
    /**
     * Creates new form UsePinPadDialog
     * @param pinOp operação a realizar no pin (verificação / modificação)
     * @param pinLabel Descrição textual do pin
     * @param pinIcon Icone associado ao pin
     * @param locale Linguagem utilizada
     */
    public UsePinPadDialogSmall(PinOperation pinOp, String pinLabel, byte[] pinIcon, Locale locale) {
        super((Dialog)null); 
        
        setIconImages(Util.getIconImages());
        
        this.pinLabel = pinLabel;
        try {
            image = ImageIO.read(new ByteArrayInputStream(pinIcon));
        } catch (IOException ex) {
            /* não acontece nada! */
        }
        this.pinOp = pinOp;
        bundle = POReIDConfig.getBundle(UsePinPadDialog.class.getSimpleName(),locale);
        initComponents();
        
        this.setTitle(MessageFormat.format(bundle.getString("dialog."+pinOp.getOperacao()+".title"), pinLabel));
        this.getAccessibleContext().setAccessibleDescription(MessageFormat.format(bundle.getString("dialog."+pinOp.getOperacao()+".description"),pinLabel));
    }
        
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        jPanel3 = new javax.swing.JPanel();
        labelPin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        background.setPreferredSize(new java.awt.Dimension(410, 262));

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(172, 69));

        labelPin.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        labelPin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPin.setText(MessageFormat.format(bundle.getString("dialog."+pinOp.getOperacao()+".message"),pinLabel));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPin, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(labelPin)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelPin;
    // End of variables declaration//GEN-END:variables
}
