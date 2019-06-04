<template>
  <div class="ticket">
    <span>{{ticket.startTime}}</span><span class="purchase">购票</span>
    <span>{{ticket.endTime}}散场</span>
    <span>{{ticket.type}}</span><span>{{ticket.price}}元</span>
    <span>{{ticket.moviehall}}</span><span>会员价{{ticket.memberPrice}}元</span>
  </div>
</template>

<script>
export default {
  data () {
    return {
      ticket: {
        startTime: '20:45',
        endTime: '23:46',
        type: '英语/普通3D',
        price: '54.5',
        memberPrice: '51.5',  
        moviehall: '13号厅 按摩椅'
      }
    }
  }
}
</script>


<style lang="scss">
.ticket{
  width: 250px;
  height: 129px;
  border: 1px solid #CFF9FE;
  border-radius: 15px;
  margin: 10px 15px;
  padding: 10px 10px;
  box-sizing: border-box;
  color: #CFF9FE;
  text-align: left;
  >span{display: inline-block;}
  >span:first-of-type{width: 150px;font-size: 20px}
  >span:nth-of-type(3){display: block;font-size: 14px}
  >span:nth-of-type(4){width: 150px;font-size: 18px}
  >span:nth-of-type(5){font-size: 18px}
  >span:nth-of-type(6){width: 120px;font-size: 14px}
  >span:nth-of-type(6){font-size: 14px}
  .purchase{
    width: 70px;
    height: 30px;
    line-height: 27px;
    box-sizing: border-box;
    border: 1.5px solid #CFF9FE;
    border-radius: 15px;
    padding-left: 18px;
    cursor: pointer;
  }
  .purchase:hover{font-weight: bold;}
}
</style>

