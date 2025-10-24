# MySQL Database

MySQL includes two components:

1. MySQL Database Server (main engine)
2. MySQL Workbench (client GUI)

### Step 1: Install the MySQL Database Server

[https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)

### Step 2: Install MySQL WorkBench

[https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)

I downloaded version <u>**MySQL Community Server 8.4.7**</u>

### The .dmg (Disk Image) installer places MySQL in:

- Server binaries: /usr/local/mysql/
- Data directory: /usr/local/mysql/data/
- Launch daemon: /Library/LaunchDaemons/com.oracle.oss.mysql.mysqld.plist
- Preference pane: /Library/PreferencePanes/MySQL.prefPane

So you can manage MySQL either through the System Settings GUI or Terminal.

### Managing the MySQL server via terminal on macOS:

```bash
sudo /usr/local/mysql/support-files/mysql.server status
sudo /usr/local/mysql/support-files/mysql.server start
sudo /usr/local/mysql/support-files/mysql.server stop
```

### Connect to the Database shell

```bash
/usr/local/mysql/bin/mysql -u root -p
# Enter root password for MySQL
```
