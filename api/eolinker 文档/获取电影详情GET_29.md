##获取电影详情

**请求协议|请求方法**：HTTP|GET

**接口路径**：/movie/detail/basicInfo

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
|userId||是|[string]|||

**返回参数**
参数类型：Json
根类型: Object

| 参数名  | 说明 |  | 类型 | 值可能性 | 限制 | 示例 |
| :------------ | :------------ | :------------ | :------------ | :------------ | :------------ | :------------ |
|status||是|[string]|||200|
|data||是|[object]||||
|data>>name||是|[string]||||
|data>>pic|横板海报url|是|[string]||||
|data>>video|url|是|[string]||||
|data>>score|1-5|是|[int]||||
|data>>inFavorList|用户是否已标记喜爱|是|[boolean]||||
|data>>favorNum|标记喜爱的人数|是|[int]||||
|data>>briefIntro|简介|是|[string]||||
|data>>basicInfo||是|[object]||||
|data>>basicInfo>>ChineseName||是|[string]||||
|data>>basicInfo>>EnglishName||是|[string]||||
|data>>basicInfo>>productionCompany|出品公司|是|[string]||||
|data>>basicInfo>>distributionCompany|发行公司|是|[string]||||
|data>>basicInfo>>location|拍摄地点|是|[string]||||
|data>>basicInfo>>director||是|[string]||||
|data>>basicInfo>>type||是|[string]||||
|data>>basicInfo>>duration|时长（分钟）|是|[int]||||
|data>>basicInfo>>showTime|上映时间|是|[date]||||
|data>>basicInfo>>hierachical|分级|是|[string]|||PG-13|
|data>>basicInfo>>language||是|[string]||||
|data>>basicInfo>>imdb|imdb的id|是|[string]||||
|data>>basicInfo>>pic|竖版海报（小图呈现的）|是|[string]||||
|message||是|[string]|||success|

**成功示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/detail/basicInfo
```

```

**失败示例[Mock API]**：


**mock api**：https://result.eolinker.comVHpSWiEb7482c7bfbc92a5ec980f56a421b4cbac3ff8d4d?uri=/movie/detail/basicInfo&resultType=failure
```

```

**详细说明**：


```
