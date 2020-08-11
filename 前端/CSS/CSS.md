![在这里插入图片描述](https://img-blog.csdnimg.cn/20200507153758833.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Bhbl9oMTk5NQ==,size_16,color_FFFFFF,t_70#pic_center)

# 1 CSS

如何学习

1. CSS是什么
2. CSS怎么用（快速入门）
3. **CSS选择器（重点+难点）**
4. 美化网页（文字，阴影，超链接，列表，渐变…）
5. 盒子模型
6. 浮动
7. 定位
8. 网页动画（特效效果）

## 1.1 什么是CSS

Cascading Style Sheet层叠样式表

CSS：表现（美化网页）

字体，颜色，边距，高度，宽度，背景图片，网页定位，网页浮动

## 1.2 发展史

CSS1.0

CSS2.0：DIV（块）+CSS，HTML与CSS结构分离的思想，网页变得简单，SEO

CSS2.1：浮动，定位

CSS3.0：圆角、阴影、动画…浏览器兼容性~

## 1.3 快速入门

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

<!--    规范，<style> 可以编写css代码
        语法：
        选择器{
            声明1；
            声明2；
            ...
        }
        -->
    <style>
        h1{
            color: red;
        }
    </style>
</head>
<body>


<h1>标题</h1>
</body>
</html>
```

html与css分离

html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

<!--    规范，<style> 可以编写css代码
        语法：
        选择器{
            声明1；
            声明2；
            ...
        }
        -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<h1>标题</h1>
</body>
</html>
```

css：

```css
h1{
    color: red;
}
```

css的优势：

1. 内容与表现分离
2. 网页结构表现统一，可以实现复用
3. 样式丰富
4. 建议使用独立于html的css
5. 利于SEO，容易被搜索引擎收录

## 1.4 CSS的三种导入方式

行内样式

```html
<!--行内样式 在标签元素中，编写一个style属性，编写样式-->
<h1 style="color: red">标题</h1>
```

内部样式

```html
<!--    内部样式-->
    <style>
        h1{
            color: green;
        }
    </style>
```

外部样式

```css
/*外部样式*/
h1{
    color: blue;
}
```

```html
<link rel="stylesheet" href="css/style.css">
```

优先级 就近原则

外部样式两种写法

+ 链接式

  ```html
  <!--外部样式-->
      <link rel="stylesheet" href="css/style.css" />
  ```

+ 导入式 CSS2.1

  ```html
  <!--导入式-->
      <style>
          @import url("css/style.css");
      </style>
  ```

# 2 选择器

> 作用：选择页面上的某一个或某一类元素

## 2.1基本选择器

1. 标签选择器 选择一类标签  标签{}

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Title</title>
       <style>
           h1{
               color: red;
           }
           p{
               font-size: 80px;
           }
       </style>
   </head>
   <body>
   <h1>标题</h1>
   <h1>标题</h1>
   <p>12312sa</p>
   </body>
   </html>
   ```

   

2. 类 选择器class 选中所有class属性一致的标签,跨标签,  .class{}

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Title</title>
       <style>
   /*类选择器的格式  .class的名称{}
   好处：可以多个标签归类，是同一个class*/
           .zz{
               color: red;
           }
           .zzz{
               color: green;
           }
           .zzzz{
               color: blue;
           }
       </style>
   </head>
   <body>
   <h1 class="zz">标题</h1>
   <h1 class="zzz">标题</h1>
   <h1 class="zzzz">标题</h1>
   
   <p class="zz">sadasd</p>
   </body>
   </html>
   ```

   

3. id选择器 全局唯一 #id{}

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*id 选择器格式:id必须保证全局唯一
        #id名称{}
        不遵循就近原则 id>class>标签选择器
        */
        #zz{
            color: red;
        }
        .zz{
            color: green;
        }
        h1{
            color: blue;
        }

    </style>
