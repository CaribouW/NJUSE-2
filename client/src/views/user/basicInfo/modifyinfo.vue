<template>
    <div class="modify">
      <div class="modify_portrait">
        <el-upload
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
      </div>
      <div class="modify_id">
        <el-input
          type="text" 
          placeholder="请输入新用户名"
          v-model="userName"
          maxlength="10"
          show-word-limit
        >
        </el-input>
        <br/>
        ID:{{id}}
      </div>
      <div class="modify_other">
        <el-dropdown>
            <span class="el-dropdown-link">
                性别： 
                <img src="@/assets/images/basicinfo/nan.png" alt="" style="width:16px;height:16px;">
                <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <img src="@/assets/images/basicinfo/nan.png" alt="" style="width:16px;height:16px;"> 男
            </el-dropdown-item>
            <el-divider></el-divider>
            <el-dropdown-item>
              <img src="@/assets/images/basicinfo/nv.png" alt="" style="width:16px;height:16px;"> 女
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span><br/>
           <div class="block">
                <span class="demonstration">生日： </span>
                <el-date-picker
                  v-model="birthday"
                  type="date"
                  placeholder="选择日期"
                  class="date-picker"
                  :picker-options="pickerOptions">
                </el-date-picker>
            </div>
        </span>
        <br/>
        <span>
            <el-button round style="color:#CFF9FE;" @click="onSubmit()">保存</el-button>
            <el-button round style="color:#CFF9FE;" @click="goInfo()">取消</el-button>
        </span>
      </div>
    </div>
</template>

<script>
  import user from "../index.vue"

  export default {
    name: 'basicInfo',
    components: {
      user,
    },
    data() {
      return {
        tabPosition: 'left',
        imageUrl: '',
        userName: '',
        id:sessionStorage.getItem('userId'),
        textarea: '',
        pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
        },
        birthday: '',
        info:{},
      }
    },
    methods: {
      goInfo() {
        this.$router.push("/user")
      },
      handleAvatarSuccess(res, file) {
        this.imageUrl = URL.createObjectURL(file.raw);
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
      onSubmit:function(){
      //   // this.info=
      //   this.$store.dispatch('updateUser', {
      //     id:sessionStorage.getItem('userId'),
      //     info.pic:"url",

      //   })
      //   .then(res => {
      //   console.log(res)
      // });
      }

    }
  }
</script>


<style lang="scss">
  .modify {
    padding: 29px 50px 50px 50px;

    &_rectangle {
      background: url('../../../assets/images/homepage/Assets.png') no-repeat;
      background-size: 100% 100%;
      height: 790px;
      margin-bottom: 50px;
    }

    .avatar-uploader .el-upload {
      border: 1px dashed #d9d9d9;
      border-radius: 100px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
      border-color: #CFF9FE;
    }

    .avatar-uploader-icon {
      font-size: 25px;
      color: #8c939d;
      width: 140px;
      height: 140px;
      line-height: 140px;
      text-align: center;
    }

    .avatar {
      width: 140px;
      height: 140px;
      display: block;
    }

    .modify_id {
      background-color: rgba($color: #D8D8D8, $alpha: 0.05);
      padding: 20px 22px 10px 22px;
      margin-top: 28px;
      margin-bottom: 20px;
      text-align: center
    }

    .modify_id .el-input__inner {
      background-color: #131C1C;
      border-color: #CFF9FE;
      border-radius: 10px;
      width: 200px;
      margin-bottom: 10px;
      color: #ffffff;
      // font-size: 30px;
    }

    .el-input__count {
      padding-right: 170px;
    }

    .el-input__suffix {
      margin-top: 19px;
    }

    .el-input .el-input__count .el-input__count-inner {
      background: transparent;
      color: #D8D8D8;
    }

    .el-input__prefix {
      height: 5px;
    }

    .el-input__inner {
      background-color: #131C1C;
      width: 150px;
    }

    .el-dropdown-link {
      font-size: 16px;
    }

    .el-button {
      // margin-top: 20px;
      border-radius: 25px;
      padding: 8px 40px;
      background-color: rgba($color: #131C1C, $alpha: 0.5);
      font-size: 18px;
      color: #CFF9FE;
      border-color: #CFF9FE
    }

    .block {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;
    }

    .demonstration {
      width: 220px;
      display: flex;
      flex-direction: row-reverse;
      font-size: 16px;
    }

    .date-picker {
      width: 220px;
    }
  }
</style>
