#### 4.2.1  MemberBL模块
#### 4.2.1.1 模块概述
MemberBL模块承担的需求参见需求规格说明文档功能需求及相关非功能需求。
MemberBL模块的职责及接口参见软件系统结构描述文档。
#### 4.2.1.2 整体结构
根据体系结构的设计，采用分层风格，将系统分为展示层，业务逻辑层，数据层。每一层之间为了灵活性，我们会添加接口。比如展示层和业务逻辑层之间，我们添加了Businesslogicservice.memberblservice.MemberBLService接口。业务逻辑层和数据层之间添加Dataservice.memberdataservice.MemberDataService接口.为了隔离业务逻辑职责和逻辑控制职责，我们添加了MemberController。这样，MemberController会将对会员的业务逻辑处理交给Member对象。MemberPO是作为销售记录的持久化对象被添加到设计模型中去的。MemberItem存储MemberId，余额的数据，MemberList封装了关于MemberList的数据集合的数据结构
##### MemberBL模块设计图

##### MemberBL模块各个类的职责

模块|职责
---|---
MemberController|负责实现会员界面所需要的服务
Member|会员的领域模型对象，可以帮助完成会员界面所需要的服务

#### 4.2.1.3 模块内部类的接口规范
##### MemberController的接口规范
<html>
  <table>
    <tr>
      <td colspan="3">提供的服务（供接口）</td>
    </tr>
    <tr>
      <th rowspan="3">MemberController.addMember</th>
      <td>语法</td>
      <td>public void addMember(string id)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>已创建一个Member领域对象</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>调用Member领域对象的addMember方法</td>
    </tr>
    <tr>
      <th rowspan="3">MemberController.memberRecharge</th>
      <td>语法</td>
      <td>public MemberItem memberRecharge(string id, int money)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>已创建一个Member领域对象</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>调用Member领域对象的MemberRecharge方法</td>
    </tr>
    <tr>
      <th rowspan="3">MemberController.seekMember</th>
      <td>语法</td>
      <td>public void seekMember(string id)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>已创建一个Member领域对象</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>调用Member领域对象的seekMember方法</td>
    </tr>
  </table>
</html>
需要的服务（需接口）

服务名|服务
---|---
Member.addMember|加入一个会员对象
Member.seekMember|查找一个会员对象
Member.memberRecharge|会员对象充值

##### Member的接口规范
<html>
  <table>
    <tr>
        <td colspan="3">提供的服务（供接口）</td>
    </tr>
    <tr>
      <th rowspan="3">Member.addMember</th>
      <td>语法</td>
      <td>public void addMember(string id)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>无</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>保存新增会员信息</td>
    </tr>
    <tr>
      <th rowspan="3">Member.seekMember</th>
      <td>语法</td>
      <td>public memberItem seekMember(string id)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>无</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>返回查找到的会员信息</td>
    </tr>
    <tr>
      <th rowspan="3">Member.recharge</th>
      <td>语法</td>
      <td>public void memberRecharge(string id, int money)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>无</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>修改所选会员信息中的余额</td>
    </tr>
  </table>
</html>

需要的服务（需接口）

服务名|服务
---|---
MemberDataService.insert(SalesPo po)|插入单一持久化对象
MemberDataService.find(string id)|查找单一持久化对象
MemberDataService.update(SalesPo po)|修改单一持久化对象

#### 4.2.1.4 业务逻辑层的动态模型
下图分别表明了会员相关业务逻辑处理的相关对象之间的协作。

##### 添加会员顺序图
##### 会员充值顺序图
##### 查找会员信息顺序图

#### 4.2.1.5 业务逻辑层的设计原理
利用委托式控制风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同的领域对象
其他略

----------

#### 4.2.2  MovieTicketBL模块
#### 4.2.2.1 模块概述
MovieTicketBL模块承担的需求参见需求规格说明文档功能需求及相关非功能需求。
MovieTicketBL模块的职责及接口参见软件系统结构描述文档。
#### 4.2.2.2 整体结构
根据体系结构的设计，采用分层风格，将系统分为展示层，业务逻辑层，数据层。每一层之间为了灵活性，我们会添加接口。比如展示层和业务逻辑层之间，我们添加了businesslogicservice.movieTicketblservice.MovieTicketBLService接口。业务逻辑层和数据层之间添加dataservice.movieTicketdataservice.MovieTicketDataService接口.为了隔离业务逻辑职责和逻辑控制职责，我们添加了MovieTicketController。这样,MovieTicketController会将对电影票的业务逻辑处理交给MovieTicket对象。MovieTicketPO是作为销售记录的持久化对象被添加到设计模型中去的。MovieTicketLineItem存储电影票场次、金额、影厅等相关数据，MovieTicketList封装了关于MemberList的数据集合的数据结构
##### MovieTicketServiceBL模块设计图

