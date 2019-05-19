<template>
    <div class="_main">
        <div class="_head_divider">
            <el-divider></el-divider>
        </div>
        <div id="_test" class="_main_content">
            <el-container>
                <el-aside width="250px" style="border:solid 1px #cff9fe;">
                    <!-- 左边导航栏 -->
                    <div class="_leftBar">
                        <el-col :span="24">
                            <img src="../../assets/images/footer/{5C52A913-CCB9-6A3B-A07F-40653AF2D82D}.png" alt="This is our logo!">
                            <el-menu
                            class="el-menu-vertical"
                            @open="handleOpen"
                            @close="handleClose"
                            background-color="#131c1c"
                            text-color="#fff"
                            active-text-color="#cff9fe"
                            router>
                            <el-submenu index=''>
                                <template slot="title">
                                    <i class="el-icon-document"></i>
                                    <span>电影上架</span>
                                </template>
                                <el-menu-item index="/admin/movieManage">添加</el-menu-item>
                                <el-menu-item index="/admin/movieShow">查看</el-menu-item>
                                <el-menu-item index="/admin/movieManage">选项3</el-menu-item>
                            </el-submenu>
                            <el-menu-item index="/admin/scheduleManage">
                                <i class="el-icon-menu"></i>
                                <span slot="title">排片管理</span>
                            </el-menu-item>
                            <el-menu-item index="/admin/statistic">
                                <i class="el-icon-setting"></i>
                                <span slot="title">信息统计</span>
                            </el-menu-item>
                            </el-menu>
                        </el-col>
                    </div>
                </el-aside>
                <el-main>
                    <slot></slot>
                </el-main>
            </el-container>
        </div>
    </div>
</template>

<script>
export default {
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>

<style>
._main_content{
    background-color: #131c1c;
    width:92%; 
    margin-left:auto; 
    margin-right:auto; 
    margin-top:10px
}
._head_divider{
    width:93%; 
    margin-left:auto; 
    margin-right:auto;
}
._leftBar img{
    width: 100px;
    height: 100px;
}
.el-submenu__title,.el-menu-item {
    font-size: 18px;
}
.el-main{
    padding: 0;
}
</style>
