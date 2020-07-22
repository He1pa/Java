# 1 语言基础

## 1.1 基础语法

## 1.2 面向对象

区别：

* 面向过程：**面向过程性能比面向对象高。** 因为类调用时需要实例化，开销比较大，比较消耗资源，所以当性能是最重要的考量因素的时候，比如单片机、嵌入式开发、Linux/Unix 等一般采用面向过程开发。但是，**面向过程没有面向对象易维护、易复用、易扩展**。

* 面向对象：**面向对象易维护、易复用、易扩展。** 因为面向对象有封装、继承、多态性的特性，所以可以设计出低耦合的系统，使系统更加灵活、更加易于维护。但是，**面向对象性能比面向过程低**。

  

### 封装

封装是指把一个对象的状态信息（也就是属性）隐藏在对象内部，不允许外部对象直接访问对象的内部信息。但是可以提供一些可以被外界访问的方法来操作属性。就好像我们看不到挂在墙上的空调的内部的零件信息（也就是属性），但是可以通过遥控器（方法）来控制空调。

### 继承

不同类型的对象，相互之间经常有一定数量的共同点。例如，小明同学、小红同学、小李同学，都共享学生的特性（班级、学号等）。同时，每一个对象还定义了额外的特性使得他们与众不同。例如小明的数学比较好，小红的性格惹人喜爱；小李的力气比较大。继承是使用已存在的类的定义作为基础建立新类的技术，新类的定义可以增加新的数据或新的功能，也可以用父类的功能，但不能选择性地继承父类。通过使用继承，可以快速地创建新的类，可以提高代码的重用，程序的可维护性，节省大量创建新类的时间 ，提高我们的开发效率。

关于继承如下 3 点请记住：

1子类拥有父类对象所有的属性和方法（包括私有属性和私有方法），但是父类中的私有属性和方法子类是无法访问，只是拥有。

2子类可以拥有自己属性和方法，即子类可以对父类进行扩展。

3子类可以用自己的方式实现父类的方法。（以后介绍）。

 

### 多态

多态，顾名思义，表示一个对象具有多种的状态。具体表现为父类的引用指向子类的实例。

多态的特点:

+ 对象类型和引用类型之间具有继承（类）/实现（接口）的关系；

+ 对象类型不可变，引用类型可变；

+ 方法具有多态性，属性不具有多态性；

+ 引用类型变量发出的方法调用的到底是哪个类中的方法，必须在程序运行期间才能确定；

+ 多态不能调用“只在子类存在但在父类不存在”的方法；

+ 如果子类重写了父类的方法，真正执行的是子类覆盖的方法，如果子类没有覆盖父类的方法，执行的是父类的方法

## 1.3 接口

接口相当于特殊的抽象类，定义方式/组成部分与抽象类类似

没有构造方法，不能创建对象

只能定义公开的静态常量（public static final）和公开的抽象方法（public abstract）

**使用方法**：用实现类去实现接口（implements）,必须覆盖所有抽象方法，然后用实现类定义对象。

**与抽象类异同**：

**相同**：

+ 可编译成字节码文件

+ 不能创建对象

+ 可以作为引用类型

+ 具备Object类总所定义的方法

**不同**：

+ 接口所有属性都是公开的静态常量public static final

+ 接口所有方法都是抽象方法 public abstract

+ 接口没有构造方法，动态代码块，静态代码块

**应用**：Java为单继承，当父类方法种类无法满足子类需求时，可实现接口扩充子类能力

**规范**：

1. 任何类在实现接口时，必须实现接口中所有的抽象方法，否则此类为抽象类

2. 实现接口的抽象方法时，访问修饰符必须是public

**常量接口**：将多个常用的表示状态或固定值的变量，以静态常量的形式定义在接口中统一管理

**接口回调**：先有接口的使用者，后有接口的实现者。

## 1.4 容器

## 1.5 异常



<img src="C:\Users\ZZ\AppData\Roaming\Typora\typora-user-images\image-20200717184315565.png" alt="image-20200717184315565" style="zoom:150%;" />

在 Java 中，所有的异常都有一个共同的祖先 java.lang 包中的 Throwable 类。Throwable： 有两个重要的子类：Exception（异常） 和 Error（错误） ，二者都是 Java 异常处理的重要子类，各自都包含大量子类。

