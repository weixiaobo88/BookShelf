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
     - $mysql -u root -p bookshelf进入数据库命令行
     - $source create-db.sql
- 使用DriverManager连接数据库

3. JDBC: DataSource
DBCP BasicDatasource
优点
- JNDI
- ConnectionPool
 

mysql:
- show databases;
- use database;
- show tables;


把basicDatasource放在ServletContext,在app启动的时候，listener监听到后注册进去


1.Servlet处理表单（表单内容为BookShelf中的一个Book的信息），保存到MySQL数据库里面（使用javax.sql.Datasource）

2.用另一个Servlet从数据库中读取所有Book的信息，再通过JSP显示出来

3.将Datasource放在自己的容器里面，以此来模拟IoC容器。将该容器放在ServletContext或者Servlet中，两者的区别是什么？

4.只使用Spring的ClasspathXmlApplicationContext来存放该Datasource，然后将其放在ServletContext中让Servlet访问。

记得频繁提交哦。


作业：
1. display/add book用datasource实现
2. datasource 放在 serveltcontext
3. 自己的spring容器classpath app context, 通过getBean的方式拿出来，注入到 servletContext的attribute中
ClassPathXMLApplicationContext

Spring:
IOC容器
事务处理
AOP
事件处理



application.xml
servlet can access servlet context
getattribute();
getBean();




Add/Display 都有一个datasource
-
- Factory


添加和删除attribute的时候都会触发listener
1. ServletContext级别
context listener
Attribute可以放任何自定义的东西
2. Session级别
attribute
3. Request
attribute

JSP提供了EL ${books},会自动转换成getAttribute()