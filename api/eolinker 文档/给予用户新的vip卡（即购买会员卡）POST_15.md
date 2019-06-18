##给予用户新的vip卡（即购买会员卡）

**请求协议|请求方法**：HTTP|POST

**接口路径**：/vip

**接口使用状态**：正在测试

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
|userId|用户ID|是|[string]||303bebcb72d848d79604f3ea729af51e|
|cardBalance|购买之后的余额|是|[number]||500.00|
|ownDate|购卡日期|是|[string]||2018-05-09|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[int]|||200|
|data||是|[object]||||
|data>>VIPCardId|会员卡id|是|[string]|||303bebcb72d848d79604f3ea729af51e|
|data>>VIPLevel|会员等级|是|[string]|||青铜|
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip&resultType=failure
```

```

**详细说明**：

采用刘钦的方式，用银行卡在前端进行假验证，之后直接给后端发送购买之后的余额
对于会员等级，是根据累计充值金额来计算，分黄金、白银、青铜三个段
```
