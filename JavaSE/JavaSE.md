# 1 Java基础

## 1.1 注释

+ 单行注释

  //注释

+ 多行注释

  /*

  多行注释

  */

+ 文档注释

  /** 

  *@Author

  *@Description

  */

## 1.2 标识符、关键字

标识符应该以字母 美元符(￥)或者下划线(_)开始

首字母以后可以是字母 美元符(￥)或者下划线(_)的任意组合

不能使用关键字作为标识符

标识符大小写敏感

标识符不建议使用中文或者拼音

## 1.3 数据类型

+ 基本数据类型
  + 数值类型
    + 整数类型
      + byte 占1个字节 -128-127
      + short 2个字节 -32768-32767
      + int 4个字节 -2147483648-2147463647
      + long 8个字节
    + 浮点类型
      + float 4个字节
      + double 8个字节
    + 字符类型
      + char 2个字节
  + boolean 占1个字节  只有true和false
+ 引用数据类型
  + 类
  + 接口
  + 数组

## 1.4 数据类型扩展

+ 二进制 0b 

+ 十进制

+ 八进制 0 

  ```java
  int i2 = 010;//八进制
  ```

+ 十六进制

  ```java
  int i3 = 0x10;//十六进制
  ```

float 带有舍入误差 大约表示 接近但不等于

最好完全避免使用浮点数进行比较 

BigDecimal 类

转义字符 \n \t 

## 1.5 类型转换

运算中，不同类型的数据先转换为同一类型，然后进行运算

低----------------------------------------------------->高

byte,short,char -> int -> long -> float -> double

强制转换  （类型）变量名  高->低

自动转换  低->高

+ 不能对布尔值进行转换
+ 不能把对象类型转换为不相干的类型
+ 在把高容量转换到低容量的时候，强制转换
+ 转换的时候可能存在精度问题或者内存溢出问题

操作比较大的时候，注意溢出问题

JDK7 新特性，数字可以用下划线分割

```java
int money = 1_000_000_000;
```

## 1.6 变量、常量、作用域、作用域

Java是强类型语言，每个变量都必须声明其类型

Java变量是程序中最基本的存储单元，其要素包括变量名，变量类型和作用域。

```java
type varName [=value] [{,varName[=value]}];
```

+ 每个变量都有类型，类型可以是基本类型，也可以是引用类型
+ 变量名必须是合法的标识符
+ 类型声明是一条完整的语句，因此每个声明都必须以分号结束

变量作用域

+ 类变量 static
+ 实例变量 从属于对象，不用初始化 初始值为默认值
+ 局部变量 写在方法里面 必须声明和初始化值

常量（Constant）

+ 初始化之后不能再改变的值 final
+ 一般使用大写字符

命名规范

+ 见名知意
+ 包：全小写
+ 类：大写开头，每个单词首字母大写（驼峰）GodMan
+ 方法：第一个单词首字母小写，后面的单词大写开头 runRun()
+ 变量：首字母小写，后面的单词大写开头 lastNAme
+ 常量：全大写和下划线MAX_VALUE

## 1.7 运算符

+ 算数运算符：+ - * / % ++ --
+ 赋值运算符 =
+ 关系运算符 < <= > >= !=  ==  instanceof
+ 逻辑运算符 && || ！
+ 位运算符 & |  ^ ~ >> << >>>
+ 条件运算符 ？：
+ 扩展赋值运算符 += -= *= /=

# 2 控制流程

## 2.1 Scanner与用户交互

Scanner对象：

+ next（）
  + 一定要读取到有效字符后才可以结束输入
  + 对输入有效字符之前遇到的空白会自动去掉
  + 只有输入有效字符后才将其后面输入的空白作为分隔符或结束符
  + **next（）不能得到带有空格的字符串**
+ nextLine（）
  + 以Enter作为结束符，也就是说nextLine()方法返回的是输入回车前的所有字符
  + 可以得到空白

## 2.2 顺序结构

## 2.3 选择结构

单选择：if（）{}

```java
if(){

}
```

双选择：

```java
if(){

}else{
    
}
```

多选择：

```java
if(){

}else if(){

}else{

}
```

嵌套的if

```java
if(){
	if(){
	
	}
}
```

switch

```java
switch(){
case value:
...
break;
case value:
...
break;
..........
case value:
...
break;
default:
}
```

switch语句中的变量类型可以是

+ byte short int char
+ 从JDK7 开始 开始支持String ，同时case标签必须是字符串常量或字面量

## 2.4 循环结构

+ while

  ```java
  while(){
  //循环内容
  }
  ```

  

