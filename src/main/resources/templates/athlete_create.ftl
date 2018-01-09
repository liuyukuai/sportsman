<!DOCTYPE html><html><head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/ui.css"></head>
    <link rel="stylesheet" href="/css/index.css"></head>
<body>
<div id="app">
<mt-header fixed title="运动员个人信息填报1" class="app-header"></mt-header>
<div class="index-container" >
    <mt-field label="username" placeholder="Input username" v-model="username"></mt-field>
    <mt-field label="email" placeholder="Input email" type="email" v-model="email"></mt-field>
    <mt-field label="password" placeholder="Input password" type="password" v-modal="password"></mt-field>
    <mt-field label="phone" placeholder="Input tel" type="tel" v-model="phone"></mt-field>
    <mt-field label="website" placeholder="Input website" type="url" v-model="website"></mt-field>
    <mt-field label="number" placeholder="Input number" type="number" v-model="number"></mt-field>
    <mt-field label="birthday" placeholder="Input birthday" type="date" v-model="birthday"></mt-field>
    <mt-field label="introduction" placeholder="introduction" type="textarea" rows="4" v-model="introduction"></mt-field>
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