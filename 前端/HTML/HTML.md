# 1 初始HTML

什么是HTML

HTML：Hper Text Markup Langueage（超文本标记语言）

超文本：包括文字、图片、音频、视频、动画等

优势：

+ 浏览器厂商支持
  + 微软
  + Google
  + 苹果
  + Opera
  + Mozilla
+ 市场需求
+ 跨平台

W3C标准

+ World Wide Web Consortium（万维网联盟）
+ 成立于1994年，Web技术领域最权威和最具影响力的国际中立性技术标准机构
+ http://www.w3.org/

W3C的标准

+ 结构化标准语言HTML XML
+ 表现标准语言 CSS
+ 行为标准 DOM ECMAScript

```html
<!--DOCTYPE 告诉浏览器用什么规范-->
<!DOCTYPE html>
<html lang="en">
<!--head标签 代表网页头部-->
<head>
<!--    meta描述性标签，用来描述网站的信息-->
<!--    一般用来做SEO-->
    <meta charset="UTF-8">
    <meta name="keywords" content="学Java">
    <meta name="description" content="可以学习java">
<!--    网页标题-->
    <title>Title</title>
</head>
<!--网页主题-->
<body>
hello world
</body>
</html>
```



# 2 网页基本标签

- 标题标签				
- 段落标签               
- 换行标签          
- 水平线标签 
- 注释和特殊符号

# 3 图像，超链接，网页布局

## 常见的图像格式

+ JPG
+ GIF
+ PNG
+ BMP
+ ...

```html
<!--img学习
src:图片地址
    相对地址（推荐使用），绝对地址
    ../返回上一级目录  -->
<img src="../resouces/image/1.jpg" alt="图片" title="悬停文字" width="300" height="300">
```



## 链接：

+ 文本超链接
+ 图像超链接

锚链接

```html
<!--锚链接
1.需要一个锚标记
2.跳转到标记-->
<a name="top">顶部</a>
<a href="#top">回到顶部</a>
```

功能性链接

```java
<!--功能性连接
邮件连接：mailto
QQ链接-->
<a href="mailto:123456789@qq.com">点击联系我</a>
```

## 行内元素

块元素：无论内容有多少，元素自己独占一行 

+ p h1-h

行内元素：内容撑开宽度，左右都是行内元素的可以排在一行

+ a strong em

# 4 列表，表格，媒体元素

## 列表标签

什么是列表

​		列表就是信息资源的一种展示形式。它可以使信息结构化和条理化，并以列表的样式显示出来，以便浏览者能更快捷地获得相应的信息。

列表的分类：

- 无序列表
- 有序列表
- 定义列表

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tittle</title>
</head>
<body>
<!--有序列表-->
<ol>
    <li>Java</li>
    <li>Python</li>
    <li>C</li>
    <li>C++</li>
</ol>


<!--无序列表-->
<ul>
    <li>Java</li>
    <li>Python</li>
    <li>C</li>
    <li>C++</li>
</ul>
<!--自定义列表
dl 标签
dt 标题
dd列表内容-->
<dl>
    <dt>学科</dt>
    <dd>Java</dd>
    <dd>Python</dd>
    <dd>C</dd>
    <dd>C++</dd>
</dl>
</body>
</html>
```

## 表格标签

为什么使用表格

+ 简单通用
+ 结构稳定

基本结构

+ 单元格
+ 行
+ 列
+ 跨行
+ 跨列

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格学习</title>
</head>
<body>
<!--表格table
行 tr rows
列 td-->
<!--border表格的边框-->
<table border="1px">
    <tr>
        <!--colspan 跨列        -->
        <td colspan="4">1-1</td>
    </tr>
    <tr>
        <!--rowspan跨行-->
        <td rowspan="2">2-1</td>
        <td>2-2</td>
        <td>2-3</td>
        <td>2-4</td>
    </tr>
    <tr>
        <td>3-1</td>
        <td>3-2</td>
        <td>3-3</td>
    </tr>
</table>
</body>
</html>
```

## 媒体元素

+ 视频
  + video
+ 音频
  + audio

```html
<!--音频和视频
src：资源路径
controls：控制调
autoplay：自动播放-->
<video src="../resources/video/2.mp4" controls autoplay></video>
<audio src="../resources/audio/3.mp3" controls autoplay></audio>
```

# 5 表单及表单应用

页面结构分析

