##得到用户基本信息

**请求协议|请求方法**：HTTP|GET

**接口路径**：/user/basicInfo

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
|id|用户ID|是|[string]||303bebcb72d848d79604f3ea729af51e|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status|状态码|是|[int]|||200|
|data||是|[object]||||
|data>>name|名字|是|[string]||||
|data>>pic|头像url|是|[string]||||
|data>>id|用户id|是|[string]||||
|data>>vip|vip等级|是|[int]||||
|data>>birthday|生日|是|[string]|||2011-1-1|
|data>>sex|性别|是|[int]|0:女,1:男|||
|message|状态说明|是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/user/basicInfo
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/user/basicInfo&resultType=failure
```

```

**详细说明**：


```
