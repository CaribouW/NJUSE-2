##获取用户拥有的优惠券信息

**请求协议|请求方法**：HTTP|GET

**接口路径**：/coupon/list

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
|userId|用户ID|是|[string]||303bebcb72d848d79604f3ea729af51e|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[int]|||200|
|data||是|[object]||||
|data>>coupons|普通优惠券|是|[array]||||
|data>>coupons>>couponId|优惠券ID|是|[string]|||351648|
|data>>coupons>>couponName|优惠券名称|是|[string]|||电影节优惠|
|data>>coupons>>couponAmount|满减金额|是|[number]|||4.00|
|data>>coupons>>useCondtion|使用条件（满多少才能减）|是|[number]|||50.0|
|data>>coupons>>startDate|使用范围的起始日期|是|[string]|||2019-04-05|
|data>>coupons>>endDate|使用范围的结束日期|是|[string]|||2019-05-05|
|data>>coupons>>state|0--已失效；1--未使用；2--已使用|是|[number]|||2|
|data>>coupons>>type|0--普通优惠券，1--会员优惠券|是|[number]|||1|
|data>>coupons>>movies|适用电影的数组，里面存电影id|是|[array]||||
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/coupon/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/coupon/list&resultType=failure
```

```

**详细说明**：

获取用户拥有的优惠券信息（普通的和会员的【如果是会员的话】)
—-返回可以使用的（失效的和用过的不要）
```
