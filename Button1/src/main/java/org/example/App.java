package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class App implements ActionListener {
    Guiframe gui = new Guiframe();
    Mssqltojtable mssql = new Mssqltojtable();
    String msqlsrv;
    String mport;
    String mdb;
    String musr;
    String mpass;
    String murl;
    String sqlactusr;
    String sqllastlog;
    String sqlgetinfo1;
    String sqlgetinfo2;
    String sqlgetinfo3;
    String sqlgetinfo4;
    String sqlgetdb;
    String sqlgetver;


    public static void main(String[] args) {
        App myapp = new App();
        myapp.createconst();
        myapp.go();
    }

    public void createconst() {
        sqlactusr = "SELECT status,hostname,program_name, DB_NAME(dbid) as DBName, COUNT(dbid) as NumberOfConnections," +
                " loginame as LoginName FROM sys.sysprocesses WHERE dbid > 0 GROUP BY" +
                " dbid, loginame,status,hostname,program_name";
        sqllastlog = "SELECT MAX (login_time) AS[Last Login Time],login_name[Login], max(host_name)" +
                " AS [host], max(program_name) AS [PRG] FROM sys.dm_exec_sessions GROUP BY login_name";
        sqlgetinfo1 = "USE [master] \n" +
                " GO \n" +
                "SELECT value_data as [AccountName], registry_key FROM sys.dm_server_registry " +
                " WHERE registry_key LIKE '%MSSQLSERVER%' AND value_name = 'ObjectName' " +
                " UNION SELECT value_data as [AccountName], registry_key FROM sys.dm_server_registry " +
                " WHERE registry_key LIKE '%SQLSERVERAGENT%' AND value_name = 'ObjectName' ";
        sqlgetinfo2 = "SELECT SERVERPROPERTY('ServerName') AS [Instance Name], " +
                "CASE LEFT(CONVERT(VARCHAR, SERVERPROPERTY('ProductVersion')),4) " +
                "WHEN '11.0' THEN 'SQL Server 2012' " +
                "WHEN '12.0' THEN 'SQL Server 2014' " +
                "ELSE 'Newer than SQL Server 2014' " +
                "END AS [Version Build], SERVERPROPERTY ('Edition') AS [Edition], " +
                " SERVERPROPERTY('ProductLevel') AS [Service Pack], CASE SERVERPROPERTY('IsIntegratedSecurityOnly') " +
                "WHEN 0 THEN 'SQL Server and Windows Authentication mode' " +
                "WHEN 1 THEN 'Windows Authentication mode' " +
                "END AS [Server Authentication], CASE SERVERPROPERTY('IsClustered') " +
                "WHEN 0 THEN 'False' " +
                "WHEN 1 THEN 'True' " +
                "END AS [Is Clustered?], " +
                "SERVERPROPERTY('ComputerNamePhysicalNetBIOS') AS [Current Node Name], " +
                "SERVERPROPERTY('Collation') AS [ SQL Collation], " +
                "[cpu_count] AS [CPUs], [physical_memory_kb]/1024 AS [RAM (MB)] FROM [sys].[dm_os_sys_info]";
        sqlgetinfo3 = "SELECT SERVERPROPERTY('ServerName') AS [Instance Name], " +
                " CASE LEFT(CONVERT(VARCHAR, SERVERPROPERTY('ProductVersion')),4) " +
                " WHEN '9.00' THEN 'SQL Server 2005' " +
                " WHEN '10.0' THEN 'SQL Server 2008' " +
                " WHEN '10.5' THEN 'SQL Server 2008 R2' " +
                " END AS [Version Build], " +
                " SERVERPROPERTY ('Edition') AS [Edition], " +
                "         SERVERPROPERTY('ProductLevel') AS [Service Pack], " +
                " CASE SERVERPROPERTY('IsIntegratedSecurityOnly') " +
                " WHEN 0 THEN 'SQL Server and Windows Authentication mode' " +
                " WHEN 1 THEN 'Windows Authentication mode' " +
                " END AS [Server Authentication], " +
                " CASE SERVERPROPERTY('IsClustered') " +
                " WHEN 0 THEN 'False' " +
                " WHEN 1 THEN 'True' " +
                " END AS [Is Clustered?], " +
                " SERVERPROPERTY('ComputerNamePhysicalNetBIOS') AS [Current Node Name], " +
                " SERVERPROPERTY('Collation') AS [ SQL Collation], " +
                " [cpu_count] AS [CPUs], " +
                " [physical_memory_in_bytes]/1048576 AS [RAM (MB)] " +
                " FROM [sys].[dm_os_sys_info]')";
        sqlgetinfo3 = "SELECT distinct(volume_mount_point), " +
                "  total_bytes/1048576 as Size_in_MB, " +
                "  available_bytes/1048576 as Free_in_MB, " +
                "  (select ((available_bytes/1048576* 1.0)/(total_bytes/1048576* 1.0) *100)) as FreePercentage " +
                " FROM sys.master_files AS f CROSS APPLY " +
                "  sys.dm_os_volume_stats(f.database_id, f.file_id) " +
                "group by volume_mount_point, total_bytes/1048576, " +
                "  available_bytes/1048576 order by 1";
        sqlgetinfo4="select p.name as 'Maintenance Plan',p.[description] as 'Description' " +
                ",p.[owner] as 'Plan Owner' ,sp.subplan_name as 'Subplan Name' " +
                ",sp.subplan_description as 'Subplan Description' ,j.name as 'Job Name' " +
                ",j.[description] as 'Job Description'  " +
                "from msdb..sysmaintplan_plans p " +
                "inner join msdb..sysmaintplan_subplans sp " +
                "on p.id = sp.plan_id " +
                "inner join msdb..sysjobs j " +
                "on sp.job_id = j.job_id";
        sqlgetdb = "SELECT name,physical_name,size,FILE_ID FROM sys.master_files";
        sqlgetver="SELECT SERVERPROPERTY( 'MachineName') AS [Machine Name/Server Name] " +
                ",SUBSTRING(@@VERSION ,1,CHARINDEX(')',@@VERSION,1)) AS [Product Version Name] " +
                ",CASE SERVERPROPERTY('IsClustered') " +
                "WHEN 1 THEN  'Clustered' " +
                "ELSE 'Not Clustered' " +
                " END  AS [Is Clustered] " +
                ",CASE SERVERPROPERTY('IsHadrEnabled') " +
                "WHEN 1 THEN 'AG Enabled - concider running AG info and health scripts' " +
                "ELSE 'AG Not Enabled' " +
                " END AS AvailabilityGroupEnabled " +
                ",CASE SUBSTRING(CAST(SERVERPROPERTY('productversion') AS VARCHAR(100)) "+
                ", 1,CHARINDEX('.',CAST(SERVERPROPERTY('productversion') AS VARCHAR(100)))+1 ) " +
                "WHEN '6.5'  THEN 'SQL Server 6.5' " +
                "WHEN '7.0'  THEN 'SQL Server 7' " +
                "WHEN '8.0'  THEN 'SQL Server 2000' " +
                "WHEN '9.0'  THEN 'SQL Server 2005' " +
                "WHEN '10.0' THEN 'SQL Server 2008' " +
                "WHEN '10.5' THEN 'SQL Server 2008R2' " +
                "WHEN '11.0' THEN 'SQL Server 2012' " +
                "WHEN '12.0' THEN 'SQL Server 2014' " +
                "WHEN '13.0' THEN 'SQL Server 2016' " +
                "WHEN '14.0' THEN 'SQL Server 2017' " +
                "WHEN '15.0' THEN 'SQL Server 2019' " +
                "ELSE 'Unknown Version' " +
                " END AS [Product Name] " +
                ",SERVERPROPERTY('edition') AS [Edition] " +
                ",SERVERPROPERTY('productlevel') AS [Product Patch Level] " +
                ",SERVERPROPERTY('productversion') AS [Product Version Number] " +
                ",ISNULL(SERVERPROPERTY ('InstanceName'),'Default') AS [Instance Name] " +
                ",SERVERPROPERTY('collation') AS [Collation] " +
                ",CASE " +
                "WHEN SERVERPROPERTY('IsIntegratedSecurityOnly') = 1 THEN 'Integrated security' " +
                "        WHEN SERVERPROPERTY('IsIntegratedSecurityOnly') = 0 THEN 'Mixed Mode Security' " +
                "ELSE 'Unknown' " +
                "     END AS SecurityMode " +
                ",CASE  " +
                "WHEN CONVERT(CHAR(100), SERVERPROPERTY('IsFullTextInstalled')) = 1 THEN 'Full-text is installed' " +
                "        WHEN SERVERPROPERTY('IsFullTextInstalled') = 0 THEN 'Full-text is not installed' " +
                "        WHEN SERVERPROPERTY('IsFullTextInstalled') IS NULL THEN 'Error' " +
                "ELSE 'Unknown' " +
                "     END AS IsFullTextInstalled " +
                ",CONVERT(VARCHAR(100), SERVERPROPERTY('ResourceLastUpdateDateTime')) AS ResourceDatabaseLastUpdDate " +
                ",CONVERT(VARCHAR(100), SERVERPROPERTY('ResourceVersion')) AS ResourceDatabaseVersion " +
                ",CONVERT(VARCHAR(100), SERVERPROPERTY('ProductUpdateReference')) AS ProductUpdateReference " +
                ",CASE SERVERPROPERTY('FilestreamConfiguredLevel') " +
                "WHEN 0 THEN 'No FileStream support' " +
                "WHEN 1 THEN 'Enables FILESTREAM for Transact-SQL access' " +
                "WHEN 2 THEN 'Enables FILESTREAM for Transact-SQL and Win32 streaming access' " +
                "WHEN 3 THEN 'Enabled for T-SQL access, local file system access, and remote file system access ' " +
                "ELSE 'Unknow value returned' " +
                " END AS FileStreamConfiguredLevel " +
                ",CASE SERVERPROPERTY('FilestreamConfiguredLevel') " +
                "WHEN 0 THEN '' " +
                "ELSE SERVERPROPERTY('FilestreamShareName') " +
                " END AS FileStreamShareName";
    }

    public void mcreateurl() {
        msqlsrv = gui.fieldsqlsrv.getText();
        mport = gui.fieldport.getText();
        mdb = gui.fielddatabase.getText();
        musr = gui.fieldusername.getText();
        mpass = gui.fieldpass.getText();
        murl = "jdbc:sqlserver://";
        murl += msqlsrv + ":" + mport + ";databaseName=" + mdb + ";user=" + musr + ";password=" + mpass;
        mssql.createsqlurl(msqlsrv, mport, mdb, musr, mpass);
    }

    public void go() {
        gui.go();
        msqlsrv = "v-hp-bpm-sql01";
        gui.fieldsqlsrv.setText(msqlsrv);
        mport = "1433";
        gui.fieldport.setText(mport);
        mdb = "Camunda";
        gui.fielddatabase.setText(mdb);
        musr = "cam-bpm-sql";
        gui.fieldusername.setText(musr);
        mpass = "pwd_cam-bpm-sql";
        gui.fieldpass.setText(mpass);
        murl = "jdbc:sqlserver://";
        murl += msqlsrv + ":" + mport + ";databaseName=" + mdb + ";user=" + musr + ";password=" + mpass;
        gui.buttoncon.addActionListener(this);
        gui.buttonrunsql.addActionListener(this);
        gui.buttongetver.addActionListener(this);
        gui.buttonlastlog.addActionListener(this);
        gui.buttonactusr.addActionListener(this);
        gui.buttongetinfo.addActionListener(this);
        gui.buttongetdb.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        boolean nodata;
        nodata = false;
        if (gui.fieldsqlsrv.getText().trim().isEmpty()) {
            showMessageDialog(null, "Пустое поле сервер");
            nodata = true;
        }
        if (gui.fieldport.getText().trim().isEmpty()) {
            gui.fieldport.setText("1433");
        }
        if (gui.fielddatabase.getText().trim().isEmpty()) {
            showMessageDialog(null, "Пустое поле база данных");
            nodata = true;
        }
        if (gui.fieldusername.getText().trim().isEmpty()) {
            showMessageDialog(null, "Пустое поле UserName");
            nodata = true;
        }
        if (gui.fieldpass.getText().trim().isEmpty()) {
            showMessageDialog(null, "Пустое поле UserPassword");
            nodata = true;
        }
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
                    gui.textareabottom.append(mssql.runsqlquery(sqlgetver));
                }
                if (event.getSource() == gui.buttonlastlog) {
                    gui.textareabottom.append(mssql.runsqlquery(sqllastlog));
                }
                if (event.getSource() == gui.buttongetdb) {
                    gui.textareabottom.append(mssql.runsqlquery(sqlgetdb));
                }
                if (event.getSource() == gui.buttonactusr) {
                    gui.textareabottom.append(mssql.runsqlquery(sqlactusr));
                }
                if (event.getSource() == gui.buttongetinfo) {
                    gui.textareabottom.append(mssql.runsqlquery(sqlgetinfo1));
                    gui.textareabottom.append(mssql.runsqlquery(sqlgetinfo2));
                    gui.textareabottom.append(mssql.runsqlquery(sqlgetinfo3));
                    gui.textareabottom.append(mssql.runsqlquery(sqlgetinfo4));
                }
            }
        }
    }
}

