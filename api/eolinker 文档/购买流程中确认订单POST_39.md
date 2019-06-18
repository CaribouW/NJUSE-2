##购买流程中确认订单

**请求协议|请求方法**：HTTP|POST

**接口路径**：/order/confirm

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
|userId|用户id|是|[string]|||
|scheduleId|排片ID|是|[string]|||
|confirmTime|下单时间|是|[string]||2019-05-05 14:00:00|
|seats|座位列表|是|[array]||["3,3","4,4"]|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|data||是|[object]||||
|data>>orderId|订单ID|是|[string]||||
|message||是|[string]|||success|
|status|状态码|是|[number]|||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/order/confirm
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/order/confirm&resultType=failure
```

```

**详细说明**：


```
