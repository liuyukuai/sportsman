<!DOCTYPE html><html><head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/ui.css"></head>
    <link rel="stylesheet" href="/css/index.css"></head>
<body>
<div id="app">
<mt-header fixed title="运动员个人信息填报" class="app-header"></mt-header>
<div class="index-container" >
    <!-- 首页功能栏部分 -->
    <ul class="icon-list">
        <a href="/athletes"><li class="icon">
            <img src="/img/store.png" class="clear">
            <h4>运动员个人信息填报</h4>
            <p>运动员个人信息填报</p>
            <i></i>
        </li></a>
        <a href="index.ftl"><li class="icon">
            <img src="/img/store.png" class="clear">
            <h4>运动员健康状态填报</h4>
            <p>运动员健康状态填报</p>
            <i></i>
        </li></a>
    </ul>
</div>
</div>
</body>
<!-- 先引入 Vue -->
<script src="/js/vue.js"></script>
<!-- 引入组件库 -->
<script src="/js/ui.js"></script>
<script>
    new Vue({
        el: '#app',
        methods: {
            handleClick: function() {
                this.$toast('Hello world!')
            }
        }
    })
</script>
</html>