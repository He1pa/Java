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

```sql
SELECT
    [ALL | DISTINCT | DISTINCTROW ]
    {*|table.*|[table.filed1[as alias1][,table.filed2[as alias2]][,...]]}
    FROM table_name [as table_alias]
    [left|right|inner join table_name2]
    [WHERE where_definition]
    [GROUP BY {col_name | expr | position}
      [ASC | DESC], ... [WITH ROLLUP]]
    [HAVING where_definition]
    [ORDER BY {col_name | expr | position}
      [ASC | DESC] , ...]
    [LIMIT {[offset,] row_count | row_count OFFSET offset}]
  
```

  

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

## 4.7 分组和过滤

```sql
-- 查询不同课程的平均分，最高分，最低分
-- 根据不同课程分组
SELECT `subjectname`,AVG(`studentresult`),MAX(`studentresult`),MIN(`studentresult`)
FROM`result` r
INNER JOIN `subject` sub
ON r.`subjectno`=sub.`subjectno`
GROUP BY r.`subjectno`
HAVING AVG(`studentreslt`)>80
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

## 5.2 聚合函数

| 函数名  | 描述 |
| ------- | ---- |
| COUNT() |      |
| SUM()   |      |
| AVG()   |      |
| MAX()   |      |
| MIN()   |      |
| ...     |      |

```sql
SELECT COUNT(`studentname`) FROM `student`-- COUNT(指定列) 会忽略null值
SELECT COUNT(*) FROM `student` -- 不会忽略null 本质 计算行数
SELECT COUNT(1) FROM `student` -- 不会忽略null本质 计算行数

SELECT SUM(`studentresult`) AS 总和 FROM `result`
SELECT AVG(`studentresult`) AS 平均 FROM `result`
SELECT MAX(`studentresult`) AS 最高 FROM `result`
SELECT MIN(`studentresult`) AS 最低 FROM `result`
```

## 5.3 数据库级别的MD5加密

什么是MD5？

主要增强算法的复杂度和不可逆性

MD5不可逆

MD5的破解网站的原理，背后有一个字典，MD5加密后的值，加密前的值

# 6 事务

6.1 什么是事务

==要么都成功，要么都失败==

------------------------------------------

1 SQL执行，A给B转账200   A:1000   (200)->   B：200

2 SQL执行，B收到A的钱  A:800  B:400

---------------------------------------------------------------

将一组SQL放在一个批次中去执行

> 事务原则：ACID  原子性，一致性，隔离性，持久性

https://blog.csdn.net/dengjili/article/details/82468576

**原子性（Atomicity）**

要么都成功，要么都失败

**一致性（Consistency）**

事务前后数据的完整性必须保持一致

**隔离性（Isolation）**

事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。

**持久性（Durability）**

事务一旦提交就不可逆转



>  隔离导致的问题：

### 脏读：

指一个事务读取了另外一个事务未提交的数据。

### 不可重复读：

在一个事务内读取表中的某一行数据，多次读取结果不同。（这个不一定是错误，只是某些场合不对）

### 虚读(幻读)

是指在一个事务内读取到了别的事务插入的数据，导致前后读取不一致。
 （一般是行影响，多了一行）

> 执行事务

```sql
-- mysql是默认开启事务自动提交的
SET autocommit = 0/*关闭*/
SET autocommit = 1/*开启*/
-- 手动处理事务
SET autocommit = 0/*关闭自动提交*/
-- 事务开启
START TRANSACTION -- 标记一个事物的开始，从这个之后的sql都在一个事务内
-- 提交 持久化（成功）
COMMIT
-- 回滚 回到原来的样子（失败）
ROLLBACK
-- 事务结束
SET autocommit = 1/*开启*/
SAVEPOINT 保存点名 -- 设置一个事务的保存点
ROLLBACK TO SAVEPOINT 保存点名 -- 回滚到保存点
RELEASE SAVEPOINT 保存点名  -- 撤销保存点
```

> 模拟场景：转账

```sql
CREATE DATABASE shop CHARACTER SET utf8 COLLATE utf8_general_ci
USE shop
CREATE TABLE `account`( 
`id` INT(3) NOT NULL AUTO_INCREMENT, 
`name` VARCHAR(30) NOT NULL, 
`money` DECIMAL(9,2) NOT NULL, 
PRIMARY KEY (`id`) 
)ENGINE = INNODB DEFAULT CHARSET = utf8; 
INSERT INTO ACCOUNT(`name`,`money`)
VALUES('a',2000.00),('b',10000)
-- 模拟转账事务
SET autocommit = 0
START TRANSACTION -- 开启事务
UPDATE `account` SET `money`= `money`-500 WHERE `name` ='a' -- a-500
UPDATE `account` SET `money`= `money`+500 WHERE `name` ='b' -- b+500
COMMIT;
ROLLBACK;
SET autocommit = 1 -- 恢复默认值
```

# 7 索引

> 索引（Index）是**帮助MySQL高效获取数据的数据结构**。提取句子主干，就可以得到索引的本质：索引是数据结构。

## 7.1 索引的分类

> 在一个表中,主键索引只能有一个,唯一索引可以有多个

+ 主键索引(PRIMARY KEY)
  + 唯一标识,主键不可重复,而且只有一个列作为主键
+ 唯一索引(UNIQUE KEY)
  + 不允许具有索引值相同的行
+ 常规索引(KEY/INDEX)
  + 默认的,可以用index key关键字设置
+ 全文索引(FULLTEXT)
  + 在特定的数据库引擎下才有
  + 快速定位数据

```sql
-- 索引的使用
-- 1.在创建表的时候给字段添加索引
-- 2.创建完毕后，增加索引
-- 显示所有的索引信息
SHOW INDEX FROM student
-- 增加一个全文索引（索引名）列名
ALTER TABLE `student` ADD FULLTEXT INDEX `studentname` (`studentname`)
-- explain 分析sql执行的情况
EXPLAIN SELECT * FROM student -- 非全文索引
EXPLAIN SELECT * FROM student WHERE MATCH (studentname) AGAINST('刘')

