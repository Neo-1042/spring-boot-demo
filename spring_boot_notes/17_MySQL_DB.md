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

# Workspace SQL scripts

- 01-create-user.sql

userid = password = **springstudent**

- 02-student-tracker.sql

Creates the schema and the STUDENT DB table.

## Running scripts using MySQL's console

```bash
# Start the MySQL server
sudo /usr/local/mysql/support-files/mysql.server start
sudo /usr/local/mysql/support-files/mysql.server status

# Access the database shell:
/usr/local/mysql/bin/mysql -u root -p
# Enter root password

mysql> source /path/to/your/script.sql;
mysql> source /Users/rafael1642/GIT/Projects/spring-boot-demo/hibernate_jpa_crud_spring_boot/sql_scripts/00-starter-sql-scripts/01-create-user.sql

```

Running this first script creates the user 'springstudent'
with the 'root' user first. 

This user originally has only schema = "sys". 

File: 02-student-tracker.sql will create the schema named
**'student_tracker'**
```sql
CREATE DATABASE IF NOT EXISTS `student_tracker`;
USE `student_tracker`;
```

# Change the starting point of AUTO_INCREMENT

```sql
ALTER TABLE student_tracker.student AUTO_INCREMENT=100;
```

# Reset AUTO_INCREMENT back to 1

```sql
TRUNCATE TABLE student_tracker.student;
```