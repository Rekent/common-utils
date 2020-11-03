# 常用工具类
该项目是一个Java常用的方法工具类集合，开发者可以通过maven、或者直接引入jar文件的形式来使用他，以便更快的构建项目。
本项目为本人自用的常用工具依赖项目，会根据自身进度更进一些常用工具类，也欢迎提供有意思的Feature，若有时间也乐于实现。

---
Table of Contents
=================

- [特性](#特性)
- [使用方法](#使用方法)
- [更新历史](#更新历史)
	- [v0.0.1](#v0.0.1)
	- [v0.0.2](#v0.0.2)
	- [v0.0.3](#0.0.3) 	

---

## 特性
- Base on `jdk 1.8`
- Base on Maven
- Thrid Dependencies
  - org.jdom.jdom
  - com.fasterxml.jackson.core.jackson-databind

---

## 使用方法
下载jar文件：[下载地址](https://github.com/Rekent/common-utils/releases)

### maven引入
将项目Jar包下载到目的后，使用maven命令同步到本地仓库，或者上传到线上仓库使用，本地安装的命令见下：
```
mvn install:install-file -Dfile=common-utils-0.0.3.jar
 -DgroupId=com.rekent.tools -DartifactId=common-utils -Dversion=0.0.3 -Dpackaging=jar
```

### 直接引入jar文件

---

## 更新历史

### v 0.0.1 

基本的工具方法，具体见下：
- 基本工具
	-  StringUtils：字符串相关工具类：判空，判等
	- CollectionUtils：集合相关工具类：判空
	- DateUtils：日期相关工具类：格式转换（字符串<->日期），特定日期获取（当前周开始结束日、当前月开始结束日）
	- RandomUtils：随机生成工具类：生成随机字符串、生成随机数字
- 文件流工具
	- FileTypeUtils：文件类型工具类：根据文件名称判断，根据文件字节流魔数判断，针对独立的Office:Docx/Xlxs判断（依赖 org.jdom）
	- FileUtils：文件读写工具类：针对本地文件读写，获取文件名
	- IOUtils：字节流以及字节操作工具类：字节流 <-> 字节操作
- 编码工具
	- JsonUtils：Josn转换工具类：Json字符串 <-> Object，基于jackson-databind
	- Base64Utils：Base64工具类，支持普通编码以及URL编码，基于java.util.Base64
	- HexUtils：16进制转换工具类
	- UnicodeUtils：Unicode转换工具类
- 摘要计算工具
	- MD5Utils：MD5 摘要计算工具类
	- SHA256Utils：SHA256 摘要计算工具类
	- HmacMD5Utils：HmacMD5 摘要计算工具类
	- HmacSHA256Utils：HmacSHA256 摘要计算工具类
- 加密工具
	- AESUtils：AES 加密工具类支持设置工作模式以及填充模式
	- DESUtils：DES 加密工具类支持设置工作模式以及填充模式
	- RSAUtils：RSA 对称密钥加密工具类，支持公钥加解密以及私钥加解密

---

### v0.0.2
- 修复JsonUtils工具类中serializeObject序列化方法无法调用问题
- 修复JsonProcessingException异常无法正常抛出问题

---

### v0.0.3
- 摘要计算工具类支持SHA1
- 增加种子文件工具类，支持解析本地种子文件结构（返回Map格式），支持种子文件哈希值计算，磁力链接生成等

```java
String path = "C:\\Users\\richa\\Downloads\\Friends.S07.720p.BluRay.x264-PSYCHD[btbtt.co].torrent";
TorrentFile torrentFile = TorrentFileUtils.resolve(path);
System.out.println(torrentFile.print());
System.out.println(torrentFile.getHash());
System.out.println(torrentFile.getMagnetUri());
```
