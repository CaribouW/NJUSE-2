##根据电影名称关键字搜索电影

**请求协议|请求方法**：HTTP|GET

**接口路径**：/movie/key

**接口使用状态**：正常启用

**请求头部**：

| 头部标签 | 必填  | 头部内容 | 
| :------------ | :------------ |

**鉴权**：

**验证类型**：
无

**GET参数**：

| 参数名 | 说明 | 必填 | 类型 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|key|电影名称，可以是电影名称的子字符串|是|[string]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|data||是|[array]||||
|data>>nation||是|[string]|:||中国大陆,中国香港|
|data>>distributionCompany||是|[null]||||
|data>>hPoster||是|[null]||||
|data>>movieId||是|[string]|:||1203|
|data>>productionCompany||是|[null]||||
|data>>nameEn||是|[null]||||
|data>>video||是|[null]||||
|data>>score||是|[number]|:||9.5|
|data>>timeLength||是|[number]|:||171|
|data>>imdb||是|[null]||||
|data>>uploadDate||是|[null]||||
|data>>videoList||是|[null]||||
|data>>hierarchical||是|[null]||||
|data>>downDate||是|[null]||||
|data>>name||是|[string]|:||霸王别姬|
|data>>stills||是|[null]||||
|data>>briefIntro||是|[null]||||
|data>>category||是|[string]|:||爱情,剧情|
|data>>lang||是|[null]||||
|data>>poster||是|[string]|:||https://p1.meituan.net/movie/20803f59291c47e1e116c11963ce019e68711.jpg@464w_644h_1e_1c|
|message||是|[string]|:||success|
|status||是|[number]|:||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/key
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/key&resultType=failure
```

```

**详细说明**：


```