| 元素名  | 描述                                           |
| ------- | ---------------------------------------------- |
| header  | 标题头部区域的内容（用于页面或页面中的一部分） |
| footer  | 标记脚部区域的内容（用于页面或页面中的一部分） |
| section | Web页面中的一块独立区域                        |
| article | 独立的文章内容                                 |
| aside   | 相关内容或应用                                 |
| nav     | 导航类辅助内容                                 |

页面结构

```html
<header>
    <h2>网页头部</h2>
</header>
<section>
    <h2>网页主体</h2>
</section>
<footer>
    <h2>网页脚部</h2>
</footer>
<!--导航 nav-->
<nav></nav>
```

内联框架

```html
<!--iframe内联框架
src：地址
w-h：宽，高-->
<iframe src="" name="change" frameborder="0" width="1000" height="800">点击跳转学习java</iframe>
<a href="https://www.baidu.com" target="change" >点击跳转</a>

```



# 6 表单初级验证

表单

```html
    <h1>注册</h1>
    <!--表单form
    action:表单提交的位置，可以是网站，也可以是一个请求处理地址
    method:post，get 提交方式
        get方式提交：我们可以在url中看到我们提交的信息，不安全，但高效
        post：比较安全，传输大文件-->
    <form action="基本标签.html" method="post">
        <!--文本输入框 Input type="text"  submit提交按钮 reset重置按钮  -->
        <p>名字：<input type="text" name="username"/></p>
        <p>密码：<input type="password" name="pwd"/></p>
        <p>
            <input type="submit">
            <input type="reset">
        </p>
    </form>
```

表单元素格式

| 属性      | 说明                                                         |
| --------- | ------------------------------------------------------------ |
| type      | 指定元素类型，text password checkbox radio submit reset file hidden image button 默认为text |
| name      | 指定表单元素的名称                                           |
| value     | 元素的初始值，type为radio时必须指定一个值                    |
| size      | 指定表单元素的初始宽度，当type类型为text或password时，表单元素的大小以字符为单位，其他类型以像素为单位 |
| maxlength | type为text或者password时输入的最大字符数                     |
| checked   | type为radio或checkbox时，指定按钮是否被选中                  |

单选框

```html
        <!--单选框按钮
          name表示组
          name必须为一致，才能表示为同一组，才能只选择一个
          input标签 类型是radio时，必须有value-->
        <p>
            <input type="radio" value="boy" name="sex">男
            <input type="radio" value="girl" name="sex">女
        </p>
```

复选框

```html
<p>爱好：
    <input type="checkbox" value="1" name="hobbis">抽烟
    <input type="checkbox" value="2" name="hobbis">喝酒
    <input type="checkbox" value="3" name="hobbis">烫头
</p>
```

按钮

```html
<!--    按钮
    input type="button" 普通按钮
    input type="image"  图片按钮
-->
<p>
    <input type="button" name="btn1" value="按钮名字"/>
    <input type="image" src="../resources/image/1.jpg"/>
</p>
```

下拉框

```html
<!--下拉框 列表框
    <select>
    name是下拉框的名字
    option value 是下拉框可以选择的值
    selected是默认为那个列
-->
<p>国家
    <select name="列表名称" >
        <option value="china" selected>中国</option>
        <option value="us">美国</option>
        <option value="agt">阿根廷</option>
        <option value="md">缅甸</option>
    </select>
</p>
```

文本域

```html
        <!--    文本域
        cols="30" rows="10" 行，，，列
        -->
        <p>反馈：
            <textarea name="textarea"  cols="30" rows="10">文本内容</textarea>
        </p>
```

文件域

```html
<!--    文件域

-->
<p><input type="file" name="files">
    <input type="button" value="上传" name="upload">
</p>
```

功能验证

```html
        <!--  邮箱验证  -->
        <p>邮箱
            <input type="email" name="email">
        </p>
        <!--    URL验证-->
        <p>url
            <input type="url" name="url">
        </p>
        <!--    数字验证
        max最大数量
        min 最小数量
        step 每次点击增加或减少的数量-->
        <p>数字
            <input type="number" name="num" max="100" min="1" step="1">
        </p>
        <!--滑块-->
        <p>音量
            <input type="range" name="voice" max="100" min="0" step="2" >
        </p>
        <!--    搜索框-->
        <p>搜索
            <input type="search" name="search">
        </p>

```

### 表单的应用

+ 隐藏域
+ 只读
+ 禁用

只读：value=“admin”（先给一个默认值） readonly

禁用：disabled

隐藏：hidden

单词：description 描述      content内容

为什么要进行表单验证？

常用方式：

+ placeholder 提示（请输入用户名）
+ required 设置非空
+ pattern 正则表达式