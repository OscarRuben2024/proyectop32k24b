/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.Boletas;
import controlador.ProcesoTiposDeMonedas;
import controlador.TesoreriaP;
import controlador.TiposDeMoneda;

import controlador.TiposDePagos;
import controlador.clsBitacora;
import controlador.clsUsuarioConectado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.BoletasDAO;
import modelo.Conexion;
import modelo.ProcesoTiposDeMonedasDAO;
import modelo.TiposDeMonedaDAO;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kevin
 */
public class ProcesoTiposDeMoneda extends javax.swing.JInternalFrame {

    int codigoAplicacion = 3620;
    clsBitacora Auditoria = new clsBitacora();
    
    public ProcesoTiposDeMoneda() {
        initComponents();
        txtNBoleta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                buscarTotal();
            }
        });
        btnImprimir.setEnabled(false);
    }
    
    public void buscarTotal(){
        //Se busca la boleta ingresada
        Boletas boletaAConsultar = new Boletas();
        BoletasDAO boletasDAO = new BoletasDAO();       
        boletaAConsultar.setCodigoBoleta(txtNBoleta.getText());
        boletaAConsultar = boletasDAO.query(boletaAConsultar);
        
        //Se busca el tipo de pago para calcular el monto a pagar
        TiposDePagos tiposDePagosAConsultar = new TiposDePagos();
        ProcesoTiposDeMonedasDAO procesotiposdepagoDAO = new ProcesoTiposDeMonedasDAO();
        tiposDePagosAConsultar.setNombrePago(boletaAConsultar.getTipoDePago());
        tiposDePagosAConsultar = procesotiposdepagoDAO.query(tiposDePagosAConsultar);
        
        //Se busca la moneda más adecuada para el pago
        TiposDeMoneda monedaAConsultar = new TiposDeMoneda();
        TiposDeMonedaDAO tiposDeMonedaDAO = new TiposDeMonedaDAO();
        monedaAConsultar.setIdMoneda(1);
        monedaAConsultar = tiposDeMonedaDAO.query(monedaAConsultar);
        
        // Verificamos si el valor es null
        if (tiposDePagosAConsultar.getcantidadPago() == null) {
            lbTotal.setText("0");
        } else {
            lbTotal.setText(tiposDePagosAConsultar.getcantidadPago() + " " + monedaAConsultar.getNombreMoneda());
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

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboxMTarjeta = new javax.swing.JComboBox<>();
        cboxATarjeta = new javax.swing.JComboBox<>();
        btnTransaccion = new javax.swing.JButton();
        txtNTarjeta = new javax.swing.JTextField();
        txtCVVTarjeta = new javax.swing.JTextField();
        txtEstadoTransaccion = new javax.swing.JTextField();
        btnTransaccion1 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtNBoleta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Transacciones con tarjeta de crédito y débito");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Total");

        lbTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTotal.setText("0");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Número de tarjeta");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("CVV");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Fecha de expiración");

        cboxMTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxMTarjeta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        cboxATarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxATarjeta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        btnTransaccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTransaccion.setText("Realizar transacción");
        btnTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccionActionPerformed(evt);
            }
        });

        txtNTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtCVVTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtEstadoTransaccion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnTransaccion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTransaccion1.setText("Ø");
        btnTransaccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaccion1ActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setEnabled(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        txtNBoleta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Número de boleta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCVVTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTransaccion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTransaccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(cboxMTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboxATarjeta, 0, 240, Short.MAX_VALUE)
                                    .addComponent(txtEstadoTransaccion)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbTotal)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(jLabel1))
                        .addComponent(jLabel7)))
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbTotal)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCVVTarjeta)
                    .addComponent(txtNTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxMTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxATarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstadoTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransaccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTransaccion1))
                .addGap(18, 18, 18)
                .addComponent(btnImprimir)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccionActionPerformed
        // TODO add your handling code here:
        TesoreriaP TesoreriaAConsultar = new TesoreriaP();
        TesoreriaAConsultar.setNumeroTarjeta(txtNTarjeta.getText());
        TesoreriaAConsultar.setVccTarjeta(txtCVVTarjeta.getText());
        TesoreriaAConsultar.setMesTarjeta((String) cboxMTarjeta.getSelectedItem());
        TesoreriaAConsultar.setAnoTarjeta((String) cboxATarjeta.getSelectedItem());
        //TesoreriaPDAO.insert(TesoreriaAConsultar);
        
        //Se busca la boleta ingresada
        Boletas boletaAConsultar = new Boletas();
        BoletasDAO boletasDAO = new BoletasDAO();       
        boletaAConsultar.setCodigoBoleta(txtNBoleta.getText());
        boletaAConsultar = boletasDAO.query(boletaAConsultar);
        
        //Se busca el tipo de pago para calcular el monto a pagar
        TiposDePagos tiposDePagosAConsultar = new TiposDePagos();
        ProcesoTiposDeMonedasDAO procesotiposdepagoDAO = new ProcesoTiposDeMonedasDAO();
        tiposDePagosAConsultar.setNombrePago(boletaAConsultar.getTipoDePago());
        tiposDePagosAConsultar = procesotiposdepagoDAO.query(tiposDePagosAConsultar);
        
        //Se busca la moneda más adecuada para el pago
        TiposDeMoneda monedaAConsultar = new TiposDeMoneda();
        TiposDeMonedaDAO tiposDeMonedaDAO = new TiposDeMonedaDAO();
        monedaAConsultar.setIdMoneda(1);
        monedaAConsultar = tiposDeMonedaDAO.query(monedaAConsultar);
        
        // Validar los datos
        if (txtNTarjeta.getText().length() <= 5 || txtCVVTarjeta.getText().length() != 3 || 
                cboxMTarjeta.getSelectedItem().equals("Seleccionar") || cboxATarjeta.getSelectedItem().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            boolean pago = true;
            if (pago = true) {
                ProcesoTiposDeMonedas pagoAInsertar = new ProcesoTiposDeMonedas();
                pagoAInsertar.setCodigoBoleta(txtNBoleta.getText());
                pagoAInsertar.setNombrePago(boletaAConsultar.getTipoDePago());
                pagoAInsertar.setcantidadPago(tiposDePagosAConsultar.getcantidadPago());    
                pagoAInsertar.setNombreMoneda(monedaAConsultar.getNombreMoneda());
                Auditoria.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "CHECK");  
                procesotiposdepagoDAO.insert(pagoAInsertar);
                txtEstadoTransaccion.setText("Pago recibido");
                btnImprimir.setEnabled(true);
                btnTransaccion1.setEnabled(false);
            } else {
                txtEstadoTransaccion.setText("Pago no recibido");
            }
        }
        Auditoria.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "TX");
    }//GEN-LAST:event_btnTransaccionActionPerformed

    private void btnTransaccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaccion1ActionPerformed
        // Se cancela el pago
        Auditoria.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "TXC");

        txtEstadoTransaccion.setText("Pago cancelado");
        Timer timer = new Timer(3000, new ActionListener() { //Espera 3 segundos antes de cerrar
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose(); // Cierra la JInternalFrame
                    }
                });
                timer.setRepeats(false); // No se repite
                timer.start();
    }//GEN-LAST:event_btnTransaccion1ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        //Se genera un certificado de pago que podemos imprimir o guardar
        Connection conn = null;        
        Map<String, Object> p = new HashMap<>();
        String codigobuscado = txtNBoleta.getText();
        p.put("codigo_boleta", codigobuscado);
        JasperReport report;
        JasperPrint print;

        try {
            conn = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/reportes/rptCertificadoPagos.jrxml");
	    print = JasperFillManager.fillReport(report, p, conn);
            JasperViewer view = new JasperViewer(print, false);
	    view.setTitle("Certificado de pago");
            view.setVisible(true);
            Auditoria.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "RPT-C");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnTransaccion;
    private javax.swing.JButton btnTransaccion1;
    private javax.swing.JComboBox<String> cboxATarjeta;
    private javax.swing.JComboBox<String> cboxMTarjeta;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JTextField txtCVVTarjeta;
    private javax.swing.JTextField txtEstadoTransaccion;
    private javax.swing.JTextField txtNBoleta;
    private javax.swing.JTextField txtNTarjeta;
    // End of variables declaration//GEN-END:variables
}