+ do...while

  ```java
  do{
  //循环内容
  }while();
  ```

  对于while语句而言，如果不满足条件，则不进入循环

  do...while循环和while循环相似，不同的是do...while至少会执行一次

  while先判断再执行，do...while先执行再判断

+ for

  ```java
  for(初始化;布尔表达式;更新){
  	//代码语句	
  }
  ```

  IDEA快捷键  100.for   等于

  ```java
  for(int i = 0;i < 100;i++){
  
  }
  ```

  

+ JDK5中加入了用于数组的增强型for循环

  ```java
  int[] numbers={10,20,30};
  for(int i:numbers){
  
  }
  ```

  

## 2.5 break continue goto

+ break再任何循环语句的主体部分，均可用break控制循环的流程。break用于强行退出循环，不执行循环中剩余的语句。（在switch也可用）
+ continue 语句用在循环语句体中，用于中止某次循环过程，即跳过循环体中未执行的语句，接着进行下一次是否循环的判定
+ goto未正式使用

# 3 方法

# 3.1 什么是方法

方法是语句的集合，在一起执行一个功能

+ 方法是解决一类问题的步骤的有序组合
+ 方法包含于类或对象中
+ 方法在程序中被创建，在其他地方引用

# 3.2 方法的定义和调用

+ 修饰符：可选 告诉编译器如何调用该方法，定义了该方法的访问类型
+ 返回值类型
+ 方法名 开头小写，后面驼峰
+ 参数类型 
  + 形式参数：在方法被调用时用于接收外界输入的数据
  + 实参：调用方法时实际传给方法的数据
+ 方法体： 包含具体的语句，定义该方法的功能

调用方法：对象名.方法名（实参列表）

当方法返回一个值的时候，方法调用通常被当作一个值。例如：

```java
int larger = max(30,40);
```

如果方法返回值时void，方法调用一定是一条语句。

```java
System.out.println("Hello World");
```

## 3.3 方法的重载

重载就是在一个类中，有相同的函数名称，但形参不同的函数

重载的规则：

+ 方法名称必须相同
+ **参数列表必须不同**（个数不同、类型不同、参数排列顺序不同）
+ 返回类型可以相同也可以不同
+ 仅仅返回类型不同不足以成为方法的重载

## 3.4 可变参数

JDK1.5开始，Java支持传递同类型的参编参数给一个方法

在方法声明中，在指定参数类型后加一个省略号（…）

一个方法中只能指定一个可变参数，它必须是方法的最后一个参数

```java
public static void printMax(doube… numbers){

}
```

## 3.5  递归

递归包含两个部分：

+ 递归头：什么时候不调用。如果没有头，将陷入死循环
+ 递归体：什么时候需要调用自身方法

# 4 数组

## 4.1 数组概述

数组时相同类型数据的有序集合

数组描述的时相同类型的若干个数据，按照一定的先后次序排列组合而成

其中，每一个数据称作一个数组元素，每

个数组元素可以通过一个下标来访问它们

## 4.2 数组声明创建

首先必须声明数组标来，才能在程序中使用数组

```java
dateType[] arrayRefVar;//首选的方法
```

```java
dataType arrayRefVar[];//效果相同，但不是首选方法
```

Java语言使用new操作符来创建数组

```java
dataType[] arrayRefVar = new dataType[arraySize];
```

数组的元素是通过索引访问的，数组索引从0开始

获取数组长度

```java
arrays.length
```

## 4.3 数组初始化

静态初始化

```java
int[] a = {1,2,3};
Man[] mans = {new Man(1,2),new Man(2,2)}
```

动态初始化

```java
int[] a = new int[2];
a[0] = 1;
a[1] = 2;
```

默认初始化

+ 数组是引用类型，他的元素相当于类的实例变量，因此数组一经分配空间，其中的每个元素也被按照实例变量同样的方式被隐式初始化

## 4.4 数组越界

数组的特点：

1. 长度是确定的。数组一旦被创建，它的大小就是不可以改变的。
2. 元素必须是相同类型，不允许出现混合类型
3. 元素可以是任何数据类型，包括基本类型和引用类型
4. 数组变量属于引用类型，数组也可以看成是对象，数组中的每个元素都相当于该对象的成员变量。数组本身就是对象，Java中对象实在堆中的，因此数组无论保存原始类型还是其他对象类型，**数组对象本身是在堆中的**。

下标的合法区间[0-length-1]

```java
int[] a = new int[2];
System.out.println(a[2]);
```

**ArrayIndexOutOfBoundsException**:数组下标越界异常

# 4.5 数组的使用

