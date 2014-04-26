##Bookshelf
javaee program

###Preparation:
* install mysql
* install gradle
* github repository

### Description
* BookShelf是一个可以添加图书和浏览图书的程序，通过读取输入文件，将文件中的图书信息保存起来，并且可以浏览所有图书，另外还可以通过指定条件查找图书。
* 每条记录的格式为：ISBN,bookName,price,author


### Requirement

1. 使用servlet完成HTML Form，不能使用jsp, 只能使用print得到表单，表单行为是添加一本书的信息
ISBN: int, bookName: string, price: double, author: string
步骤：
- gradle
     servlet
- web.xml
     servletname and mapping
- servlet
     实现doget dopost


2. 将图书信息Write to DB
步骤：
- mysql中新建book表
     - $mysqld开启mysql服务
     - $mysql进入数据库命令行
     - $source create-db.sql
- 使用DriverManager连接数据库
 