##获取所有电影

**请求协议|请求方法**：HTTP|GET

**接口路径**：/movie/list

**接口使用状态**：正常启用

**请求头部**：

| 头部标签 | 必填  | 头部内容 | 
| :------------ | :------------ |

**鉴权**：

**验证类型**：
无

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|data||是|[array]||||
|data>>nation||是|[string]|:||中国香港|
|data>>distributionCompany||是|[string]|:||华纳|
|data>>hPoster||是|[string]|:||1|
|data>>movieId||是|[string]|:||11237|
|data>>productionCompany||是|[string]|:||华纳|
|data>>nameEn||是|[string]|:||afeizhengzhuan|
|data>>video||是|[string]|:||1|
|data>>score||是|[number]|:||8.8|
|data>>timeLength||是|[number]|:||94|
|data>>imdb||是|[string]|:||888888|
|data>>uploadDate||是|[string]|:||2019-06-12|
|data>>videoList||是|[string]|:||1|
|data>>hierarchical||是|[string]|:||R18|
|data>>downDate||是|[string]|:||2019-06-13|
|data>>name||是|[string]|:||阿飞正传|
|data>>stills||是|[string]|:||1|
|data>>state||是|[number]|:||0|
|data>>briefIntro||是|[string]|:||阿飞正传真好看！|
|data>>category||是|[string]|:||剧情,爱情,犯罪|
|data>>lang||是|[string]|:||中文|
|data>>poster||是|[string]|:||https://p0.meituan.net/movie/885fc379c614a2b4175587b95ac98eb95045650.jpg@464w_644h_1e_1c|
|message||是|[string]|:||success|
|status||是|[number]|:||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/list&resultType=failure
```

```

**详细说明**：


```
