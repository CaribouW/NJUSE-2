##主动给予指定会员以优惠券

**请求协议|请求方法**：HTTP|POST

**接口路径**：/coupon/vip

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
|vipIdList|id字符串数组|是|[array]|||
|couponId|优惠券策略id|是|[string]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|data||是|[array]||||
|data>>vipId|vip卡id|是|[string]|:||3a58fa2d88be4b9ba843807e62f82ad2|
|data>>id|用户持有的单张优惠券id|是|[string]|:||4e4017acea3047288db9ac73b1b75f92|
|data>>state|优惠券状态, 0:已失效，1未使用，2已使用|是|[number]|:||1|
|data>>couponId|优惠策略id|是|[string]|:||a|
|data>>userId||是|[string]|:||303bebcb72d848d79604f3ea729af51e|
|message||是|[string]|:||success|
|status||是|[number]|:||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/coupon/vip
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/coupon/vip&resultType=failure
```

```

**详细说明**：


```
