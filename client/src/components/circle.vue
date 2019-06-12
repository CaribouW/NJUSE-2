<template>
  <div class="circle-main">
    <div class="radmenu"><a href="#" class="show">START</a>
      <ul>
        <li>
        </li>
        <li>
          <a href="#" id="comingSoon">即将上映</a>
        </li>
        <li>
          <a href="#" id="onshow">正在热映</a>
        </li>
        <li>
        </li>
        <li>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: "subCircle",
    methods: {
      notifyParent (e) {
        this.$emit('getMovieNotify', e.srcElement.innerText)
      }
    },
    mounted() {
      var buttons = document.querySelectorAll(".radmenu a");
      var _this = this
      for (var i = 0, l = buttons.length; i < l; i++) {
        var button = buttons[i];
        button.onclick = setSelected;
        // button.onclick = notifyParent
      }

      function setSelected(e) {
        console.log(e)
        _this.notifyParent(e)
        if (this.classList.contains("selected")) {
          this.classList.remove("selected");
          if (!this.parentNode.classList.contains("radmenu")) {
            this.parentNode.parentNode.parentNode.querySelector("a").classList.add("selected")
          } else {
            this.classList.add("show");
          }
        } else {
          this.classList.add("selected");
          if (!this.parentNode.classList.contains("radmenu")) {
            this.parentNode.parentNode.parentNode.querySelector("a").classList.remove("selected")
          } else {
            this.classList.remove("show");
          }
        }
        return false;
      }
    }
  }
</script>

<style lang="scss">
  .circle-main {
    html,
    body,
    div,
    span,
    applet,
    object,
    iframe,
    h1,
    h2,
    h3,
    h4,
    h5,
    h6,
    p,
    blockquote,
    pre,
    a,
    abbr,
    acronym,
    address,
    big,
    cite,
    code,
    del,
    dfn,
    em,
    img,
    ins,
    kbd,
    q,
    s,
    samp,
    small,
    strike,
    strong,
    sub,
    sup,
    tt,
    var,
    b,
    u,
    i,
    center,
    dl,
    dt,
    dd,
    ol,
    ul,
    li,
    fieldset,
    form,
    label,
    legend,
    table,
    caption,
    tbody,
    tfoot,
    thead,
    tr,
    th,
    td,
    article,
    aside,
    canvas,
    details,
    embed,
    figure,
    figcaption,
    footer,
    header,
    hgroup,
    menu,
    nav,
    output,
    ruby,
    section,
    summary,
    time,
    mark,
    audio,
    video {
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      vertical-align: baseline;
    }

    article,
    aside,
    details,
    figcaption,
    figure,
    footer,
    header,
    hgroup,
    menu,
    nav,
    section {
      display: block;
    }

    body {
      line-height: 1;
    }

    ol,
    ul {
      list-style: none;
    }

    blockquote,
    q {
      quotes: none;
    }

    blockquote:before,
    blockquote:after,
    q:before,
    q:after {
      content: "";
      content: none;
    }

    table {
      border-collapse: collapse;
      border-spacing: 0;
    }

  }

  .radmenu {
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
    border: solid transparent;
    /*width: 100%;*/
    /*height: 100%;*/
  }

  .radmenu > a {
    top: calc(50% - 60px);
    left: calc(50% - 60px);
  }

  .radmenu > a.show {
    display: flex !important;
  }

  .radmenu li {
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
    transition: all 1s ease;
  }

  .radmenu a {
    position: absolute;
    width: 140px;
    height: 140px;
    background: rgba(207, 249, 254, 0.03);
    border: solid rgba(207, 249, 254, 0.48);
    text-align: center;
    align-items: center;
    justify-content: center;
    border-radius: 150px;
    display: none;
    text-decoration: none;
    color: rgba(207, 249, 254, 0.47);
    transition: all 1s ease;
    font-family: "segoe ui", serif;
    font-weight: 200;
    box-shadow: 0 0 10px #f1f1f1;
  }

  .radmenu .show {
    width: 250px;
    height: 250px;
    border-radius: 250px;
    font-size: 28px;
  }

  .radmenu :hover {
    color: rgba(207, 249, 254, 0.96);
  }

  .radmenu .selected {
    background: rgba(51, 51, 51, 0.07);
    display: flex;
    top: calc(50% - 60px);
    left: calc(50% - 60px);
    color: rgba(207, 249, 254, 0.85);
    box-shadow: 0 0 10px #f1f1f1;
    width: 220px;
    height: 220px;
  }


  .radmenu .selected + ul > li:nth-child(1) {
    -webkit-transform: rotate(72deg) translateX(100px);
    transform: rotate(72deg) translateX(100px);
  }

  .radmenu .selected + ul > li:nth-child(1) > a {
    -webkit-transform: rotate(-72deg);
    transform: rotate(-72deg);
  }

  .radmenu .selected + ul > li:nth-child(2) {
    -webkit-transform: rotate(144deg) translateX(100px);
    transform: rotate(144deg) translateX(100px);
  }

  .radmenu .selected + ul > li:nth-child(2) > a {
    -webkit-transform: rotate(-144deg);
    transform: rotate(-144deg);
  }

  .radmenu .selected + ul > li:nth-child(3) {
    -webkit-transform: rotate(216deg) translateX(100px);
    transform: rotate(216deg) translateX(100px);
  }

  .radmenu .selected + ul > li:nth-child(3) > a {
    -webkit-transform: rotate(-216deg);
    transform: rotate(-216deg);
  }

  .radmenu .selected + ul > li:nth-child(4) {
    -webkit-transform: rotate(288deg) translateX(110px);
    transform: rotate(288deg) translateX(110px);
  }

  .radmenu .selected + ul > li:nth-child(4) > a {
    -webkit-transform: rotate(-288deg);
    transform: rotate(-288deg);
  }

  .radmenu .selected + ul > li:nth-child(5) {
    -webkit-transform: rotate(360deg) translateX(180px);
    transform: rotate(360deg) translateX(200px);
  }

  .radmenu .selected + ul > li:nth-child(5) > a {
    -webkit-transform: rotate(-360deg);
    transform: rotate(-360deg);
  }

  .radmenu .selected + ul > li > a {
    display: flex;
  }

</style>