##### MovieTicketServiceBL模块各个类的职责

模块|职责
---|---
MovieTicketController|负责实现电影票相关业务所需要的服务
MovieTicket|电影票的领域模型对象，可以帮助完成电影票相关业务所需要的服务

#### 4.2.2.3 模块内部类的接口规范
##### MovieTicketController的接口规范
<html>
  <table>
    <tr>
      <td colspan="3">提供的服务（供接口）</td>
    </tr>
    <tr>
      <th rowspan="3">MovieTicketController.selectSeat</th>
      <td>语法</td>
      <td>public void selectSeat(string movieId,int[][] position)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>已创建一个MovieTicket领域对象</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>调用MovieTicket领域对象的selectSeat方法</td>
    </tr>
    <tr>
    <tr>
      <th rowspan="3">MovieTicketController.initOrderForm</th>
      <td>语法</td>
      <td>public MovieTicketPO initOrderForm(string movieId,int[][] position)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>已经合法的选择座位</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>调用MovieTicket领域对象的initOrderForm方法</td>
    </tr>
    <tr>
    <tr>
      <th rowspan="3">MovieTicketController.purchaseTicket</th>
      <td>语法</td>
      <td>public void purchaseTicket(string ticketId)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>在15分钟以内生成订单，订单未支付</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>调用MovieTicket领域对象的purchaseTicket方法</td>
    </tr>
    <tr>
      <th rowspan="3">MovieTicketController.returnTicket</th>
      <td>语法</td>
      <td>public void returnTicket(string ticketId)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>订单完成支付，且符合退款条件</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>调用MovieTicket领域对象的returnTicket方法</td>
    </tr>
    <tr>
      <th rowspan="3">MovieTicketController.getTicketHistory</th>
      <td>语法</td>
      <td>public MovieTicketPO[] getTicketHistory(string userId)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>无</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>调用MovieTicket领域对象的getTicketHistory方法</td>
    </tr>
  </table>
</html>

需要的服务（需接口）

服务名|服务
---|---
MovieTicket.selectSeat|修改影厅对象状态
MovieTicket.initOrderForm|新增一个订单对象
MovieTicket.purchaseTicket|修改订单状态为已支付
MovieTicket.returnTicket|修改订单状态为退款
MovieTicket.getTicketHistory|查看订单列表

##### MovieTicket的接口规范
<html>
  <table>
    <tr>
        <td colspan="3">提供的服务（供接口）</td>
    </tr>
    <tr>
      <th rowspan="3">MovieTicket.selectSeat</th>
      <td>语法</td>
      <td>public void selectSeat(string movieId,int[][] position)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>无</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>更改影厅座位信息</td>
    </tr>
    <tr>
      <th rowspan="3">MovieTicket.initOrderForm</th>
      <td>语法</td>
      <td>public MovieTicketPO selectSeat(string movieId,int[][] position)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>已经合法的选择座位</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>新增订单信息并返回</td>
    </tr>
    <tr>
      <th rowspan="3">MovieTicket.purchaseTicket</th>
      <td>语法</td>
      <td>public void purchaseTicket(string ticketId)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>在15分钟以内生成的未支付的订单</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>跳转到第三方支付，支付完成后修改订单状态</td>
    </tr>
    <tr>
      <th rowspan="3">MovieTicket.returnTicket</th>
      <td>语法</td>
      <td>public void returnTicket(string ticketId)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>订单已支付且符合退款策略</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>修改订单信息为已退款</td>
    </tr>
    <tr>
      <th rowspan="3">MovieTicket.getTicketHistory</th>
      <td>语法</td>
      <td>public MovieTicketPO[] getTicketHistory(string userId)</td>
    </tr>
    <tr>
      <td>前置条件</td>
      <td>无</td>
    </tr>
    <tr>
      <td>后置条件</td>
      <td>返回订单列表信息</td>
    </tr>
  </table>
</html>

需要的服务（需接口）

服务名|服务
---|---
MovieTicketDataService.insert(MovieTicketPO po)|插入单一持久化对象
MovieTicketDataService.getAll(string userId)|查找单一持久化对象
MovieTicketDataService.update(MovieTicketPO po)|修改单一持久化对象

#### 4.2.2.4 业务逻辑层的动态模型
下图分别表明了会员相关业务逻辑处理的相关对象之间的协作。

##### 选座顺序图
##### 生成订单顺序图
##### 购票顺序图
##### 退票顺序图
##### 查看历史订单顺序图

#### 4.2.2.5 业务逻辑层的设计原理
利用委托式控制风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同的领域对象，
其他略
