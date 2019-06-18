# NJUSE-2
## 软工二大作业

## Null & None 电影院管理系统

- 采用前后端分离的模式，前端开源框架：Vue全家桶
- 后端采用Springboot
- Api 集成管理工具：eolinker

## 作业基本要求

1. 文档部分：

文档内容放置在 `./文档/doc文档` 目录下

额外的补充内容：

- 文档相关联图片：`./文档/img` 目录下
- 团队开发API接口文档：`./api/eilinker 文档` 目录下

2. 代码部分：
   - 前端代码 `./client`
   - 后端代码 `./web-server`

## 环境搭建

#### 开发工具:

- MySql: 数据库
- Tomcat: 应用服务器
- Git: 版本管理
- IntelliJ IDEA: 开发IDE
- Navicat for MySQL: 数据库客户端

#### 开发环境：

- Jdk7+
- Mysql5.5+
- Maven 3

### 本地部署说明

##### 准备工作

- 需要安装
  - `maven`
  - `jdk 1.8` (由于jdk 近期版本不兼容性，使用 jdk 11 之后的版本在本环境下无法正常运行)
- 每次 `clone` 源码之后，需要先进入 `client`包，使用 `npm` 包管理工具进行打包

```
npm install
```

- 建议本地使用 `cnpm install` 镜像打包，或采取 `nrm` 对镜像进行调整

##### 简单部署

- 在 `npm` 依赖安装完成后，进入项目根目录下，输入如下指令

```
mvn package
```

此时项目自动进行构建，最终将 后端的项目内容合并为一个整体 `jar` 包，路径位于 `web-server/target/se-server.war`

- 构建成功后，显示如下内容

```
[INFO] Reactor Summary:
[INFO] 
[INFO] se-server 0.0.1-SNAPSHOT .......................... SUCCESS [ 13.520 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

```

表示所有的内容打包成功。

仍旧在根目录下，输入如下指令

```
java -jar web-server/target/se-server.war
```

项目可以直接运行，并且在浏览器中输入 `localhost:18080` 即可

### 远端直接访问

#### 远端服务器根目录

http://106.14.140.93:8080/se-server/

#### 前端根目录

http://106.14.140.93:8080/client/

#### 团队在线API

<http://106.14.140.93:8081/swagger/index.html>

需要手动设置url根目录 , 现提供本地服务器和远端服务器的连接

#### 账号

账号：audience 密码：12345678 角色：观众<br>
账号：admin 密码：12345678 角色：管理员<br>
账号：manager 密码：12345678 角色：经理<br>