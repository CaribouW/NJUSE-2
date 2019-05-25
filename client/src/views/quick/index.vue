<template>
  <div class="quick-main">
    <div class="quick-container">
      <div class="sub-div">
        <div class="navigater">
          <span class="text">当前排片&nbsp;:{{user.name}}</span>
          <el-date-picker
            v-model="date"
            type="date"
            placeholder="选择日期"
            class="date">
          </el-date-picker>
        </div>
        <div class="table">
          <quick-table :date="this.date"></quick-table>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="js">
  import QuickTable from "./quickTable";
  import {mapGetters, mapActions, mapMutations, mapState} from 'vuex'

  export default {
    components: {QuickTable},
    data() {
      return {
        date: new Date(),
        name: ''
      }
    },
    methods: {
      check: function () {
        console.log(this.$store.getters)
      },
      changeName: function () {
        this.$store.commit({
          type: 'updateUser',
          user: {
            name: this.name
          }
        })
      }
    },
    computed: {
      ...mapGetters({
        user: 'getBasicInfo'
      })
    },
    mounted() {
    },
    created() {
    },
  }
</script>

<style lang="scss">
  .quick-main {
    padding-top: 1%;
    font-family: "PingFangSC-Medium", serif;
    font-size: 18px;
    font-weight: 400;
    line-height: 23px;
    color: #cff9fe;

    .quick-container {
      background: url('../../assets/images/homepage/Assets.png') no-repeat;
      background-size: 100% 100%;
      min-height: 550px;
      height: fit-content;
      box-sizing: border-box;
      padding: 4% 70px 0 70px;

      .sub-div {
        /*width: 90%;*/
        margin: 0 auto 5%;

        .navigater {
          width: 70%;
          margin: 0 auto;
          text-align: left;

          .el-input--prefix .el-input__inner {
            height: 35px;
          }

          .date {
            margin-left: 25px;
            border: solid #cff9fe;
          }
        }

        .table {
          width: 85%;
          margin: 14px auto 25px;
        }
      }
    }
  }

</style>
