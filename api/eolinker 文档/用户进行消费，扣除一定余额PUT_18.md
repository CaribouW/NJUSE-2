##用户进行消费，扣除一定余额

**请求协议|请求方法**：HTTP|PUT

**接口路径**：/order/consume

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
|consumption|消费金额|是|[number]||46.00|
|orderId|订单ID|是|[string]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[int]|||200|
|data||是|[object]||||
|data>>cardBalance|会员卡余额|是|[number]|||360.00|
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/order/consume
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/order/consume&resultType=failure
```

```

**详细说明**：

如果没有expense , 那么就是银行卡消费，只进行订单状态变化如果有，那么就是会员卡消费
```
