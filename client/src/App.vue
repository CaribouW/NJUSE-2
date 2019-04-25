<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
/* CSS Document */
/* 基本css格式，清除浏览器默认配置 */
* { color:#444; }
body, html { height: 100%;}
body { font:16px/1.5 "微软雅黑",Arial,Tahoma, Helvetica,\5b8b\4f53, sans-serif}
html,body,div,h1,h2,h3,h4,h5,h6,hr,p,blockquote,dl,dt,dd,ul,ol,li,pre,form,fieldset,object,code,em,span,var,legend,button,input,textarea,th,td,a,img,header,footer,nav,aside,audio,datalist,section { margin:0;padding:0;border:0;outline:0; }/*清除内外边距*/
h1,h2,h3,h4,h5,h6 { font-weight:normal;font-size:100%; }/*设置默认字体*/
:focus { outline:0; }
ul,ol,ul li,ol li { list-style: none; }/*重置列表*/
address,caption,cite,em,code,dfn,th,var { font-style:normal;font-weight:normal; }
form label { cursor:pointer; }
textarea { resize:none }
input { vertical-align:middle; }
img { border:0; }/*重置图片元素*/
table { border-collapse:collapse;border-spacing: 0; }/*重置表格*/
/* .l { float:left; }
.r { float:right; } */
a { text-decoration:none;}
a { color:#666;}
a:hover { text-decoration:underline; }

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  height: 100%;
  /* color: #2c3e50; */
}
</style>
