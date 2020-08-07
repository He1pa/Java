# 1.初识MySQL

JavaEE:企业级Java开发 web

前端（页面：展示数据）

后台（连接点：连接数据库JDBC，链接前端（控制，控制试图跳转，给前端传递数据））

数据库（存数据，Txt，Excel，word）

## 1.1为什么学习数据库

1. 岗位需求
2. 大数据时代，得数据者的天下
3. 被迫需求：存数据
4. ==**数据库是所有软件体系中最核心的存在**==

## 1.2什么是数据库

数据库（DB,DataBase）

概念：数据仓库，软件，安装在操作系统上，SQL,可存储大量的数据。500万！

作用：存储数据，管理数据

## 1.3 数据库分类

关系型数据库：

+ MySQL，Oracle，Sql Server，DB2，SQLlite
+ 通过表和表之间，行和列之间的关系进行数据的存储

非关系型数据库：（NoQL） Not Only

+ Redis，MongDB
+ 非关系型数据库，对象存储，通过对象的自身属性来决定

==DBMS（数据库管理系统）==

+ 数据库的管理软件，科学有效的管理数据，维护和获取数据
+ MySQL，数据库管理系统

## 1.4 MySQL简介

MySQL是一个==关系型数据库管理系统==

前世：瑞典MySQL AB公司 今生：属于Oracle

