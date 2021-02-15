package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import static javax.swing.JOptionPane.showMessageDialog;
class SayHello extends TimerTask {
    public void run() {
        System.out.println("5 second left!");
    }
}

public class App implements ActionListener {
    Guiframe gui = new Guiframe();
    Mssqltojtable mssql = new Mssqltojtable();
    StaticConst sc = new StaticConst();
    String murl;
    boolean nodata;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new SayHello(), 0, 5000);
        App myapp = new App();
        myapp.go();
    }

    public void mcreateurl() {
        murl = "jdbc:sqlserver://"+gui.fieldsqlsrv.getText().trim()+ ":" +gui.fieldport.getText().trim();
        murl += ";databaseName=" + gui.fielddatabase.getText().trim();
        murl += ";user=" + gui.fieldusername.getText().trim() + ";password=" + gui.fieldpass.getText();
        mssql.createsqlurl(murl);
    }

    public void go() {
        gui.go();
        gui.fieldsqlsrv.setText(sc.msqlsrv);
        gui.fieldport.setText(sc.mport);
        gui.fielddatabase.setText(sc.mdb);
        gui.fieldusername.setText(sc.musr);
        gui.fieldpass.setText(sc.mpass);
        mcreateurl();
        gui.buttoncon.addActionListener(this);
        gui.buttonrunsql.addActionListener(this);
        gui.buttongetver.addActionListener(this);
        gui.buttonlastlog.addActionListener(this);
        gui.buttonactusr.addActionListener(this);
        gui.buttongetinfo.addActionListener(this);
        gui.buttongetdb.addActionListener(this);
    }

    public void prodata(){
        nodata = false;
        if (gui.fieldsqlsrv.getText().trim().isEmpty()) {
            showMessageDialog(null, sc.msgsqlsrv);
            nodata = true;
        }
        if (gui.fieldport.getText().trim().isEmpty()) {
            gui.fieldport.setText("1433");
        }
        if (gui.fielddatabase.getText().trim().isEmpty()) {
            showMessageDialog(null, sc.msgdb);
            nodata = true;
        }
        if (gui.fieldusername.getText().trim().isEmpty()) {
            showMessageDialog(null, sc.msgusrname);
            nodata = true;
        }
        if (gui.fieldpass.getText().trim().isEmpty()) {
            showMessageDialog(null, sc.msgusrpass);
            nodata = true;
        }
    }

    public void actionPerformed(ActionEvent event) {
        prodata();
        if (!nodata) {
            mcreateurl();
            if (mssql.testconnection()) {
                if (event.getSource() == gui.buttoncon) {
                    gui.textareabottom.append("Connection complete !");
                }
                if (event.getSource() == gui.buttonrunsql) {
                    gui.textareabottom.append(mssql.runsqlquery(gui.textareacentr.getText()));
                }
                if (event.getSource() == gui.buttongetver) {
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqlgetver));
                }
                if (event.getSource() == gui.buttonlastlog) {
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqllastlog));
                }
                if (event.getSource() == gui.buttongetdb) {
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqlgetdb));
                }
                if (event.getSource() == gui.buttonactusr) {
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqlactusr));
                }
                if (event.getSource() == gui.buttongetinfo) {
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqlgetinfo1));
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqlgetinfo2));
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqlgetinfo3));
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqlgetinfo4));
                    gui.textareabottom.append(mssql.runsqlquery(sc.sqlgetinfo5));
                }
            }
        }
    }
}

