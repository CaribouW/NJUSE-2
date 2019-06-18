##获取影厅信息

**请求协议|请求方法**：HTTP|GET

**接口路径**：/hall/strategy/list

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
|data||是|[array]||||
|data>>name||是|[string]||||
|data>>hallId|影厅id|是|[string]||||
|data>>state|影厅的状态|是|[number]|||0:可以用 1:不可用|
|data>>size|影厅的大小|是|[string]||||
|data>>type|影厅的规格|是|[string]|||3D IMAX|
|message||是|[string]|||success|
|status|状态码|是|[number]|||200|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/hall/strategy/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/hall/strategy/list&resultType=failure
```

```

**详细说明**：


```
