##获取排片信息

**请求协议|请求方法**：HTTP|GET

**接口路径**：/schedule/list

**接口使用状态**：正在测试

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
|data||是|[object]||||
|data>>slot||是|[array]||||
|data>>slot>>slotId||是|[string]|:||111|
|data>>slot>>startTime||是|[string]|:||2019-06-13T03:05:10.000+0000|
|data>>slot>>endTime||是|[string]|:||2019-06-14T03:05:21.000+0000|
|data>>slot>>movieId||是|[string]|:||11237|
|data>>slot>>ticketPrize||是|[number]|:||998|
|data>>slot>>hallId||是|[string]|:||12|
|data>>slot>>property||是|[string]|:||fuck|
|message||是|[string]|:||success|
|status||是|[number]|:||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/schedule/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/schedule/list&resultType=failure
```

```

**详细说明**：


```
