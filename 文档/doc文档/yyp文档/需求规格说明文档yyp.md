### 3.2 功能需求

### 3.2.1 影厅管理
#### 3.2.1.1 特性描述
一个经过验证的管理员开始影厅管理，完成新增影厅、删除影厅、修改影厅的操作<br>
优先级：高<br>
#### 3.2.1.2 刺激响应序列
刺激：管理员开始影厅管理<br>
响应：系统返回影厅管理的类型<br>
刺激：管理员选择新增影厅<br>
响应：系统开始新增影厅<br>
刺激：管理员正确输入影厅属性且确认<br>
响应：系统保存影厅属性，开始下一次影厅管理<br>
刺激：管理员输入影厅属性非法（影厅名字重复）<br>
响应：系统提示输入非法<br>
刺激：管理员选择删除影厅<br>
响应：系统开始删除影厅<br>
刺激：管理员选择要删除的影厅并确认<br>
响应：系统删除所选种影厅，开始下一次影厅管理<br>
刺激：管理员选择修改影厅<br>
响应：系统开始修改影厅<br>
刺激：管理员选择要修改的影厅并键入修改信息<br>
响应：系统修改影厅属性，开始下一次影厅管理<br>
刺激：管理员取消影厅管理<br>
响应：系统关闭影厅管理<br>

#### 3.2.1.3 相关功能需求

功能名称|具体描述
---|---
HallsManage.Input<br>HallsManage.Input.Halls<br>HallsManage.Input.Cancel<br>HallsManage.Input.Del<br>HallsManage.Input.Confirm<br>HallsManage.Input.Invalid<br>|系统应允许管理员在消费记录管理时键盘输入<br>在管理员输入影厅属性时，系统自动生成编号<br>在管理员输入取消命令时，系统关闭当前影厅管理任务，开始一个新的影厅管理任务<br>在管理员输入删除命令时，系统删除已键入的信息<br>在管理员输入确认命令时，系统确认已键入的信息<br>在管理员输入信息不合法时，系统显示输入无效
HallsManage.Halls<br>HallsManage.Halls.New<br>HallsManage.Halls.Name<br>HallsManage.Halls.Category<br>HallsManage.Halls.Model<br>HallsManage.Halls.Inprice<br>HallsManage.Halls.Outprice<br>|系统显示输入影厅信息<br>系统新建影厅<br>输入影厅名称<br>输入影厅类型<br>输入影厅座位情况<br>
HallsManage.Modify.Null<br>HallsManage.Modify.Halls<br>|在管理员选中任何影厅时，系统不予响应<br>在管理员选中一个影厅项并键入修改信息时，系统在影厅列表中修改该影厅信息<br>
HallsManage.Del.Null<br>HallsManage.Del.Halls<br>|在管理员未输入任何影厅信息时，系统不予响应<br>在管理员选中影厅项并删除时，系统在影厅列表中删除该影厅信息
HallsManage.Close<br>HallsManage.Close.Print<br>|系统关闭本次影厅管理任务<br>系统显示本次影厅管理信息<br>


### 3.2.3 消费记录查看
#### 3.2.3.1 特性描述
一个观众进行消费记录查看操作并得到该时间段内的消费记录<br>
优先级：低<br>
#### 3.2.3.2 刺激响应序列
刺激：观众开始消费记录查看<br>
响应：系统返回消费记录列表<br>

#### 3.2.3.3 相关功能需求

功能名称|具体描述
---|---
ViewMemberHistory.Find.Records<br>ViewMemberHistory.Find.Empty<br>|系统显示查询结果<br>查询结果为空时，系统显示未找到指定记录<br>
