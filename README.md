# 泡影服务端
- 该项目由SpringMVC + mybatis + mysql整合
- 项目是在Windows 10下的myeclipse 2013开发的，所以为了运行项目，可以通过myeclipse导入项目，然后按照普通的java web项目运行方式，部署到tomcat下运行
- 项目运行之前需要建立名为pyin，以utf-8编码的数据库，至于数据库中的表，可以使用根目录之下的pyin.sql文件导入，然后还需要修改该处的[mysql账号密码](https://github.com/PYing-Studio/PYing-Server/blob/master/resouces/applicationContext-woyao-dao.xml#L64)为电脑mysql的账号密码
- 如果发现项目部署之后，在tomcat的webapp目录下的项目目录名部位api，那么就是在用myeclipse导入项目时，配置信息没有正确加载，可以参考下面文章，将项目名改为api http://blog.csdn.net/dzy784858512/article/details/40657449
