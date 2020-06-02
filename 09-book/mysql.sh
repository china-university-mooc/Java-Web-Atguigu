docker run --name mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -v mysql-data:/var/lib/mysql mysql:5.7
