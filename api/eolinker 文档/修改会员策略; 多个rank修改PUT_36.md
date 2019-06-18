##修改会员策略; 多个rank修改

**请求协议|请求方法**：HTTP|PUT

**接口路径**：/vip/strategy

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
|vipRank||是|[array]|||
|vipRank>>rechargePrice||是|[number]||3|
|vipRank>>rankName||是|[string]||as|
|vipRank>>rank||是|[string]||asd|
|vipRank>>discount||是|[number]||32|
|vipRank>>id|如果不存在，就是添加操作;如果存在，就是修改|是|[string]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|data||是|[object]||||
|message||是|[string]|||success|
|status|状态码|是|[number]|||200|

**数据结构**：


Normalresponse

| 参数名  | 说明 | 必填 | 类型 | 值可能性 | 限制 |  示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip/strategy
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip/strategy&resultType=failure
```

```

**详细说明**：


```