```

7.2 测试索引

```sql
CREATE TABLE `app_user` (
`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) DEFAULT '',
`email` VARCHAR(50) NOT NULL,
`phone` VARCHAR(20) DEFAULT '',
`gender` TINYINT(4) UNSIGNED DEFAULT '0',
`password` VARCHAR(100) NOT NULL DEFAULT '',
`age` TINYINT(4) DEFAULT NULL,
`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8


-- 插入100万数据.
DELIMITER $$
-- 写函数之前必须要写，标志
CREATE FUNCTION mock_data ()
RETURNS INT
BEGIN
DECLARE num INT DEFAULT 1000000;
DECLARE i INT DEFAULT 0;
WHILE i<num DO
INSERT INTO `app_user`(`name`,`email`,`phone`,`gender`)VALUES(CONCAT('用户',i),'19224305@qq.com','123456789',FLOOR(RAND()*2));
SET i=i+1;
END WHILE;
RETURN i;
END;

SELECT mock_data() -- 执行此函数 生成一百万条数据
SELECT * FROM `app_user` WHERE `name` = '用户9999'  -- 1 sec
EXPLAIN SELECT * FROM `app_user` WHERE `name` = '用户9999'
-- id_表名_字段名
-- create index 索引名 on 表（字段）
CREATE INDEX id_app_user_name ON `app_user`(`name`)
EXPLAIN SELECT * FROM `app_user` WHERE `name` = '用户9999'  -- 0.001sec
```

索引在数据量小的时候用处不大,但是在数据量大的时候区别十分明显

## 7.3 索引原则

+ 索引不是越多越好
+ 不要对经常变动的数据加索引
+ 小数据量的表不需要加索引
+ 索引一般加在常用来查询的字段上

> 索引的数据结构

Hash 类型的索引

Btree: INNODB的默认的索引数据类型

>  MySQL索引背后的数据结构及算法原理

http://blog.codinglabs.org/articles/theory-of-mysql-index.html

# 8.权限管理和备份

## 8.1 用户管理

![image-20200808150152040](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808150152040.png)

> SQL命令操作

用户表:mysql.user

本质:对这张表进行增删改查

```sql
-- 创建用户 CREATE USER 用户名 IDENTIFIED BY 密码
CREATE USER zz IDENTIFIED BY '123456'
-- 修改密码（当前用户）
SET PASSWORD = PASSWORD('123456')
-- 修改指定用户的密码
SET PASSWORD FOR zz = PASSWORD('123456')
-- 重命名
RENAME USER zz TO zzz
-- 用户授权
-- ALL PRIVILEGES除了给别人授权，其他权限都有
GRANT ALL PRIVILEGES ON *.* TO zzz
-- 查看授权
SHOW GRANTS FOR zzz
SHOW GRANTS FOR root@localhost
-- 撤销权限
REVOKE ALL PRIVILEGES ON *.* ON zzz
-- 删除用户
DROP USER zzz
```

## 8.2 MySQL备份

为什么要备份:

+ 保证重要的数据不丢失
+ 数据转移

MySQL数据库备份的方式

+ 拷贝物理文件

+ 在Sqlyog这种可视化工具中导出

  + 在想要导出数据库或表右键导出![image-20200808151419380](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808151419380.png)

+ 使用命令行到处mysqldump命令行导出

  ```bash
  # mysqldump -h 主机 -u用户名 -p密码 数据库 表1 表2 表3... >物理磁盘位置/文件名
  C:\User\Administrator>mysqldump -hlocalhost -uroot -p123456 school student >D:/a.sql
  # mysqldump -h 主机 -u用户名 -p密码 数据库  >物理磁盘位置/文件名
  C:\User\Administrator>mysqldump -hlocalhost -uroot -p123456 school >D:/a.sql
  # 导入
  # 登录的情况下,切换到指定的数据库
  source d:/a.sql
  ```

# 9 规范数据库设计

## 9.1 为什么需要设计

糟糕的数据库设计:

+ 数据冗余,浪费空间
+ 数据库插入和删除都会麻烦,异常[屏蔽使用物理外键]
+ 性能差

良好的数据库设计:

+ 节省内存空间
+ 保证数据库完整性
+ 方便开发系统

软件开发中,关于数据库的设计

+ 分析需求:分析业务和需要处理的数据库的需求
+ 概要设计:设计关系图E-R图

设计数据库的步骤:(个人博客)

+ 收集信息,分析需求
  + 用户表(用户登录注销,用户的个人信息,写博客,创建分类)
  + 分类表(文章分类,谁创建的)
  + 文章表(文章的信息)
  + 评论表
  + 友链表
  + 自定义表(系统信息)
+ 标识实体类(把需求落实到字段)
+ 标识实体之间的关系
  + 写博客user->blog
  + 创建分类user->category
  + 关注user->user
  + 友链
  + 评论 user-user-blog

## 9.2 三大范式

为什么需要数据规范化

+ 信息重复
+ 更新异常
+ 插入异常
  + 无法正常显示信息
+ 删除异常
  + 丢失有效的信息

> 三大范式

**第一范式（1NF）：**

**原子性**

要求数据库表的每一列都是不可分割的原子数据项。

![image-20200808160708396](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808160708396.png)

**第二范式（2NF）：**

**前提:满足第一范式**

**每张表只描述一件事**

第二范式需要确保数据库表中的每一列都和主键相关，而不能只与主键的某一部分相关（主要针对联合主键而言）。

![image-20200808160652218](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808160652218.png)

**第三范式（3NF）：**

**前提:满足第二范式**

**第三范式需要确保数据表中的每一列数据都和主键直接相关，而不能间接相关。**![image-20200808160637956](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808160637956.png)

  

**规范数据库的设计**

规范性和性能的问题

关联查询的表不得超过三张表

+ 考虑到商业化的需求和目标(成本,用户体验),数据库的性能更加重要
+ 在规范性能问题的时候适当考虑规范性
+ 故意在某些表添加冗余字段,从多表查询变为单表查询
+ 故意增加一些计算列,从大数据量降低为小数据量的查询

# 10 JDBC

## 10.1 数据库驱动

驱动:声卡,显卡,数据库

![image-20200808161246632](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808161246632.png)

程序会通过数据库驱动与数据库打交道

## 10.2 JDBC

SUN公司为了简化开发人员的(对数据库的统一)操作,提供了一个(Java操作数据库的)规范,俗称JDBC,这些规范的实现由具体的厂商去做

对开发人员来说,只需要掌握JDBC的接口即可

![image-20200808161747716](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808161747716.png)

java.sql

javax.sql

## 10.3 第一个JDBC程序

> 创建测试数据库

```sql
CREATE DATABASE jdbcStudy CHARACTER SET utf8 COLLATE utf8_general_ci;

USE jdbcStudy;

CREATE TABLE `users`(
id INT PRIMARY KEY,
NAME VARCHAR(40),
PASSWORD VARCHAR(40),
email VARCHAR(60),
birthday DATE
);

INSERT INTO `users`(id,NAME,PASSWORD,email,birthday)
VALUES(1,'zhansan','123456','zs@sina.com','1980-12-04'),
(2,'lisi','123456','lisi@sina.com','1981-12-04'),
(3,'wangwu','123456','wangwu@sina.com','1979-12-04')
```

1. 创建一个项目
2. 导入数据库驱动
3. 测试代码

```java
package com.zz.lesson01;

import com.sun.org.apache.xml.internal.utils.res.XResources_ko;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2 用户信息和url useUnicode=true&characterEncoding=utf8&useSSL=true
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "123456";
        //3 连接成功，获得数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);
        //4 执行SQL的对象
        Statement statement = connection.createStatement();
        //5 执行SQL的对象 去执行SQL，可能存在结果，查看结果
        String sql = "SELECT * FROM`users`;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("NAME"));
            System.out.println("pwd="+resultSet.getObject("PASSWORD"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birth="+resultSet.getObject("birthday"));
        }
        //6 释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}

```

步骤总结:

1. 加载驱动
2. 连接数据库DriverManager
3. 获得执行的sql对象 Statement
4. 获得返回的结果集
5. 释放连接

> DriverManager

```java
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver()) ;
        Class.forName("com.mysql.jdbc.Driver");
 		Connection connection = DriverManager.getConnection(url, username, password);
//connection 代表数据库
// 数据库设置自动提交
//事务提交
//事务回滚
connertion.rollback();
connertion.commit();
connection.setAutoComitted();
```

> URL

```java
String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
//mysql --3306
//协议://主机地址:端口号/数据库名?参数1&参数2&参数3
//oracle  --1521
//jdbc:oracle:thin:@localhost:1521:sid
```

> Statement 执行SQL的对象  PrepareStatement 执行SQL的对象

```java
statement.executeQuery();//查询操作，返回 ResultSet
statement.execute();//执行任何SQL 效率低
statement.executeUpdate();// 更新、插入、删除，返回一个受影响的行数
```

> ResultSet 查询的结果集:封装了所有的查询结果

获得指定的数据类型

```java
resultSet.getObject();//不知道列类型
resultSet.getString();//字符串
resultSet.getInt();//Int型
resultSet.getFloat();//Float类型

```

> 遍历,指针

```java
resultSet.beforeFirst();//移动到最前面
resultSet.afterLast();//移动到最后一行
resultSet.next();//移动到下一行
resultSet.previous();//移动到前一行
resultSet.absolute(row);//移动到指定行
```

> 释放资源

```java
resultSet.close();
statement.close();
connection.close();
```

## 10.4 statement对象

Jdbc中的statement对象用于向数据库发送SQL语句,像完成对数据库的增删改查,只需要通过这个对象对数据库发送增删改查的语句即可

Statement对象的executeUpdate方法用于向数据库发送增删改的sql语句,executeUpdate执行完后,会返回一个整数(即增删改语句导致了数据库几行数据发生了变化)

Statement.executeQuery方法用于向数据库发送查询语句,executeQuery方法的返回值代表查询结果的ResultSet对象

> CRUD操作-create

```java
Statement statement = connection.createStatement();
String sql = "insert into user(...) values(...)";
int num = statement.executeUpdate(sql);
if (num > 0){
	System.out.println("插入成功");
}
```

> CRUD操作-delete

```java
Statement statement = connection.createStatement();
String sql = "delete from user where id = 1";
int num = statement.executeUpdate(sql);
if (num > 0){
	System.out.println("删除成功");
}
```

> CRUD操作-update

```java
Statement statement = connection.createStatement();
String sql = "update user set name = '' where name = ''";
int num = statement.executeUpdate(sql);
if (num > 0){
	System.out.println("修改成功");
}
```

> CRUD操作-read

```java
Statement statement = connection.createStatement();
String sql = "select * from user where id = 1";
ResultSet rs = statement.executeQuery(sql);
while (re.next){
	
}
```

> 代码实现

1. 提取工具类

   ```java
   package com.zz.lesson02.utils;
   
   import java.io.IOException;
   import java.io.InputStream;
   import java.sql.*;
   import java.util.Properties;
   
   public class JdbcUtils {
       private  static  String driver = null;
       private  static  String url = null;
       private  static  String username = null;
       private  static  String password = null;
   
       static {
           try {
               InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
               Properties properties = new Properties();
               properties.load(in);
   
               driver = properties.getProperty("driver");
               url = properties.getProperty("url");
               username = properties.getProperty("username");
               password = properties.getProperty("password");
   
               //驱动只用加载一次
               Class.forName(driver);
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   
       //获取连接
       public static Connection getConnection() throws SQLException {
           return DriverManager.getConnection(url, username, password);
       }
   
       //释放资源
   
       public static void release(Connection cnn, Statement st, ResultSet rs){
           if(rs != null){
               try {
                   rs.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           if(st != null){
               try {
                   st.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           if(cnn != null){
               try {
                   cnn.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
   
       }
   }
   
   ```

   

2. 编写增删改的方法

```java
package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = JdbcUtils.getConnection();
            st = cnn.createStatement();

            String sql = "INSERT INTO `users`(`id`,`NAME`,`PASSWORD`,`email`,`birthday`)\n" +
                    "VALUES('4','z','123456','123124@qq.com','1990-12-11')";
            int i = st.executeUpdate(sql);
            if (i >0){
                System.out.println("成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,st,rs);
        }
    }
}

```

```java
package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = JdbcUtils.getConnection();
            st = cnn.createStatement();

            String sql = "DELETE FROM `users` WHERE id = 4";
            int i = st.executeUpdate(sql);
            if (i >0){
                System.out.println("成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,st,rs);
        }
    }
}

```

```java
package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = JdbcUtils.getConnection();
            st = cnn.createStatement();

            String sql = "UPDATE `users` SET `NAME`='zz' WHERE `id` = 1";
            int i = st.executeUpdate(sql);
            if (i >0){
                System.out.println("成功");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,st,rs);
        }
    }
}

```
3. 查询

```java
package com.zz.lesson02;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestQuery {
    public static void main(String[] args) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = JdbcUtils.getConnection();
            st = cnn.createStatement();

            String sql = "SELECT * FROM `users` where `id` = 1";
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("NAME"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,st,rs);
        }
    }
}

```

> SQL注入的问题

sql存在漏洞,会被攻击导致数据泄露,==SQL会被拼接or==

```java
import com.utils.jdbcutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLinject {
    public static void main(String[] args) throws SQLException {
             login("'' or 1=1","'' or 1=1");
    }
    public static  void login(String username,String password) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            //SELECT * FROM `users` WHERE `NAME`='' or 1=1 AND `PASSWORD`='' or 1=1 ;
            //获取连接
            connection = jdbcutils.getConnection();
            //获取sql对象
            statement = connection.createStatement();
            //sql
            String sql="SELECT * FROM `users` WHERE `NAME`= "+"'"+username+"'"+" AND `PASSWORD`="+"'"+password+"'";
            //查询获取返回集合
            ResultSet query = statement.executeQuery(sql);
            //遍历
            while (query.next()){
                System.out.println(query.getObject("NAME"));
                System.out.println(query.getObject("PASSWORD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcutils.release(connection,statement,rs);
        }
    }
}
```

## 10.5 PreparedStatement对象

PreparedStatement可以房主SQL注入,效率更好

增

```java
package com.zz.lesson03;

import com.zz.lesson02.utils.JdbcUtils;
import java.util.Date;
import java.sql.*;

public class TestInsert {
    public static void main(String[] args) {
        Connection cnn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cnn = JdbcUtils.getConnection();
            //区别
            //使用?占位符
            String sql = "INSERT INTO `users`(`id`,`NAME`,`PASSWORD`,`email`,`birthday`) VALUES(?,?,?,?,?)";
            pstm = cnn.prepareStatement(sql);//预编译SQL，先写SQL，不执行
            pstm.setInt(1,4);
            pstm.setString(2,"asda");
            pstm.setString(3,"asda");
            pstm.setString(4,"asda");
            //util.Date 与 sql.Date 不同
            pstm.setDate(5,new java.sql.Date(new Date().getTime()));

            int i = pstm.executeUpdate();
            if(i>0){
                System.out.println("成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,pstm,rs);
        }
    }
}

```

删

```java
package com.zz.lesson03;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestDelete {
    public static void main(String[] args) {
        Connection cnn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cnn = JdbcUtils.getConnection();
            //区别
            //使用?占位符
            String sql = "delete from `users` where `id` = ?";
            pstm = cnn.prepareStatement(sql);//预编译SQL，先写SQL，不执行
            pstm.setInt(1,4);



            int i = pstm.executeUpdate();
            if(i>0){
                System.out.println("成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,pstm,rs);
        }
    }
}

```

改

```java
package com.zz.lesson03;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestUpdate {
    public static void main(String[] args) {
        Connection cnn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cnn = JdbcUtils.getConnection();
            //区别
            //使用?占位符
            String sql = "update `users` set `name` =? where id = ?";
            pstm = cnn.prepareStatement(sql);//预编译SQL，先写SQL，不执行
            pstm.setString(1,"zz");
            pstm.setInt(2,2);

            //util.Date 与 sql.Date 不同


            int i = pstm.executeUpdate();
            if(i>0){
                System.out.println("成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,pstm,rs);
        }
    }
}

```

查

```java
package com.zz.lesson03;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TestSelect {
    public static void main(String[] args) {
        Connection cnn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cnn = JdbcUtils.getConnection();
            //区别
            //使用?占位符
            String sql = "select * from `users` where `id` =?";
            pstm = cnn.prepareStatement(sql);//预编译SQL，先写SQL，不执行
            pstm.setInt(1,1);



            rs = pstm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(cnn,pstm,rs);
        }
    }
}

```

SQL注入

```java
package com.zz.lesson03;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.*;

public class TestSQLInject {
    public static void main(String[] args) throws SQLException {
        login("' or '1=1","' or '1=1");
        login("zz","123456");
    }
    public static  void login(String username,String password) throws SQLException {
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        try {
            //SELECT * FROM `users` WHERE `NAME`='' or 1=1 AND `PASSWORD`='' or 1=1 ;
            //获取连接
            conn = JdbcUtils.getConnection();
            //PrepareStatement 防止SQL注入的本质，把传递进来的参数当作字符
            //其中存在转义字符会被直接转义
            //sql
            String sql="SELECT * FROM `users` WHERE `NAME`= ? AND `PASSWORD`=?";
            //查询获取返回集合
            st = conn.prepareStatement(sql);

            st.setString(1,username);
            st.setString(2,password);
            rs = st.executeQuery();
            //遍历
            while (rs.next()){
                System.out.println(rs.getObject("NAME"));
                System.out.println(rs.getObject("PASSWORD"));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}

```

## 10.7使用IDEA连接数据库

添加数据库

![image-20200808195903296](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808195903296.png)

选择数据库![image-20200808202246383](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808202246383.png)

编写SQL语句

![image-20200808202312433](C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200808202312433.png)

## 10.8 事务

==要么都成功,要么都失败==

> ACID原则

原子性 一致性 隔离性 持久性

> 代码实现

1. 开启事务
2. 一组业务执行完毕,提交事务
3. 可以在catch语句中显示的定义回滚语句,但默认失败就会回滚

```java
package com.zz.lesson04;

import com.zz.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction1 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            conn.setAutoCommit(false);


            String sql1 = "update account set money = money - 100 where NAME =  'a'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();
            String sql2 = "update account set money = money + 100 where NAME =  'b'";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            //业务完毕提交事务
            conn.commit();
            System.out.println("成功");

        } catch (SQLException throwables) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}

```

## 10.9 数据库连接池

数据库连接-执行完毕-释放

连接-释放 十分浪费系统资源

**池化技术:准备一些预先的资源,过来就连接预先准备好的**

最小连接数

最大连接数:业务最高承载上限

超过最大连接数,排队等待

等待超时:

编写连接池,实现一个接口 DataSource

> 开源数据源实现

DBCP

C3P0

Druid:阿里巴巴

使用了这些数据库连接池之后，在项目开发中就不需要编写连接数据库的代码了

> DBCP

需要用到

commons-dbcp-1.4、commons-pool-1.6

> C3P0

需要用到

 c3p0-0.9.5.5.jar 、mchange-commons-java-0.2.19.jar

> 结论

无论使用什么数据源，本质还是一样的，DataSource接口不会变