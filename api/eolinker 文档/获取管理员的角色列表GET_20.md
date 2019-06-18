##获取管理员的角色列表

**请求协议|请求方法**：HTTP|GET

**接口路径**：/admin/list

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
|status||是|[int]||||
|data||是|[object]||||
|data>>list||是|[array]||||
|data>>list>>id|用户id|是|[string]||||
|data>>list>>name|管理人员真实姓名|是|[string]||||
|message|状态说明|是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/admin/list
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/admin/list&resultType=failure
```

```

**详细说明**：


```
