
#### javaweb初学者，有很多的缺陷

# blog
javaWEB   
账户： root
密码：123456
## 一个简陋的javaWeb的博客系统，谷歌浏览器下使用
#####  注：本项目代码没有十分规范，在于练习 servlet和jdbc，使用 动态代理和threadLocal实现了事务管理，使用工厂模式生成单例对象解耦
#####实现功能：
登录，发布文章，管理文章，管理分类，创建分类，按分类展示文章，阅读排行，文章显示
##### 游客登录，点赞，发布评论等功能待完善



### 三层架构

#### 表现层：
#### 前端页面
(前端页面设计参照csdn博主，但是代码部分完全独立实现)
##### html :前端页面的骨架
##### css ：页面的皮肤，美化页面（虽然我做的很丑）
##### javascript ：实现页面的动态效果，例如表单验证，异步提交
##### jquery ：javascript的一个框架，操作dom，bom更加方便
##### ajax ：异步加载，发送请求 post get
##### edtior.md: Markdown编辑器editor.md的使用，创建文件和显示文件
##### servlet 在服务器运行的程序，负责处理客户端的请求，PC之所以称之为服务器是因为有它
##### jackson : json的工具类，可以java转json，json转java

### 持久层
数据库连接池c3p0 ：使用前需要创建配置文件，在配置文件中设置加载的驱动，和链接数据库的url,提前创建connection连接数据库的对象，使用时直接从数据库连接池中获取，使用完毕归还连接池，不必频繁直接与数据库建立连接，断开连接，提高性能
##### jdbcTemplate ：spring对jdbc操作的一些封装，可以直接将数据库中的数据封装到指定的对象中，方便操作
##### BeanUtils ：javaBean的工具类，用于将数据封装为javaBean对象
##### javaBean：java对象，必须右set和get方法，和提供空参的public的构造方法，属性权限为 private


##### 数据库
数据库的设计非常重要，例如：外键约束，主键，级联操作，内联检索等

user 
+----------+--------------+------+-----+---------+----------------+
##### | Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
##### | uid      | int(10)      | NO   | PRI | NULL    | auto_increment |
##### | name     | varchar(100) | NO   | UNI | NULL    |                |
##### | pwd      | varchar(100) | NO   |     | NULL    |                |
##### | imageUrl | varchar(200) | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+

classify

+---------+--------------+------+-----+---------+----------------+
##### | Field   | Type         | Null | Key | Default | Extra          |
+---------+--------------+------+-----+---------+----------------+
##### | cid     | int(11)      | NO   | PRI | NULL    | auto_increment |
##### | cname   | varchar(200) | YES  |     | NULL    |                |
##### | cnumber | int(11)      | YES  |     | 0       |                |
##### | uid     | int(11)      | YES  | MUL | NULL    |                |
+---------+--------------+------+-----+---------+----------------+

delarticle

+-----------+--------------+------+-----+---------+----------------+
##### | Field     | Type         | Null | Key | Default | Extra          |
##### +-----------+--------------+------+-----+---------+----------------+
##### | aid       | int(11)      | NO   | PRI | NULL    | auto_increment |
##### | uid       | int(11)      | YES  |     | NULL    |                |
##### | time      | varchar(200) | YES  |     | NULL    |                |
##### | cid       | int(11)      | YES  |     | NULL    |                |
##### | content   | text         | YES  |     | NULL    |                |
##### | viewTimes | int(11)      | YES  |     | NULL    |                |
##### | aname     | varchar(200) | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+

article
+-----------+--------------+------+-----+---------+----------------+
##### | Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
##### | aid       | int(11)      | NO   | PRI | NULL    | auto_increment |
##### | uid       | int(11)      | YES  |     | NULL    |                |
##### | time      | varchar(200) | YES  |     | NULL    |                |
##### | cid       | int(11)      | YES  |     | NULL    |                |
##### | content   | text         | YES  |     | NULL    |                |
##### | viewTimes | int(11)      | YES  |     | NULL    |                |
##### | aname     | varchar(200) | YES  |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+


实现功能：
登录，发布文章，管理文章，管理分类，创建分类，按分类展示文章，阅读排行，文章显示