+ For-Each循环
+ 数组作方法入参
+ 数组作返回值

## 4.6 多维数组

多为数组可以看成是数组的数组，比如二维数组就是一个特殊的一维数组，它的每一个元素都是一个一维数组

二维数组

```java
int a[][] = new int[2][5]
```

可以看作是一个两行五列的数组

# 5 面向对象

5.1 面向对象

+ 面向过程思想
  + 步骤清晰简单，第一步做什么，第二部做什么
  + 面向过程适合处理一些较为简单的问题
+ 面向对象思想
  + 物以类聚，分类的思维模式，思考问题首先会解决问题需要哪些分类，然后对这些分类进行单独思考。最后，才对某个分类下的细节进行面向过程的思索
  + 面向对象适合处理复杂的问题，适合处理多人合作的问题。

对于藐视复杂的事物，为了宏观把握、从整体上合理分析，我们需要使用面向对象的思路来分析整个系统。但是，具体到微观操作，仍然需要面向过程的思路去处理。

## 5.1 什么是面向对象

+ 面向对象变成（Objec-Oriented Programming，OOP）
+ 面向对象的本质就是：以类的方式组织代码，以对象的组织（封装）数据

抽象

三大特性：

+ 封装
+ 继承
+ 多态

从认识论的角度考虑是现有对象后有类。对象，是具体的事物。类，是抽象的，是对对象的抽象

从代码运行的角度考虑是现有类后有对象。类是对象的模板

## 5.2类和对象的创建

类与对象的关系

+  类是依中抽象的数据类型，它是对某一类事物整体描述/定义，但是并不能代表某一个具体的事物
  + 动物、植物、手机、电脑……
  + Person类，Pet类，Car类等，这些类都是用来描述/定义某一类具体的事物应该具备的特点和行为
+ 对象是抽象概念的具体实例
  + 张三就是人的一个具体实例，张三家里的旺财就是狗的一个具体实例
  + 能够体现出特点，展现出功能的是具体的实例，而不是一个抽象的概念

创建与初始化对象

+ 使用new 创建对象
+ 使用new关键字创建的时候，除了分配内存空间之外，还会给创建好的对象进行默认的初始化以及对类中的构造器的调用
+ 类中的构造器也成为构造方法，实在进行创建对象的时候必须要调用的，并且构造器有一下两个特点
  + 必须和类的名字相同
  + 必须没有返回类型，也不能写void
+ 构造器作用
  + new 本质实在调用构造方法
  + 初始化对象的值
+ 注意点
  + 定义有参构造后，必须实例化无参构造
  + IDEA  快捷键  Alt+Insert 快速生成构造器

## 5.3 封装

+ 该露的露，该藏的藏

  + 设计程序追求“高内聚，低耦合”。高内聚就是类的内部数据操作细节自己完成，不允许外部干涉；低耦合：进暴露少量的方法给外部使用。

+ 封装（数据的隐藏）

  + 通常，应该禁止直接访问一个对象中的数据的实际表示，而应该通过操作接口来访问

+ **属性私有，get/set**

  IDEA alt+Insert 生成get/set

+ 作用

  + 提高程序的安全性，保护数据
  + 隐藏代码的实现细节

## 5.4 继承

继承的本质是对某一批类的抽象，从而实现对现实世界更好的建模

**extends**的意思是扩展，子类是父类的扩展

Java中类只有单继承，没有多继承

继承是类和类之间的一种关系，除此之外，类和类之间的关系还有以来，组合，组合等

继承关系的两个类，一个为子类（派生类），一个为父类（基类），子类继承父类，使用关键字extens来表示。

子类和父类之间，从意义上讲应该具有is a的关系

Object类

+ Java中，所有的类都直接或间接的继承Object类

**super关键字**

+ super调用父类的构造方法，必须在构造方法的第一个
+ super必须出现在子类的方法或者构造方法中
+ super和this不能同时调用构造方法

super vs this

+ 代表的对象不同
  + this：本身调用者这个对象
  + super：代表父类对象的应用
+ 前提
  + this：没有继承也可以使用
  + super：只有在继承条件才可以使用
+ 构造方法
  + this（） 本类的构造
  + super（） 父类的构造

**方法的重写**

重写都是方法的重写，与属性无关

重写需要有继承关系，子类重写父类的方法

+ 方法名必须相同
+ 参数列表必须相同
+ 修饰符可以扩大，但不能缩小 父类小，子类大 public>protected>default>private
+ 异常可以缩小不能扩大

为什么重写：

+ 父类的功能子类不一定需要，或者不一定满足

不能重写的：

