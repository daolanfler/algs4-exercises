# Algorithms 4th Edition Exercise

[一些笔记](https://www.notion.so/daolanfler/Math-in-the-book-d3e9880004774af88d37561095ca9752)

```bash
# 如何运行这个代码呢？
# 首先编译出 class 文件：
# javac-algs4 book/chapter1/section5_UnionFind/QuickFindUF.java
# 然后执行下面的：（注意，没有 .java 的后缀！！！！）
java-algs4 book/chapter1/section5_UnionFind/QuickFindUF < chapter1/section5/tinyInput.txt
```

但是上面的方法会在 QuickFindUF.java 的目录生成一个 QuickFindUF.class 的文件。

```bash
# 当我们使用 IDEA 的时候，编译产物放到了 out 目录，可以这样
java -cp "./out/production/algs4-exercises;./lib/algs4.jar" book/chapter1/section5_UnionFind/QuickFindUF < chapter1/section5/tinyInput.txt
```

使用 java-algs4 也是一样的

很可惜 < chapeter1/section5/tinyInput.txt 作为 args 在 run & debug configurations 里面并不起作用，所以这里还是只能手动运行
https://stackoverflow.com/questions/28920762/intellij-run-config-input-file

如果没有安装 `java-algs4` 可以这样 
```bash
java -cp ./lib/algs4.jar  chapter1/section1/Exercise03.java  12 13 14
```
