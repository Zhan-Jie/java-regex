
使用java的Pattern和Matcher，除了常规的检测整个字符串是否符合正则表达式之外，还可以用来进行连续的字符串查找。
以下示例展示了java正则表达式的2种典型用途。

## 连续查找文本中所有匹配的字符串
```java
Pattern numPat = Pattern.compile("\\d+");
Matcher matcher = numPat.matcher(text);
while (matcher.find()) {
    String target = matcher.group();
    System.out.println(target);
}
```

## 替换文本中所有匹配的字符串
```java
// 将find方法查找到的目标字符串之前的内容，加上replacement，一起追加到StringBuffer
Matcher appendReplacement(StringBuffer sb, String replacement)
// 将find方法查找到的目标字符串之后所有的内容，追加到StringBuffer
StringBuffer appendTail(StringBuffer sb)
```

[代码示例](src/main/java/zhanj/javaregex/App.java)

代码运行结果：
```
======== 使用Matcher查找所有匹配的字符串 =========
text: 'abc123 what 8391 ss'

matcher.group(): '123'
matcher.start(): 3
matcher.end(): 6
matcher.group(): '8391'
matcher.start(): 12
matcher.end(): 16


======== 使用Matcher查找并替换所有匹配的字符串 =======
'123' => '*'
After appendReplacement: 'abc*'
'8391' => '*'
After appendReplacement: 'abc* what *'
Before appendReplacement: 'abc* what *'
After appendReplacement: 'abc* what * ss'
```