+ static方法 ，属于类不属于实例
+ final 修饰的方法不能被子类重写
+ private 方法

## 5.5 多态

同一方法可以根据发送对象的不同而采用多种不同的行为方式

一个对象的实际类型是确定的，但可以指向对象的引用的类型有很多

多态的条件

+ 继承关系
+ 方法重写
+ 父类引用指向子类

==和equals()的区别

+ ==既可以判断基本数据类型也可以判断引用数据类型。对于基本数据类型，判断的是值是否相等。对于引用判断类型，判断的是指向的地址是否相等，即是否指向同一个对象
+ equals()是方法法，而非运算符，只适用于引用数据类型。Object类中equals()与==作用相同，比较两个对象的地址值是否相等，即两个引用是否指向同一个对象。重写过的equals()通常是比较两个对象的实体内容（属性）是否相等



## 5.6 instanceof和强制转换

```java
Student student0 = new Student();
Person student1 = new Student();
Object student2 = new Student();
```



```java
x instanceof y
```

 x所指向的对象是不是y的子类

```java
System.out.println(student0 instanceof Student);//true
System.out.println(student0 instanceof Person);//true
System.out.println(student0 instanceof Object);//true
```

**强制转换**

高转低使用强制转换

```java
Student student21 = (Student) student2;
student21.eat();//eat为子类Student的方法
```

低转高会丢失子类方法

```java
Person student01 = student0;
//student01.eat();
```

## 5.7 static

## 5.8 抽象类

**abstract**  修饰符可以用来修饰方法也可以修饰类，如果修饰方法，那么该方法就是抽象方法；如果修饰类，那么该类就是抽象类

抽象类中可以没有抽象方法，但是抽象方法的类一定要声明为抽象类

**抽象类不能使用new关键字来创建对象，它只能用子类继承**

抽象方法只有方法的声明没有方法的实现，它是用来让子类实现的

子类继承抽象类，那么就必须要实现抽象类没有实现的抽象方法，否则该子类也要声明为抽象类

## 5.9 接口

普通类：只有具体实现

抽象类：具体实现和规范（抽象方法）都有

接口：只有规范

接口就是规范，定义是一组规则，体现了现实世界中，如果你是…则必须能…的思想。如果是天使，则必须能飞。如果是汽车，必须能跑

接口的本质是契约，制定好之后大家都要遵守

OO的精髓是对对象的抽象，最能体现这一点的就是接口。讨论设计模式都只针对具备了抽象能力的语言（C++ java C#） 就是因为设计模式所研究的，实际上就是如何合理的去抽象

声明类的关键字是class，声明接口的关键字为interface

接口中所有定义的方法默认为public abstract

总结：

+ 约束
+ 定义方法，不同的实现
+ public abstract
+ public static final
+ 不能被实例化，没有构造方法
+ implements可以实现多个接口
+ 必须要重写接口中的方法

## 5.10内部类

内部类就是在一个类的内部再定义一个类，比如，A类中定义一个B类，那么B类相对A类来说就成为内部类，而A类相对B类来说就是外部类

1. 成员内部类

   内部类可以获得外部类的私有属性

2. 静态内部类

3. 局部内部类

4. 匿名内部类

# 6 异常

## 6.1异常

原件运行过程中，可能遇到输入不合法，文件不存在，内存或硬盘满了等异常情况，叫做异常（Exception）

三类异常：

+ 检查性异常：用户错误或问题引起的异常，无法预见。例如要打开不存在的文件
+ 运行时异常：运行时异常容易被避免，与检查性异常相反，运行时异常再编译时易被忽略
+ 错误：错误不是异常，与JVM相关

异常体系结构

+ Java把异常当作对象来处理，并基础一个个基类java.lang.Throwable作为所有异常的超类
+ 在Java API中已经定义了许多异常类，分为两大类，错误Error和异常Exception

Error

+ Error类由Java虚拟机生成并抛出，大多数错误与代码编写者所执行的操作无关
+ Java虚拟机错误（Virtual MachineError），当JVM不在有继续操作所需的内存资源时，将出现OutofMemoryError，这些异常发生时，JVM一般会选择线程终止
+ 还有发生在虚拟机试图执行应用时，如类定义错误（NoClassDefFoundError）、链接错误（（LinkageError）。这些错误是不可查的，因为它们在应用程序的控制和处理能力之外，而且绝大多数是程序运行时不允许出现的状况。

Exception

+ 在Exception分支中有一个重要的子类RuntimeException（运行时异常）
  + ArrayIndexOutOfBoundException
  + NullPointerException
  + ArithmeticExceotion
  + MissingResourceException
  + ClassNotFoundException
