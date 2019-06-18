##[影库] 获取指定搜索 电影列表

**请求协议|请求方法**：HTTP|GET

**接口路径**：/movie/list/

**接口使用状态**：已经弃用

**请求头部**：

| 头部标签 | 必填  | 头部内容 | 
| :------------ | :------------ |

**鉴权**：

**验证类型**：
无

**GET参数**：

| 参数名 | 说明 | 必填 | 类型 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|state|1: 正在热映  0：即将上映|是|[string]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[string]|||200|
|data||是|[array]||||
|data>>id||是|[string]||||
|data>>name||是|[string]||||
|data>>pic||是|[string]||||
|data>>briefIntro|简介|是|[string]||||
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/list/
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/list/&resultType=failure
```

```

**详细说明**：


```
