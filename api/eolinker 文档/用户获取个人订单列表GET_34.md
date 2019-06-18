##用户获取个人订单列表

**请求协议|请求方法**：HTTP|GET

**接口路径**：/order/history

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
|userId|用户id|是|[string]||56d6ae189ea165|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|data||是|[object]||||
|data>>orderList|订单列表|是|[array]||||
|data>>orderList>>tickets||是|[array]||||
|data>>orderList>>tickets>>ticketId||是|[string]|:||995df3f7f68141399e5fd32a607d7453|
|data>>orderList>>tickets>>slotId||是|[string]|:||111|
|data>>orderList>>tickets>>row|行数|是|[number]|:||2|
|data>>orderList>>tickets>>col|列数|是|[number]|:||2|
|data>>orderList>>tickets>>orderId||是|[string]|:||28f68d1ba3c24221b51d6e7e2b0b0680|
|data>>orderList>>movie||是|[object]||||
|data>>orderList>>movie>>movieId||是|[string]|:||11237|
|data>>orderList>>movie>>name||是|[string]|:||阿飞正传|
|data>>orderList>>movie>>nameEn||是|[string]|:||English Name|
|data>>orderList>>movie>>downDate||是|[string]|:||2019-06-13|
|data>>orderList>>movie>>uploadDate||是|[string]|:||2019-06-12|
|data>>orderList>>movie>>score||是|[number]|:||8.8|
|data>>orderList>>movie>>timeLength||是|[number]|:||94|
|data>>orderList>>movie>>poster||是|[string]|:||https://p0.meituan.net/movie/885fc379c614a2b4175587b95ac98eb95045650.jpg@464w_644h_1e_1c|
|data>>orderList>>movie>>stills||是|[string]|:||1|
|data>>orderList>>movie>>video||是|[string]|:||1|
|data>>orderList>>movie>>videoList||是|[string]|:||1|
|data>>orderList>>movie>>category||是|[string]|:||剧情,爱情,犯罪|
|data>>orderList>>movie>>nation||是|[string]|:||中国香港|
|data>>orderList>>movie>>lang||是|[string]|:||中文|
|data>>orderList>>movie>>briefIntro||是|[string]|:||阿飞正传真好看！|
|data>>orderList>>movie>>hierarchical||是|[string]|:||R18|
|data>>orderList>>movie>>imdb||是|[string]|:||888888|
|data>>orderList>>movie>>productionCompany||是|[string]|:||华纳兄弟娱乐公司|
|data>>orderList>>movie>>distributionCompany||是|[string]|:||华纳兄弟娱乐公司|
|data>>orderList>>movie>>state||是|[number]|:||0|
|data>>orderList>>movie>>hposter||是|[string]|:||1|
|data>>orderList>>hall||是|[object]||||
|data>>orderList>>hall>>hallId||是|[string]|:||12|
|data>>orderList>>hall>>name||是|[string]|:||MCA|
|data>>orderList>>hall>>row||是|[number]|:||10|
|data>>orderList>>hall>>col||是|[number]|:||10|
|data>>orderList>>hall>>category||是|[string]|:||亲子厅|
|data>>orderList>>hall>>state||是|[boolean]|:||false|
|data>>orderList>>slot||是|[object]||||
|data>>orderList>>slot>>slotId||是|[string]|:||111|
|data>>orderList>>slot>>startTime||是|[string]|:||2019-06-13T03:05:10.000+0000|
|data>>orderList>>slot>>endTime||是|[string]|:||2019-06-14T03:05:21.000+0000|
|data>>orderList>>slot>>movieId||是|[string]|:||11237|
|data>>orderList>>slot>>ticketPrize||是|[number]|:||998|
|data>>orderList>>slot>>hallId||是|[string]|:||12|
|data>>orderList>>slot>>property||是|[string]|:||fuck|
|data>>orderList>>order||是|[object]||||
|data>>orderList>>order>>orderId||是|[string]|:||28f68d1ba3c24221b51d6e7e2b0b0680|
|data>>orderList>>order>>userId||是|[string]|:||dc3fb1eb6dd54c1dbed9769e5aa47219|
|data>>orderList>>order>>confirmDate||是|[string]|:||2019-06-03T14:31:46.000+0000|
|data>>orderList>>order>>expense||是|[number]|:||0|
|data>>orderList>>order>>state|0 已支付；1 已取消 ； 2 未支付|是|[number]|:||2|
|message||是|[string]|:||success|
|status||是|[number]|:||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/order/history
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/order/history&resultType=failure
```

```

**详细说明**：


```
