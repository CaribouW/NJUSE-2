##获取所有电影票房

**请求协议|请求方法**：HTTP|GET

**接口路径**：/movie/statistic/liked

**接口使用状态**：待定状态

**请求头部**：

| 头部标签 | 必填  | 头部内容 | 
| :------------ | :------------ |

**鉴权**：

**验证类型**：
无

**GET参数**：

| 参数名 | 说明 | 必填 | 类型 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|movieId||是|[string]|||
|startDate||是|[date]|||
|endDate||是|[date]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[string]||||
|data||是|[array]||||
|data>>date|日期|是|[string]||||
|data>>boxOffice|当日影片票房=∑【当日该影片每场观影人数*当日该场票价】|是|[double]||||
|message||是|[string]||||

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/statistic/liked
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/statistic/liked&resultType=failure
```

```

**详细说明**：


```
