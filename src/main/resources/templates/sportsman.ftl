<!DOCTYPE html><html><head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/ui.css"></head>
    <link rel="stylesheet" href="/css/index.css"></head>
<body>
<div class="index-container">
    <mt-popup
            v-model="popupVisible"
            popup-transition="popup-fade"
            position="top">
        战前运动员信息录入
    </mt-popup>
    <!-- 首页功能栏部分 -->
    <ul class="icon-list">
        <li class="icon">
            <img src="/img/store.png" class="clear">
            <h4>运动员个人信息填报</h4>
            <p>运动员个人信息填报</p>
            <i></i>
        </li>
        <li class="icon">
            <img src="/img/store.png" class="clear">
            <h4>运动员健康状态填报</h4>
            <p>运动员健康状态填报</p>
            <i></i>
        </li>
    </ul>
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