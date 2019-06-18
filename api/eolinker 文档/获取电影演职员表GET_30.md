##获取电影演职员表

**请求协议|请求方法**：HTTP|GET

**接口路径**：/movie/detail/staff

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
|movieId||是|[string]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[number]|:||200|
|data||是|[object]||||
|data>>directorList||是|[array]||||
|data>>directorList>>name||是|[string]|:||昆汀|
|data>>directorList>>pic||是|[string]||||
|data>>actorList||是|[array]||||
|data>>actorList>>name|真名|是|[string]||||
|data>>actorList>>pic||是|[string]||||
|data>>actorList>>role|角色|是|[string]||||
|message||是|[string]|:||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/detail/staff
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/detail/staff&resultType=failure
```

```

**详细说明**：


```
