##获取用户的想看电影列表

**请求协议|请求方法**：HTTP|GET

**接口路径**：/favor/user/list

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
|userId|用户ID|是|[string]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|data||是|[object]||||
|data>>favorList||是|[array]||||
|data>>favorList>>movieId|电影id|是|[string]||||
|data>>favorList>>movieName|电影名称|是|[string]||||
|data>>favorList>>releaseDate|上映日期|是|[string]||||
|data>>favorList>>imgURL|电影竖版海报的URL|是|[string]||||
|data>>favorList>>mainActor|主演|是|[array]||||
|data>>favorList>>releaseArea|上映地点|是|[string]||||
|message||是|[string]|||success|
|status|状态码|是|[number]|||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/favor/user/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/favor/user/list&resultType=failure
```

```

**详细说明**：


```