MySQL是最好的 [RDBMS](https://baike.baidu.com/item/RDBMS/1048260) (Relational Database Management System

体积小、速度快、总体拥有成本低 开源

一般中小型网站 集群

## 1.5安装MySQL

1. 解压

2. 配置环境变量

3. 新建ini文件

   ```ini
   [mysqld]
   basedir=D:\mysql\
   datadir=D:\mysql\data\
   port=3306
   skip-grant-tables
   ```

4. 启动管理员模式的CMD,并将路径切换到bin目录，输入mysqld -install

5. 再输入  mysqld --initialize-insecure --user=mysql 初始化数据文件

6. 输入net start mysql启动数据库

7. mysql -u root -p

8. 进入界面后更改root密码

   ```php
   update mysql.user set authentication_string=password('123456') where user='root' and Host = 'localhost';
   ```

9. 刷新权限

   ```sql
   flush privileges;
   ```

10. 修改 my.ini文件删除最后一句skip-grant-tables

11. 重启mysql即可正常使用

    ```sql
    net stop mysql
    net start mysql
    ```

## 1.6 安装SQLyog

## 1.7 连接数据库

命令行连接

```sql
mysql -uroot -p --连接服务器
update mysql.user set authentication_string=password('123456') where user='root' and Host = 'localhost'; --修改密码
flush privileges； --刷新权限
show databases; --查询所有数据库
use school; --切换数据库
show tables； --查看表
describe student; --显示数据库中所有的结构
creat databases zz;--创建数据库
exit； --退出连接
```

数据库xx语言：

+ DDL 定义
+ DML 操作
+ DQL 查询
+ DCL 控制

# 2操作数据库

操作数据库>操作数据库中的表>操作数据库中表的数据

==MySQL中的关键字不区分大小写==

## 2.1 操作数据库

```sql
CREATE DATABASE IF NOT EXISTS abc; --创建

DROP DATABASE IF EXISTS abc;--删除

--tab键的上面，如果表名或者字段名是特殊字符，需要带``
USE `school`;

SHOW DATABASES; --查看数据库
```

## 2.2 数据库的列类型

+ 数值

  + tinyint 十分小的数据 1字节
  + smallint 较小的数据 2字节
  + mediumint 中等大小 3字节
  + **int 标准整数 4字节**
  + bigint 较大的数据 8字节
  + float 浮点数 4字节
  + double 浮点数 8字节（精度问题）
  + decimal 字符串形式的浮点数  金融计算使用decimal

+ 字符串

  + char 字符串 固定大小 0-255
  + **varchar 可变长度字符串 0-65535**
  + tingtext 微型文本 2^8-1
  + **text 文本串 2^16-1 保存文本**

+ 日期

  + date yyyy-mm-dd 日期格式
  + time HH:mm:ss 时间格式
  + **datetime yyyy-mm-dd HH:mm:ss最常用的时间格式**
  + **timestamp 时间戳**
  + year 年份

+ null

  + 没有值，未知
  + ==不要使用NULL进行运算==

## 2.3 数据库的字段属性

Unsigned:

+ 无符号整数
+ 声明了该列不能为负数

zerofill

+ 0填充
+ 不足的位数，用0填充 int（3） 5->005

自增

+ 通常理解为自增，自动在上一条记录的基础上+1
+ 通常用来设计唯一的主键 index，必须是整数
+ 可以自定义设计主键的起始值和步长

非空 Null not null

+ 假设设置为not null,如果不给他赋值，就会报错
+ Null，如果不填写值，默认是null

默认

+ 设置默认值
+ sex，默认为男，如果不指定，都为男

## 2.4 创建数据库表

```sql
CREATE TABLE IF NOT EXISTS `student`( 
	`id` INT(4) NOT NULL AUTO_INCREMENT COMMENT'学号', 
	`name` VARCHAR(30) NOT NULL DEFAULT'匿名' COMMENT'姓名', 
    `password` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT'密码', 
    `sex` VARCHAR(2) NOT NULL DEFAULT'女' COMMENT'性别', 
    `birthday` DATETIME DEFAULT NULL COMMENT '出生日期', 
    `address` VARCHAR(50) DEFAULT NULL COMMENT'住址', 
    `email`VARCHAR(50) DEFAULT NULL COMMENT'邮箱', 
    PRIMARY KEY (`id`) 
)ENGINE=INNODB DEFAULT CHARSET=utf8; 
```

格式：

```sql
CREATE TABLE [IF NOT EXISTS] `表名`(
	`字段名` 列类型[属性][索引][注释],
    ……
	`字段名` 列类型[属性][索引][注释]
)[表类型][字符集设置][注释]
```

常用命令

```sql
SHOW CREATE DATABASE school
SHOW CREATE TABLE student
DESC student
```



## 2.5 数据表的类型

```sql
--数据库引擎
/*
INNODB 默认使用
MYISAM 早些年使用
*/
```



|            | MYISAM | INNODB        |
| ---------- | ------ | ------------- |
| 事务支持   | 不支持 | 支持          |
| 数据行锁定 | 不支持 | 支持          |
| 外键约束   | 不支持 | 支持          |
| 全文索引   | 支持   | 不支持        |
| 表空间大小 | 较小   | 较大，约为2倍 |

常规使用操作：

+ MYISAM 节约空间，速度较快
+ INNODB 安全性高，事务的处理，多表多用户操作

在物理空间的位置

所有的数据库文件都存在data目录下

本质还是文件的存储

MySQL引擎在物理文件上的区别

+ INNODB在数据库中只有一个*.frm文件，以及上级目录下的.ibdata1文件
+ MYISAM对应的文件
  + *.frm 表结构的定义文件
  + *.MYD 数据文件（data）
  + *.MYI 索引文件（index）

设置数据库字符集编码

```sql
CHARSET=utf8
```

默认编码Latin1不支持中文

## 2.6 修改删除表

```sql
-- 修改表名 ALTER TABLE 旧表名 RENAME AS 新表名
ALTER TABLE teacher RENAME AS teacher1
-- 增加表的字段 ALTER TABLE 表名 ADD 字段名 列属性
ALTER TABLE teacher1 ADD age INT(11)
-- 修改表的字段（重命名，修改约束）
ALTER TABLE teacher1 MODIFY age VARCHAR(11) -- 修改约束
ALTER TABLE teacher1 CHANGE age age1 INT(1) -- 重命名
-- 删除表的字段
ALTER TABLE teacher1 DROP age1
-- 删除表
DROP TABLE IF EXISTS teacher1
```

==所有的创建和删除尽量加上判断==

# 3 MySQL数据管理

## 3.1外键

方法一：

```sql
CREATE TABLE `student` (
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
  `password` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` VARCHAR(2) NOT NULL DEFAULT '女' COMMENT '性别',
  `birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
  `gradeid` INT(10)NOT NULL COMMENT '年级id',
  `address` VARCHAR(50) DEFAULT NULL COMMENT '住址',
  `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`),
  KEY `FK_gradeid`(`gradeid`),
  CONSTRAINT `FK_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade`(`gradeid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8
```



方法二：

```sql
CREATE TABLE `student` (
  `id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
  `password` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` VARCHAR(2) NOT NULL DEFAULT '女' COMMENT '性别',
  `birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
  `gradeid` INT(10)NOT NULL COMMENT '年级id',
  `address` VARCHAR(50) DEFAULT NULL COMMENT '住址',
  `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8-- 创建表的时候没有外键关系
-- ALTER TABLE 表名 ADD CONSTRAINT 约束名 FORGEIGN KEY(作为外键的列) REFERENCES 表名(列名)
ALTER TABLE `student`
ADD CONSTRAINT `FK_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade`(`gradeid`);
```

删除有外键关系的表的时候，必须要先删除引用别人的表（从表），再删除被引用的表（主表）

以上操作都是物理外键，数据库级别的外键，不建议使用（避免数据库过多造成困扰）

==最佳实践==

+ 数据库就是单纯的表，只用来存数据
+ 用程序是实现外键

## 3.2 DML语言

数据库的意义：数据存储，数据管理

+ insert
+ update
+ delete

##  3.3 添加

```sql
-- 插入语句(添加)
-- insert into 表名([字段1][字段2][字段3])value('值1'),('值2'),('值3'),……
INSERT INTO `grade`(`gradename`) VALUE('大四')
-- 由于主键自增，可以省略，如果不写字段，会一一匹配
INSERT INTO`grade`(`gradename`) VALUES('大一'),('大二'),('大三')

```

注意：

1. 字段之间用英文逗号分开
2. 字段是可以省略的，但必须一一对应，不能少
3. 可以同时插入多条数据VALUES后面的值需要使用逗号隔开

## 3.4 修改

```sql
-- 语法
-- UPDATE 表名 SET colunm_name = value where [条件]
-- 修改姓名
UPDATE `student` SET `name`='zz' WHERE id = 1;
-- 不指定条件会改动所有表
UPDATE  `student` SET `name`='zz'
--修改多个属性
UPDATE `student` SET `name`='zz',`email`='123@qq.com' WHERE id = 1;

```

条件： where 子句 运算符 id 等于 大于 再某个区间内修改

| 操作符          | 含义         | 范围     | 结果  |
| --------------- | ------------ | -------- | ----- |
| =               | 等于         | 5=6      | false |
| <>  !=          | 不等于       | 5<>6     | true  |
| >               |              |          |       |
| <               |              |          |       |
| <=              |              |          |       |
| >=              |              |          |       |
| BETWEEN...AND.. | 再某个范围内 | 闭合区间 |       |
| AND             |              |          |       |
| OR              |              |          |       |

```sql
-- 多个条件定位数据
UPDATE `student` SET `name`='zz',`email`='123@qq.com' WHERE id = 1 AND `sex` = '女';
```

注意：

+ colnum_是数据库的列，尽量带上``
+ 条件如果没有指定，则会修改所有的列
+ value是一个具体的值，也可以是一个变量（一般为时间）

```sql
UPDATE `student` SET `name`='zz',`email`='123@qq.com' `birthday` = CURRENT_TIME WHERE id = 1 AND `sex` = '女';
```

## 3.5 删除

delete 命令

```sql
-- 语法
-- DELETE FROM 表名 [条件]
-- 删除全部
DELETE FROM `student`
-- 删除数据
DELETE FROM `student` WHERE id = 1
```

TRUNCATE

作用：完全清空一个数据库表，结构和索引约束不会变

```sql
TRUNCATE `student`
```



区别：

+ 相同点：都能删除数据，不会删除表结构
+ 不同： 
  + TRUNCATE 会重新设置自增列，计数器会归零
  + TRUNCATE 不会影响事务

DELETE删除，重启数据库

+ INNODB 自增列会从1开始（存在内存当中，断电即失）
+ MYISAM 继续从上一个子增量开始（存在文件中，不会丢失）

# 4 DQL数据查询

## 4.1 DQL

data query language:数据查询语言

+ 所有的查询操作都用它 Select
+ 简单的查询，复杂的查询都能做
+ ==数据库中最核心最重要的语句==
+ 使用频率最高的语句

## 4.2 指定查询字段

```sql
-- 语法： SELECT 字段··· FROM 表
-- 查询全部的学生 SELECT 字段 FROM 表
SELECT * FROM student
SELECT * FROM result
-- 查询指定字段
SELECT`studentno`,`studentname`FROM student
-- 别名 给结果起个名字 AS 可以给字段起别名，也可以给表起别名
SELECT`studentno`AS 学号,`studentname`AS 学生姓名 FROM student AS s
-- 函数 Concat(a,b)
SELECT CONCAT('姓名：',studentName) AS 新名字 FROM student
```

> 有些时候列名字不是那么的见名知意，需要起别名 AS

> 去重distinct：去除SELECT查询出来的结果中重复的数据，只显示一条

```sql
-- 查询有哪些人参加了考试，成绩
SELECT * FROM `result`
-- 查询有那些同学参加了考试
SELECT `studentno` FROM `result`
-- 发现重复数据，去重
SELECT DISTINCT `studentno` FROM `result`
```

> 数据库的列（表达式）

```sql
SELECT VERSION() -- 函数
SELECT 100*3-1	-- 表达式
SELECT @@auto_increment_increment -- 变量
-- 成绩+1
SELECT `studentno`,`studentresult`+1 AS 提分 FROM `result`
```

数据库中的表达式：文本值，列，Null，函数，计算表达式，系统变量

## 4.3 where条件子句

作用：检索数据中符合条件的值

> 逻辑运算符

| 运算符  | 语法          | 描述 |
| ------- | ------------- | ---- |
| and &&  | a and b a&&b  | 与   |
| or \|\| | a or b a\|\|b | 或   |
| not ！  | not a   !a    | 非   |

==尽量使用字母==

```sql
SELECT `studentno`,`studentresult` FROM result
-- 查询成绩在95-100之间
SELECT `studentno`,`studentresult` FROM result
WHERE `studentresult`>=95 AND `studentresult`<=100

-- 模糊查询 （区间）
SELECT `studentno`,`studentresult` FROM result
WHERE `studentresult` BETWEEN 95 AND 100
-- != not
SELECT `studentno`,`studentresult` FROM result
WHERE `studentresult` != 85

SELECT `studentno`,`studentresult` FROM result
WHERE NOT `studentresult` = 85
```

> 模糊查询： 比较运算符

| 运算符        | 语法              | 描述 |
| ------------- | ----------------- | ---- |
| IF NULL       | a is null         |      |
| IS NOT NULL   | a is not null     |      |
| BETWEEN···AND | a between b and c |      |
| **LIKE**      | a like b          |      |
| **IN**        | a in (a1,a2,a3)   |      |

```sql
-- =============like====================
-- 查询名字姓张的同学
-- like 结合 %(代表0到任意个字符) -(代表一个同学)
SELECT `studentno`,`studentname` FROM`student`
WHERE `studentname` LIKE '张%'
-- 查询名字姓张的同学，名字后面只有一个字
SELECT `studentno`,`studentname` FROM`student`
WHERE `studentname` LIKE '张_'
-- 查询名字中带伟
SELECT `studentno`,`studentname` FROM`student`
WHERE `studentname` LIKE '%伟%'

-- ==========in(具体的一个或多个值)===============
SELECT `studentno`,`studentname` FROM`student`
WHERE `studentno` IN (1001,1002,1003)

-- ==========null not null==========
SELECT `studentno`,`studentname` FROM`student`
WHERE `address` IS NOT NULL
```

## 4.4 连表查询

> join差异

![点击查看源网页](https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596798579093&di=d1e251caba1a9ebba97ab987e8fffa8c&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbaike%2Fpic%2Fitem%2F7e3e6709c93d70cf77d6f685f2dcd100baa12b0d.jpg)

```sql
-- ===============联表查询======================
SELECT * FROM `student`
SELECT * FROM `result`
/*
1.分析需求，分析查询字段来自哪些表
2.确定使用哪种连接查询 7种
确定交叉点：两个表中那个数据是相同的
判断的条件：学生表的 studentno = 成绩表的studentno
*/
-- Inner Join
SELECT s.`studentno`,`studentname`,`subjectno`,`studentresult`
FROM student AS s
INNER JOIN result AS r
WHERE s.`studentno` = r.`studentno`


-- Right Join
SELECT s.`studentno`,`studentname`,`subjectno`,`studentresult`
FROM student AS s
RIGHT JOIN result r
ON s.`studentno` = r.`studentno`

-- Left Join
SELECT s.`studentno`,`studentname`,`subjectno`,`studentresult`
FROM student AS s
LEFT JOIN result r
ON s.`studentno` = r.`studentno`
```

| 操作       | 描述                                       |
| ---------- | ------------------------------------------ |
| Inner join | 如果表中至少有一个匹配，就返回行           |
| left join  | 会从左边的表返回所有的值，即使右表没有匹配 |
| right join | 会从右表返回所有的值，即使左表没有匹配     |

```sql
-- 查询参加了考试的同学的信息，学号，学生姓名，科目名，分数
/*
1.分析需求，分析查询字段来自哪些表 student result subject
2.确定使用哪种连接查询 7种
确定交叉点：两个表中那个数据是相同的
判断的条件：学生表的 studentno = 成绩表的studentno
*/
SELECT s.`studentno`,`studentname`,`studentresult`,`subjectname`
FROM student s
RIGHT JOIN `result` r
ON r.`studentno`=s.`studentno`
INNER JOIN `subject` sub
ON r.`subjectno`= sub.`subjectno`
-- 要查哪些数据 select
-- 从哪几个表查  from 表 xxjoin 连接的表 on 交叉条件
-- 假设存在多张表查询，慢慢来，先查两张再增加
```

> 自连接

自己的表和自己的表连接，核心：一张表拆为两张一样的表

| categoryid | categoryname |
| ---------- | ------------ |
| 2          | 新技术       |
| 3          | 软件开发     |
| 5          | 美术技术     |
|            |              |

| pid  | categoryid | categoryname |
| ---- | ---------- | ------------ |
| 3    | 4          | 数据库       |
| 2    | 8          | 办公信息     |
| 3    | 6          | web开发      |
| 5    | 7          | 美术设计     |

操作：查询父类对应的子类关系

| 父类     | 子类     |
| -------- | -------- |
| 信息技术 | 办公信息 |
| 软件开发 | 数据库   |
| 软件开发 | web开发  |
| 美术技术 | 美术设计 |

```sql
-- 查询父子信息
SELECT a.`categoryname` AS '父',b.`categoryname` AS '子'
FROM`category` a ,`category` b
WHERE a.`categoryid` = b.`pid`
```

练习

```sql
-- 查询学号，姓名，年纪
SELECT `studentno`,`studentname`,`gradename`
FROM `student` s
INNER JOIN `grade` g
ON s.`gradeid` = g.`gradeid`

-- 查询科目所属的年级 科目名称 年纪名称
SELECT `subjectname`,`gradename`
FROM `subject` sub
INNER JOIN `grade` g
ON sub.`gradeid`=g.`gradeid`

-- 查询参加了高等数学-1 考试的同学的信息，学号，学生姓名，科目名，分数
SELECT s.`studentno`,`studentname`,`subjectname`,`studentresult` 
FROM `student` s 
INNER JOIN `result` r 
ON s.`studentno`=r.`studentno` 
INNER JOIN `subject` sub 
ON r.`subjectno`=sub.`subjectno` 
WHERE `subjectname`='高等数学-1'
```

## 4.5 分页和排序

> 排序 ASC DESC

 ```sql
 -- 排序 升序 asc 降序 desc
 -- 根据结果成绩降序排序
 SELECT s.`studentno`,`studentname`,`subjectname`,`studentresult` 
 FROM `student` s 
> INNER JOIN `result` r 
 ON s.`studentno`=r.`studentno` 
 INNER JOIN `subject` sub 
 ON r.`subjectno`=sub.`subjectno` 
 WHERE `subjectname`='高等数学-1'
 ORDER BY `studentresult` ASC
 ```

> 分页

```sql
-- 分页 每页只显示5条数据
-- 语法：limit 起始值,每页大小
-- 网页应用 当前，总的页数，当前大小
-- 第一页 limit 0,5
-- 第二页 limit 5,5
-- 第三页 limit 10,5
-- 第N页 limit （n-1）*pagesize,pagesize
-- 总页数 = 数据总数/数据大小
SELECT s.`studentno`,`studentname`,`subjectname`,`studentresult` 
FROM `student` s 
INNER JOIN `result` r 
ON s.`studentno`=r.`studentno` 
INNER JOIN `subject` sub 
ON r.`subjectno`=sub.`subjectno` 
WHERE `subjectname`='高等数学-1'
ORDER BY `studentresult` ASC
LIMIT 0,5 -- 起始值，页面大小
```

```sql
-- 思考
-- 查询JAVA第一学年，课程成绩排名前十，分数大学80的学生信息
-- （学号，姓名，课程名称，分数）
SELECT s.`studentno`,`studentname`,`subjectname`,`studentresult`
FROM `student` s
INNER JOIN `result` r
ON s.`studentno`=r.`studentno`
INNER JOIN `subject` sub
ON sub.`subjectno`=r.`subjectno`
WHERE `subjectname`='JAVA第一学年' AND `studentresult`>=80
ORDER BY `studentresult` DESC
LIMIT 0,10
```

## 4.6 子查询

where（值是计算出来的）

本质：在where语句中嵌套一个子查询

```sql
-- 查询数据库结构-1 所有的考试结果 学号 编号 成绩 降序
SELECT `studentno`,`subjectname`,`studentresult`
FROM `result` r
INNER JOIN `subject` sub
ON r.`subjectno`=sub.`subjectno`
WHERE `subjectname` = '数据库结构-1'
ORDER BY `studentresult` DESC
-- 使用子查询
SELECT `studentno`,`subjectno`,`studentresult`
FROM `result` 
WHERE `studentno`IN(SELECT `subjectno`
FROM `subject`
WHERE `subjectname` ='数据库结构-1')
-- 查询数据库结构-1 学生 学号 
SELECT `subjectno`
FROM `subject`
WHERE `subjectname` = '数据库结构-1'


-- 分数不小于80分学生的学号和姓名
SELECT DISTINCT s.`studentno`,`studentname`
FROM `student` s
INNER JOIN `result` r
ON s.`studentno`=r.`studentno`
WHERE `studentresult` >= 80
-- 在这个基础上增加一个，高等数学-2
SELECT DISTINCT s.`studentno`,`studentname`
FROM `student` s
INNER JOIN `result` r
ON s.`studentno`=r.`studentno`
WHERE `studentresult` >= 80 AND `subjectno` = (
SELECT `subjectno` FROM `subject` 
WHERE `subjectname` = '高等数学-2'
)

-- 查询课程为高等数学-2 分数不小于80的同学的学号和姓名
SELECT s.`studentno`,`studentname`
FROM `student` s
INNER JOIN `result` r
ON s.`studentno`=r.`studentno`
INNER JOIN `subject` sub
ON r.`subjectno`=sub.`subjectno`
WHERE`subjectname`= '高等数学-2' AND `studentresult` >= 80
```

# 5 MySQL函数

# 5.1 常用函数

```sql
-- 数学运算
SELECT ABS(-8) -- 绝对值
SELECT CEILING(9.4) -- 向上取整
SELECT FLOOR(9.4) -- 向下取整
SELECT RAND() -- 随机数
SELECT SIGN()  -- 返回参数的符号 -1 0 1
-- 字符串函数
SELECT CHAR_LENGTH('asdasdasd') -- 字符串长度
SELECT CONCAT('a','b','c') -- 连接字符串
SELECT INSERT('helloworld',3,2,'213') -- 插入，替换
SELECT LOWER('sSADsf')
SELECT UPPER('ASDsadasdasd')
SELECT INSTR('hello','e') -- 返回第一次出现字串的索引
SELECT REPLACE('hello','ll','mm')
SELECT SUBSTR('hello',2,4) -- 返回指定的子字符串
SELECT REVERSE('hello') -- 反转字符串
-- 时间和日期
SELECT CURRENT_DATE()
SELECT NOW()
SELECT LOCALTIME() 
-- 系统
SELECT SYSTEM_USER()
SELECT USER()
SELECT VERSION()
```