### Error（错误）

**是程序无法处理的错误，表示运行应用程序中较严重问题**。大多数错误与代码编写者执行的操作无关，而表示代码运行时 JVM（Java 虚拟机）出现的问题。例如，Java 虚拟机运行错误（Virtual MachineError），当 JVM 不再有继续执行操作所需的内存资源时，将出现 OutOfMemoryError。这些异常发生时，Java 虚拟机（JVM）一般会选择线程终止。

 

这些错误表示故障发生于虚拟机自身、或者发生在虚拟机试图执行应用时，如 Java 虚拟机运行错误（Virtual MachineError）、类定义错误（NoClassDefFoundError）等。这些错误是不可查的，因为它们在应用程序的控制和处理能力之 外，而且绝大多数是程序运行时不允许出现的状况。对于设计合理的应用程序来说，即使确实发生了错误，本质上也不应该试图去处理它所引起的异常状况。在 Java 中，错误通过 Error 的子类描述。

 ### Exception（异常）

**是程序本身可以处理的异常**。Exception 类有一个重要的子类 RuntimeException。RuntimeException 异常由 Java 虚拟机抛出。NullPointerException（要访问的变量没有引用任何对象时，抛出该异常）、ArithmeticException（算术运算异常，一个整数除以 0 时，抛出该异常）和 ArrayIndexOutOfBoundsException （下标越界异常）。

**注意：异常和错误的区别：异常能被程序本身处理，错误是无法处理。**

### try-catch-finally

try 块： 用于捕获异常。其后可接零个或多个 catch 块，如果没有 catch 块，则必须跟一个 finally 块。

catch 块： 用于处理 try 捕获到的异常。

finally 块： 无论是否捕获或处理异常，finally 块里的语句都会被执行。当在 try 块或 catch 块中遇到 return 语句时，finally 语句块将在方法返回之前被执行**。**

finally 块中不建议添加return语句

## 1.6 泛型

泛型：

```java
ArrayList <String> strList = new ArrayList<>()；
```

非泛型： 

```java
ArrayList list = new ArrayList();

list.add(“abc”); list.add(100);
```

遍历时 

```
Object o = list.get(i);
```



使用时强转为String类型 

```
String str = （String）o;
```

会引发ClassCastException异常，编译时没有错，运行时报错。

从JDK 5.0开始，Java引入“参数化类型（parameterized type）”的概念，这种参数化类型称为“泛型（Generic）”。

泛型是将数据类型参数化，即在编写代码时将数据类型定义成参数，这些类型参数在使用之前再进行指明具体类型。

泛型提高了代码的重用性，使得程序更加灵活、安全和简洁。【使用泛型可以避免方法重载需要写多个同名的方法】

在JDK 5.0之前，为了实现参数类型的任意化，都是通过Object类型来处理。但这种处理方式所带来的缺点是需要进行强制类型转换，

此种强制类型转换不仅使代码臃肿，而且要求程序员必须对实际所使用的参数类型已知的情况下才能进行，否则容易引起ClassCastException异常。

从JDK 5.0开始，Java增加对泛型的支持。使用泛型之后就不会出现上述问题。泛型的好处是在程序编译期会对类型进行检查，

捕捉类型不匹配错误，以免引起ClassCastException异常；而且泛型不需要进行强制转换，数据类型都是自动转换的。

泛型经常使用在类、接口和方法的定义中，分别称为泛型类、泛型接口和泛型方法。泛型类是引用类型，在内存堆中。

**泛型的优点：1编译期间检查类型 2 无须数据类型转换 3提高代码复用性**

泛型类：

1. 在没有指定具体数据类型时，按Object类型操作

2. 类型参数只能是类类型，不能时基本数据类型

3. 不同类类型参数构造的泛型类实质上是同一种类

类型擦除：泛型信息只存在于编译期间，在运行时会将泛型信息擦除。

## 1.7 反射

JAVA 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为 java 语言的反射机制。

### 静态编译和动态编译

- **静态编译：**在编译时确定类型，绑定对象
- **动态编译：**运行时确定类型，绑定对象

### 反射机制优缺点

- **优点：** 运行期类型的判断，动态加载类，提高代码灵活度。
- **缺点：** 性能瓶颈：反射相当于一系列解释操作，通知 JVM 要做的事情，性能比直接的 java 代码要慢很多。

