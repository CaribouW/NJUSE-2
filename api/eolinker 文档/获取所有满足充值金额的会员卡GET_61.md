##获取所有满足充值金额的会员卡

**请求协议|请求方法**：HTTP|GET

**接口路径**：/vip/list

**接口使用状态**：正常启用

**请求头部**：

| 头部标签 | 必填  | 头部内容 | 
| :------------ | :------------ |

**鉴权**：

**验证类型**：
无

**请求参数**
参数类型：Json
根类型: Object

| 参数名 | 说明 | 必填 | 类型 | 值可能性 |  限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|limitation|非必选；默认值为0；筛选出高于该充值金额的所有会员|否|[number]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|data||是|[array]||||
|data>>vipLevel||是|[null]||||
|data>>ownDate||是|[string]|:||2018-05-09T00:00:00.000+0000|
|data>>remainValue||是|[number]|:||500|
|data>>cardId||是|[string]|:||3a58fa2d88be4b9ba843807e62f82ad2|
|data>>userId||是|[string]|:||303bebcb72d848d79604f3ea729af51e|
|message||是|[string]|:||success|
|status||是|[number]|:||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip/list&resultType=failure
```

```

**详细说明**：


```
