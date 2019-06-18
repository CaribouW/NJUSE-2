##获取用户历史充值记录

**请求协议|请求方法**：HTTP|GET

**接口路径**：/vip/history/list

**接口使用状态**：正在测试

**请求头部**：

| 头部标签 | 必填  | 头部内容 | 
| :------------ | :------------ |

**鉴权**：

**验证类型**：
无

**GET参数**：

| 参数名 | 说明 | 必填 | 类型 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|userId|用户ID|是|[string]||303bebcb72d848d79604f3ea7|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[int]|||200|
|data|充值记录列表对象|是|[object]||||
|data>>rechargeList|充值记录列表（时间顺序）|是|[array]||||
|data>>rechargeList>>time|充值时间|是|[string]|||2019-05-09 19:00|
|data>>rechargeList>>amount|充值金额|是|[number]|||100.00|
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip/history/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip/history/list&resultType=failure
```

```

**详细说明**：


```
