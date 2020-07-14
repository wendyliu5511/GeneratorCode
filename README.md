# GeneratorCode（controller、service、mapper）
springboot+mybatise架构,按照数据库表生成全套增删改查代码（生成controller、service、serviceimpl、mapper）
代码生成器使用：
1、修改application.yml  数据库地址、要生成的包名package
2、浏览器访问http://ip地址:60048/sysGenerator/generateCode
3、解压压缩包，放进搭建好的springboot+mybatise框架里面
4、启动
注意：别忘启动类添加@MapperScan
