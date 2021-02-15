package org.example;

public class StaticConst {
    static final String msqlsrv = "srv";
    static final String mport = "1433";
    static final String mdb = "Camunda";
    static final String musr = "musr";
    static final String mpass = "pwd";
    static final String msgsqlsrv= "Пустое поле сервер";
    static final String msgdb= "Пустое поле база данных";
    static final String msgusrname= "Пустое поле UserName";
    static final String msgusrpass="Пустое поле UserPassword";
    static final String sqlactusr = "SELECT status,hostname,program_name, DB_NAME(dbid) as DBName, COUNT(dbid) as NumberOfConnections," +
            " loginame as LoginName FROM sys.sysprocesses WHERE dbid > 0 GROUP BY" +
            " dbid, loginame,status,hostname,program_name";
    static final String sqllastlog = "SELECT MAX (login_time) AS[Last Login Time],login_name[Login], max(host_name)" +
            " AS [host], max(program_name) AS [PRG] FROM sys.dm_exec_sessions GROUP BY login_name";
    static final String sqlgetinfo1 = "USE [master] \n" +
            "SELECT value_data as [AccountName], registry_key FROM sys.dm_server_registry " +
            " WHERE registry_key LIKE '%MSSQLSERVER%' AND value_name = 'ObjectName' " +
            " UNION SELECT value_data as [AccountName], registry_key FROM sys.dm_server_registry " +
            " WHERE registry_key LIKE '%SQLSERVERAGENT%' AND value_name = 'ObjectName' ";
    static final String sqlgetinfo2 = "SELECT SERVERPROPERTY('ServerName') AS [Instance Name], " +
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
    static final String sqlgetinfo3 = "SELECT SERVERPROPERTY('ServerName') AS [Instance Name], " +
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
    static final String sqlgetinfo4 = "SELECT distinct(volume_mount_point), " +
            "  total_bytes/1048576 as Size_in_MB, " +
            "  available_bytes/1048576 as Free_in_MB, " +
            "  (select ((available_bytes/1048576* 1.0)/(total_bytes/1048576* 1.0) *100)) as FreePercentage " +
            " FROM sys.master_files AS f CROSS APPLY " +
            "  sys.dm_os_volume_stats(f.database_id, f.file_id) " +
            "group by volume_mount_point, total_bytes/1048576, " +
            "  available_bytes/1048576 order by 1";
    static final String sqlgetinfo5="select p.name as 'Maintenance Plan',p.[description] as 'Description' " +
            ",p.[owner] as 'Plan Owner' ,sp.subplan_name as 'Subplan Name' " +
            ",sp.subplan_description as 'Subplan Description' ,j.name as 'Job Name' " +
            ",j.[description] as 'Job Description'  " +
            "from msdb..sysmaintplan_plans p " +
            "inner join msdb..sysmaintplan_subplans sp " +
            "on p.id = sp.plan_id " +
            "inner join msdb..sysjobs j " +
            "on sp.job_id = j.job_id";
    static final String sqlgetdb = "SELECT name,physical_name,size,FILE_ID FROM sys.master_files";
    static final String sqlgetver="SELECT SERVERPROPERTY( 'MachineName') AS [Machine Name/Server Name] " +
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
