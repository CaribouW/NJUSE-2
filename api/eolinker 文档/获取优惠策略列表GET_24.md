##获取优惠策略列表

**请求协议|请求方法**：HTTP|GET

**接口路径**：/coupon/strategy/list

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
|status||是|[int]|||200|
|data||是|[array]||||
|data>>movies|参与该优惠的电影列表id|是|[array]||||
|data>>couponNumber|优惠券张数|是|[number]||||
|data>>conditionPrice|使用优惠券至少要达到的金额|是|[number]||||
|data>>discountPrice|减免金额|是|[number]||||
|data>>startDate|开始日期|是|[string]||||
|data>>endDate||是|[string]||||
|data>>couponName|优惠券名称|是|[string]||||
|data>>couponID|优惠券ID|是|[object]||||
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/coupon/strategy/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/coupon/strategy/list&resultType=failure
```

```

**详细说明**：


```