### 反射的应用场景

**反射是框架设计的灵魂。**

在我们平时的项目开发过程中，基本上很少会直接使用到反射机制，但这不能说明反射机制没有用，实际上有很多设计、开发都与反射机制有关，例如模块化的开发，通过反射去调用对应的字节码；动态代理设计模式也采用了反射机制，还有我们日常使用的 Spring／Hibernate 等框架也大量使用到了反射机制。

举例：① 我们在使用 JDBC 连接数据库时使用 `Class.forName()`通过反射加载数据库的驱动程序；②Spring 框架也用到很多反射机制，最经典的就是 xml 的配置模式。Spring 通过 XML 配置模式装载 Bean 的过程：1) 将程序内所有 XML 或 Properties 配置文件加载入内存中; 2)Java 类里面解析 xml 或 properties 里面的内容，得到对应实体类的字节码字符串以及相关的属性信息; 3)使用反射机制，根据这个字符串获得某个类的 Class 实例; 4)动态配置实例的属性

## 1.8 注解

JDK5.0引入

**作用**：

不是程序本身，可以对程序做出解释

可以被其他程序（编译器）读取

**格式**：以  @注释名  存在，可以添加参数值，例如 @SuppressWarings(value=”unlocked”).

**使用位置**：在package class method field 使用，可以通过反射机制实现对元数据的访问

**内置注解**：

Override ： 重写

Deprecated ： 不推荐使用，或有更好的方式，但可以使用

SuppressWarnings ：镇压警告，需要参数

**元注解** ： 负责注解其他注解 有4个标准的元注解 Target Retention Document Inherited

Target：描述注解的适用范围

Retention：表示需要在什么级别保存注解信息，用于描述注解的生命周期

（SOURCE<CLASS<RUNTIME）

Document：说明该注解将被包含在javadoc中

Inherited：说明子类可以继承父类中的该注解

## 1.9 I/O

IO流分类：

- 按照流的流向分，可以分为输入流和输出流；

- 按照操作单元划分，可以划分为字节流和字符流；

- 按照流的功能划分为节点流和处理流。

  |        |   字节流    | 字符流 |
  | :----: | :---------: | :----: |
  | 输入流 | InputStream | Reader |
  | 输出流 | OutputSream | Writer |

  节点流类型

  |     类型      | 字符流                               | 字节流                                         |
  | :-----------: | ------------------------------------ | ---------------------------------------------- |
  |     File      | FileReader<br />FileWriter           | FileInputStream <br />FileOutputSream          |
  | Memory Array  | CharArrayReader<br />CharArrayWriter | ByteArrayInputStream<br />ByteArrayOutputSream |
  | Memory String | StringReader<br />StringWriter       |                                                |
  |     Pipe      | PipedReader<br />PipedWriter         | PipedInputStream<br />PipedOutStream           |

  处理流类型

  | 处理类型                               | 字符流                                    | 字节流                                        |
  | -------------------------------------- | ----------------------------------------- | --------------------------------------------- |
  | Buffering                              | BufferedReader<br />BufferedWriter        | BufferedInputStream<br />BufferedOutputStream |
  | Filtering                              | FilterReader<br />FilterWriter            | FilterInputStream<br />FilterOutputStream     |
  | Converting between bytes and character | InputStreamReader<br />OutputStreamWriter |                                               |
  | Object Serialization                   |                                           | ObjectInputStream<br />ObjectOutputStream     |
  | Data conversion                        |                                           | DataInputStream<br />DataOutputStream         |
  | Counting                               | LineNumberReader                          | LineNumberInputStream                         |
  | Peeking ahead                          | PushbackReader                            | PushbackInputStream                           |
  | Printing                               | PrintWriter                               | PrintStream                                   |

  **BIO NIO AIO**

  

## 1.10枚举

使用枚举会有更强的类型约束，编译器帮助检查入参类型，规避风险

**常用方法**：

+ ordinal 序数

+ name 名称 

+ valueOf 根据字符串取枚举对象

**扩展**：

+ 在枚举类中可以声明属性、构造函数和方法

+ 常量必须在一开始定义，构造方法只能用private修饰

**专用于枚举的集合类** EnumSet/EnumMap

**使用枚举实现设计模式**：单例模式/策略模式

# 2 JVM

# 3 多线程/并发











