##返回用户是否会员的信息(可以根据返回会员卡信息是否为空判定)

**请求协议|请求方法**：HTTP|GET

**接口路径**：/isVIP

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
|userId|用户ID|是|[string]||303bebcb72d848d79604f3ea729af51e|

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[int]|||200|
|data||是|[object]||||
|data>>isVIP|是否会员|是|[boolean]|||true|
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/isVIP
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/isVIP&resultType=failure
```

```

**详细说明**：

用于主页的获取会员信息（前端对VIP标志的颜色改变）
```
