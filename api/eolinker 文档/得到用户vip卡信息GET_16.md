##得到用户vip卡信息

**请求协议|请求方法**：HTTP|GET

**接口路径**：/vip

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
|userId||是|[string]||303bebcb72d848d79604f3ea729af51e|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[int]|||200|
|data||是|[object]||||
|data>>VIPCardId|会员卡的ID|是|[string]|||61616132184894|
|data>>VIPCardBalance|会员卡余额|是|[number]|||500.00|
|data>>VIPLevel|会员级别|是|[string]|||黄金、白银、青铜|
|data>>ownDate|购买日期|是|[string]|||2019-05-09|
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

得到用户vip卡信息（用于会员页面）
```