+ 这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生
+ Error与Exception的区别：Error通常是灾难性的致命的错误，是程序无法控制和处理的，当出现这些异常时，JVM一般会选择中止线程；Exception通常情况下是可以被程序处理的，并且在程序中应该尽可能去处理这些异常

## 6.1 捕获和抛出异常

+ 抛出异常
+ 捕获异常
+ 五个关键字
  + try 
  + catch
  + finally
  + throw 主动抛出异常，一般在方法中使用
  + throws 方法处理不了异常，向上抛出

```java
public void test(int a,int b) throws ArithmeticException{
    if(b == 0){
        throw new ArithmeticException();
    }
}
```

## 6.3 自定义异常

使用Java内置的异常类可以描述在编程时出现的大部分异常情况。除此之外，用户还可以自定义异常。用户自定义异常类，只需继承Exception类即可。

在程序中使用自定义异常，答题可分为一下几个步骤：

1. 创建自定义异常类
2. 在方法中通过throw关键字抛出异常对象
3. 如果在当前抛出异常的方法中处理异常，可以使用try-catch语句捕获并处理；否则在方法的声明出通过throws关键字指明要抛出给方法调用者的异常，继续进行下一步操作
4. 在出现异常的方法的调用者中捕获并处理异常

# 7 常用类

## 7.1 String

java.lang.String类代表**不可变**的字符序列

“xxxxx”为该类的一个对象

常见构造方法

+ ```java
  String(String original)
  ```

  创建一个String对象为original的拷贝

+ ```java
  String(char[] value)
  ```

  用一个字符数组创建一个String对象

+ ```java
  String(char[] value,int offset,int count)
  ```

  用一个字符数组从offset项开始的count个字符序列创建一个String对象

String的不可变性

+ 当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
+ 当对现有的字符串进行连接操作时，也需要指定内存区域赋值，不能使用原有的value进行操作
+ 当调用replace()方法修改指定字符或字符串时，也需要重新指定内存区域

String StringBuffer StringBuilder三者的对比

+ String：不可变的字符序列，底层用char[]存储
+ StringBuffer：可变的字符序列，线程安全，效率低，底层用char[]存储
+ StringBuilder：可变的字符序列，JDK5新增，线程不安全，效率高，底层用char[]存储

StringBuffer底层

```java
String str = new String();//char[] value = new char[0];
String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};

StringBuffer sb = new StringBuffer();//char[] value = new char[16];
System.out.println(sb.length());
sb.append('a');
sb.append('b');
System.out.println(sb.length());
StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length()+16]{};
System.out.println(sb2.length());
```

StringBuffer扩容

+ 如果要添加的数据底层数组盛不下了，需要扩容底层的数组
+ 默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中

## 7.2 Date类

构造器使用

+ ```java
  Date date = new Date();
  ```

  创建对应当前时间的Date对象

+ ```java
  new Date = new Date(21312334525L);
  ```

  创建指定时间戳的Date对象

方法使用

+ ```java
  System.out.println(date1.toString());
  ```

  显示当前的年月日时分秒

+ ```java
  System.out.println(data1.getTime());
  ```

  获得时间戳，等同于currentTimeMillis()

SimpleDateFormat

对日期Date类的格式化和解析

两个操作

+ 格式化：日期 ->字符串

  ```java
  SimpleDateFormat sdf = new SimpleDateFormat();
  Date date = new Date();
  System.out.println(date);
  
  String format = sdf.format(date);
  System.out.println(format);
  ```

  

+ 解析：格式化的逆过程 字符串 ->日期

  ```java
  String str = "20-7-25 下午3:02";
  Date parse = sdf.parse(str);
  System.out.println(parse);
  ```

  带参的指定格式的格式化

  ```java
  SimpleDateFormat sdf1 =new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
  String format1 = sdf1.format(date);
  System.out.println(format1);
  ```

Calendar类

抽象类，实例化需要调用

+ Calendar.getInstance()方法

  ```java
  Calendar calendar = Calendar.getInstance();
  ```

+ 子类GregorianCalendar的构造器

set get add getTime setTime操作

```java
int days = calendar.get(Calendar.DAY_OF_MONTH);
calendar.set(Calendar.DAY_OF_MONTH,22);
calendar.add(Calendar.DAY_OF_MONTH,3);
Date date = calendar.getTime();//日历类->Date

Date date1 = new Date();
calendar.setTime(date1);//Date -> 日历类
```

## 7.3 System类

## 7.4 Math类

## 7.5 BigInteger  BigDecimal





