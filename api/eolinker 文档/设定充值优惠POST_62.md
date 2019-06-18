##设定充值优惠

**请求协议|请求方法**：HTTP|POST

**接口路径**：/vip/strategy/recharge

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
|amount|充值金额|是|[number]|||
|discount|减免金额；最终的付费金额即为 : amount - discount|是|[number]|||

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip/strategy/recharge
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/vip/strategy/recharge&resultType=failure
```

```

**详细说明**：


```
