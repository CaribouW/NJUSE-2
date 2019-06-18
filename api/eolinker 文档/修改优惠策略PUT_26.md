##修改优惠策略

**请求协议|请求方法**：HTTP|PUT

**接口路径**：/coupon/strategy

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
|couponId|优惠券id|是|[string]|||
|couponName|优惠券名称|是|[string]|||
|startDate|yyyy-mm-dd|是|[string]|||
|endDate|yyyy-mm-dd|是|[string]|||
|discountPrice|优惠金额|是|[number]|||
|conditionPrice|至少达到多少钱可使用优惠券至少要达到的金额|是|[number]|||
|couponNumber|优惠券张数|是|[number]|||
|movies|参与优惠的电影列表id, 如果是空，为[]|是|[array]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[int]|||200|
|data||是|[object]||||
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/coupon/strategy
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/coupon/strategy&resultType=failure
```

```

**详细说明**：


```
