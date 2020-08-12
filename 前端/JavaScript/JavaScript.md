# 1 什么是JavaScript

## 1.1 概述

JavaScript是一门世界上最流行的脚本语言

==合格的后端人员必须精通JavaScript==

## 1.2 历史

ECMAScript它可以理解为JavaScript的一个标准

最新版本已经到es6版本~

但是大部分浏览器还只停留在支持es5代码上！

开发环境–线上环境，版本不一致

# 2 快速入门

## 2.1 引入JavaScript

1. 内部引入

   ```javascript
   <script>
   	//...
   </script>
   ```

2. abc.js

   ```javascript
   //...
   ```

   test.html

   ```html
   <script src = "abc.js"></script>
   ```

   

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<!--    script标签内写js代码  -->
<!--    <script>    -->
<!--        alert('hello world');   -->
<!--    </script>   -->

<!--    外部引入    -->
<!--    注意：script标签必须成对出现   -->
    <script src="js/zz.js"></script>
<!--    不用显示定义type  -->
    <script type="text/javascript">

    </script>
</head>
<body>

</body>
</html>
```

## 2.2 基本语法入门

```javascript
    <script>
        // 1.定义变量 变量类型 变量名 = 变量值；
        var num = 1;
        var name = "zz";
        var score = 60;
        // 2. 条件控制
        if (score > 60 && score <70){
            alert("60-70");
        }else if(score > 70 && score <80){
            alert("70-80");
        }else {
            alert("other");
        }
        /*
        * 多行注释
        * */
        //console.log(socre) 在浏览器控制台打印变量
    </script>
```

浏览器调试

![image-20200812190136005](JavaScript.assets/image-20200812190136005.png)

## 2.3 数据类型

数值 文本 图形 音频 视频

==变量==

```javascript
var x = xxx;
```

==number==

js不区分小数和整数

```javascript
123//整数123
123.//浮点数123.1
1.123e3//科学计数法
-99//负数
NaN//not a number
Infinity //无限大
```

==字符串==

‘abc’ “abc”

==布尔值==

true false

==逻辑运算==

&& || !

==比较运算符==

```javascript
= //赋值
== //等于 类型不一样，值一样 也是true
=== //绝对等于 类型一样值一样
```

这是JS的一个缺陷，不要用==比较

注意：

+ NaN===NaN 为false，这个值与所有数值都不想等，包括自己
+ 只能通过isNaN（NaN）来判断这个数是不是NaN

浮点数问题

```javascript
    console.log((1/3)===(1-2/3))
    //false

```

有精度损失，尽量避免使用浮点数进行运算

```javascript
console.log(((1/3)-(1-2/3))<0.00000000001)
// true
```

==null和undefined==

null 空

undefined 未定义

==数组==

一些==列==类型相同的对象

```javascript
//保证代码可读性，尽量使用[]
var arr = [1,2,"hello",null,true]
new arr(1,2,"hello",null,true)
```

取数组下标越界会undefined

==对象==

对象是{} 数组是[]

每个属性直接用逗号隔开，最后一个不需要添加

```javascript
var person{
	name:'zz',
	age:3,
	tages['js','java']
}
```

```javascript
person.name
> zz
```

## 2.4 严格检查模式

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!--
    'use strict'; 严格检查模式，预防JS的随意性产生的一些问题
    必须卸载第一行
    局部变量建议使用let 定义

-->
<script>
    'use strict';
    //全局变量
    i = 1;
    //局部变量
    var i1 = 1;
    //ES6 let
    let i2 = 1;
</script>
<body>

</body>
</html>
```

# 3 数据类型

## 3.1 字符串

1. 正常的字符串使用单引号或双引号包裹
2. 使用转义字符

```javascript
\'
\n
\t
\u4e2t //\u#### Unicode字符
\x41 //Ascll字符
```

3. 多行字符串编写

   ```javascript
       let msg =`hello
       world`
   ```

4. 模板字符串

   ```javascript
       let name = 'zz';
       let age = 3;
       let msg1 = `hello,${name}`
   ```

5. 字符串长度

   ```javascript
   str.length
   ```

