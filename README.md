# CommonUtils
- Base on `jdk 1.8`

#  Introduction

## 常用工具类

### StringUtils

```
字符串相关工具类：判空，判等
```

- boolean isBlank(CharSequence charSequence)
- boolean isNotBlank(CharSequence charSequence)
- boolean isAnyBank(CharSequence... charSequences)
- boolean isAllBlank(CharSequence... charSequences)
- boolean equals(CharSequence arg0, CharSequence arg1)

### CollectionUtils

```
集合相关工具类：判空
```

- boolean isEmpty(Collection<?> collection)
- boolean isNotEmpty(Collection<?> collection)

### DateUtils

```
日期相关工具类：格式转换（字符串<->日期），特定日期获取（当前周开始结束日、当前月开始结束日）
```

- String toStringByFormat(Date date, String format)
- Date toDateByFormat(String date, String format) 
- Date changeDate(Date date, int field, int value) 
- Date startofthisWeek(Date date, int firstDayofWeek)
- Date endofthisWeek(Date date, int firstDayofWeek)
- Date startofthisMonth(Date date)
- Date endOfMonth(Date date)

### FileTypeUtils

```
文件类型工具类：根据文件名称判断，根据文件字节流魔数判断，针对独立的Office:Docx/Xlxs判断（依赖 org.jdom）
```

- String determineByName(String name)
- String determineByMagicNum(byte[] fileBytes)
- boolean isDocx(InputStream input)
- boolean isXlsx(InputStream input)

### FileUtils

```
文件读写工具类：针对本地文件读写，获取文件名
```

- byte[] readLocalFiles(String path)
- writeLocalFiles(byte[] fileBytes, String path, OpenOption option)
- String getFileName(String fileName)

### IOUtils

```
字节流以及字节操作工具类：字节流 <-> 字节操作
```

- void safetyClose(Closeable closeable)
- byte[] readStreamAsBytes(InputStream stream)
- String readStreamAsString(InputStream stream, String charset)
- String readByteArrayAsHex(byte[] byteArray, int limit)

### RandomUtils

```
随机生成工具类：生成随机字符串、生成随机数字
```

- String randomString(int length) 
- int randomNum(int min, int max)

### JsonUtils

```
Josn转换工具类：Json字符串 <-> Object，基于jackson-databind
```

-  String serializeObject(Object object)
- T deserializeObject(String text, Class<? extends T> clazz)
- T deserializeArray(String text, TypeReference<T> typeReference)

## 编码工具类

### Base64Utils

```
Base64工具类，支持普通编码以及URL编码，基于java.util.Base64
```

- String encode(String arg0)
- String decode(String arg0)
- String urlEncode(String arg0) 
- String urlDecode(String arg0)

### HexUtils

```
16进制转换工具类
```

- String toHexString(byte[] arg0)
-  String toHexString(byte[] arg0, boolean toLowerCase)
- byte[] toPlainText(String arg0)

### UnicodeUtils

```
Unicode转换工具类
```

- String toUnicode(String arg0)
- String toPlainText(String arg0)

## 哈希工具类

### MD5Utils

```
MD5 摘要计算工具类
```

- String toMD5(String arg0)
- String toMD5(byte[] arg0)

### SHA256Utils

```
SHA256 摘要计算工具类
```

- String toSHA256(String arg0)
- String toSHA256(byte[] arg0)

### HmacMD5Utils

```
HmacMD5 摘要计算工具类
```

- String toHmcMD5(String arg0, byte[] key)
- String toHmacMD5(byte[] arg0, byte[] key)

### HmacSHA256Utils

```
HmacSHA256 摘要计算工具类
```

- String toHmacSHA256(String arg0, byte[] key)
- String toHmacSHA256(byte[] arg0, byte[] key)

## 加密工具类

### AESUtils

```
AES 加密工具类支持设置工作模式以及填充模式
```

- String encrypt(String arg0, String mode, String padding, String key)
- String decrypt(String arg0, String mode, String padding, String key)

### DESUtils

```
DES 加密工具类支持设置工作模式以及填充模式
```

- String encrypt(String arg0, String mode, String padding, String key)
- String decrypt(String arg0, String mode, String padding, String key)

### RSAUtils

```
RSA 对称密钥加密工具类，支持公钥加解密以及私钥加解密
```

- byte[] decryptByPrivateKey(byte[] arg0, byte[] privateKey)
- byte[] decryptByPublicKey(byte[] arg0, byte[] publicKey)
- byte[] encryptByPrivateKey(byte[] arg0, byte[] privateKey)
- byte[] encryptByPublicKey(byte[] arg0, byte[] publicKey)