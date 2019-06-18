##获取所有电影客单价

**请求协议|请求方法**：HTTP|GET

**接口路径**：/movie/statistic/price

**接口使用状态**：正在开发

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
|status||是|[string]||||
|data||是|[array]||||
|data>>name||是|[string]||||
|data>>price|观众购票所花总金额/购票次数|是|[double]||||
|message||是|[string]||||

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/statistic/price
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/statistic/price&resultType=failure
```

```

**详细说明**：


```