6. 字符串可变性：不可变

7. 大小写转换 是方法不是属性

   ```javascript
   str.toUpperCase()
   str.toLowerCase()
   ```

8. ```javascript
   str.indexOf('substr')
   ```

9. ```javascript
   str.substring(1,3) //[} 左闭右开
   str.substring(1) //从第一个到最后一个
   ```

## 3.2 数组

**Array可以包含任意的数据类型**

```javascript
var arr = [1,2,3,4,5]
```

1. 长度

   ```javascript
   arr.length = 10;
   ```

   注意：给arr.length赋值，数组大小会发生变化，赋值国小元素会丢失，过大会得到undefined

2. indexOf 通过元素获得下标所以

   ```javascript
   arr.indexOf(2)
   ```

   字符串的‘1’和数字1不同

3. slice()截取array的一部分，返回一个新的数组，类似于substring

4. push pop

   ```javascript
   arr.push('a','b')
   arr.pop
   ```

5. unshift,shift 头部压入 弹出

   ```
   arr.unshift()
   arr.shift()
   ```

6. 排序 sort

   ```javascript
   ['B','C','A']
   arr.sort()
   ['A','B','C']
   ```

7. 元素反转

   ```javascript
   arr.reverse()
   ['C','B','A']
   ```

8. concat() 拼接字符串 

   ```javascript
   ['C','B','A']
   arr.concat([1,2,3])
   ['C','B','A',1,2,3]
   arr
   ['C','B','A']
   ```

   concat()不改变原来的数组，只是返回一个新数组

9. 连接符 join

   打印拼接数组，使用特定的字符串连接

   ```javascript
   ['C','B','A']
   arr.join
   "C-B-A"
   ```

10. 多维数组

    ```javascript
    arr=[[1,2],[4,5],["5","6"]]
    arr[1][1]
    4
    ```

数组：存储数据（如何存 取）

## 3.3 对象

若干个键值对

```
var 对象名 = {
	属性名：属性值，
	属性名：属性值，
}
```

```javascript
    let person = {
        name:'zz',
        age : 3,
        email:"sadada@qq.com"      
    }
```

JS中的对象，{...}表示一个对象，键值对描述属性 xxx：xxx，多个属性之间使用逗号隔开，最后一个属性不加逗号

JS中的所有键都是字符串，值是任意对象

1. 对象赋值

   ```javascript
   person.name = 'zz'
   ```

2. 使用一个不存在的对象属性不会报错

   ```javascript
   person.haha
   undefined
   ```

3. 动态的删减属性

   ```javascript
   delete person.name
   ```

4. 动态的添加,直接给新的属性添加值即可

   ```
   person.haha = "haha"
   ```

5. 判断属性值是否在这个对象中 xxx in xxx

   ```
   'age' in person
   true
   //继承
   'toString' in person
   true
   ```

6. 判断一个属性是否是这个对象自身拥有的hasOwnProperty（）

   ```javascript
   person.hasOwnProperty('toString')
   false
   person.hasOwnProperty('age')
   true
   ```

## 3.4 流程控制

if判断

```javascript
if (score > 60 && score <70){
    alert("60-70");
}else if(score > 70 && score <80){
    alert("70-80");
}else {
    alert("other");
}
```

循环

while

```javascript
while (age < 100){
	age = age + 1;
}
do (age < 100){
	age = age + 1;
}while (age < 100)
```

for

```javascript
for(let i = 0; i< 100; i++){
	i = i + 1;
}
```

数组循环

```javascript
age.forEach(function (value){
	console.log(value)
})

for(var num in age){
    console.log(age[num])
}
```

3.5 Map和Set

> ES6新特性

Map

```javascript
        var map = new Map([['tom',100],['jack',90],['haha',80]]);
        var name = map.get('tom')；
        map.set('admin',123456)；
        map.delete('tom')；
        console.log(name);
```

Set: 无序不重复集合

```javascript
        var set = new Set([3,1,1,1,1]);//去重
        //[3,1]
        set.add(2);
        set.delete(1);
        console.log(set.has(3));
```

