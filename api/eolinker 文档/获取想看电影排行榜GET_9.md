##获取想看电影排行榜

**请求协议|请求方法**：HTTP|GET

**接口路径**：/favor/rank/top

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
|quantity|排名前n的电影|是|[number]||10|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[int]|||200|
|data||是|[object]|||{"rankList":[{"movieName":"复联4","favorNum":25},{"movieName":"复联3","favorNum":10}]}|
|data>>rankList|电影列表|是|[array]||||
|data>>rankList>>movieName|电影名称|是|[string]||||
|data>>rankList>>favorNum|想看人数|是|[number]||||
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/favor/rank/top
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/favor/rank/top&resultType=failure
```

```

**详细说明**：

给予想看电影人数排序下的电影列表    返回整个影库对应的排序列表
```
