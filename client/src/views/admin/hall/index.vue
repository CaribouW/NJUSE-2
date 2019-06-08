<template>
  <div class="hall-main">
    <div class="header"></div>
    <div class="cards">
      <div class="card-item" v-for="item in hallList" :key="item.id">
        {{item}}
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "index",
    data() {
      return {
        hallList: [
          {
            id: '1',

          }
        ]
      }
    }
  }
</script>

<style lang="scss">

</style>