</head>
<body>
<h1 id="zz">标题</h1>
<h1 class="zz">标题</h1>
<h1>标题</h1>
<h1>标题</h1>
<h1>标题</h1>

</body>
</html>
```

优先级: 不遵循就近原则 id>class>标签选择器

## 2.2层次选择器

1. 后代选择器在某个元素的后面 

   ```css
   body p{
       background: red;
   }
   ```

   

2. 子选择器

   ```css
           body>p{
               background: green;
           }
   ```

3. 相邻兄弟选择器

   ```css
           /*相邻兄弟，只有一个（向下）*/
           .p1+p{
               background: chocolate;
           }
   ```

   

4. 通用选择器

```css
        /*通用兄弟选择器 （向下）*/
        .p1~p{background: aqua;
        }
```

## 2.3结构伪类选择器

伪类：伪类对元素进行分类是基于特征(characteristics)而不是它们的名字、属性或者内容

```css
        /*ul的第一个子元素*/
        ul li:first-child{
            background: red;
        }
        /*ul的最后一个子元素*/
        ul li:last-child{
            background: green;
        }
        /*选中p1  定位到父元素，选择当前的第一个元素
        选中当前元素的父元素，选择父元素的第n个,并且只有是当前元素才生效*/
        p:nth-child(2){
            background: aquamarine;
        }
        /*选中父元素下的第n个p元素*/
        p:nth-of-type(2){
            color: yellow;
        }
```

## 2.4 属性选择器

id+class结合

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .demo a{
            float: left;
            display: block;
            height: 50px;
            width: 50px;
            border-radius: 10px;
            background: red;
            text-align: center;
            color: #000000;
            text-decoration: none;
            margin-right: 5px;
            font: bold 20px/50px Arial;
        }
        /*
        存在id属性的元素 a[]{}
        属性名   属性名=属性值（正则）
        */
        a[id]{
            background: yellow;
        }
        a[id=first]{
            background: green;
        }
        /*class中又links的元素  =绝对等于  *=包含 ^=开头  $=结尾*/
        a[class*="links"]{
            color: blue;
        }
        /*选中href中以http开头的元素*/
        a[href^=http]{
            background: black;
        }
    </style>
</head>
<body>
<p class="demo">
    <a href="http://www.baidu.com" class="links item first" id="first">1</a>
    <a href="" class="links item active" target="_blank" title="test" >2</a>
    <a href="" class="link item" >3</a>
    <a href="" class="link item">4</a>
    <a href="http" class="link item">5</a>
    <a href="" class="link item">6</a>
    <a href="" class="link item" id="last">7</a>
</p>
</body>
</html>
```

# 3 美化网页元素

## 3.1 为什么要美化页面

1. 有效传递页面信息
2. 美化网页，页面漂亮才能吸引用户
3. 凸显页面主题
4. 提高用户体验

span标签：重点要突出的字，使用span标签套起来

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        #title1{
            font-size: 50px;
        }
    </style>

</head>
<body>
欢迎学习   <span id="title1">Java</span>
</body>
</html>
```

## 3.2 字体样式

```css
    <style>
<!--
font-family 字体
font-size 字体大小
font-weight 粗细
color 颜色
-->
        body{
            font-family: 楷体;
        }
        h1{
            font-size: 50px;
        }
        .p1{
            font-weight: bolder;
        }
        .p2{
            color: red;
        }
    </style>
```

## 3.3 文本样式

1. 颜色–>color
2. 文本对齐方式–>text-align：center
3. 首行缩进–>text-indent：2em
4. 行高–>line-height：300px；行高跟块高一致就可以上下居中
5. 下划线–>text-decoration

```css
text-align: center;
text-indent: 2em;
line-height: 20px;
text-decoration:underline/*下划线*/
text-decoration:line-through/*中划线*/
text-decoration:overline/*上划线*/
text-decoration:none/*超链接去下划线*/
text-decoration-color: red;/*线的颜色*/
```

