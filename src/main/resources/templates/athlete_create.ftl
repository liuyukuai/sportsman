<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>个人信息维护</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <link rel="stylesheet" href="/css/frozen.css" />
    <link rel="stylesheet" href="/css/register.css" />
    <script type="text/javascript" src="/js/font.js"></script>
    <script type="text/javascript" src="/js/zepto.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/mobileSelect.css">
    <script src="/js/mobileSelect.js" type="text/javascript"></script>
    <script src="/js/vue.js" type="text/javascript"></script>
    <script src="/js/axios.min.js" type="text/javascript"></script>

</head>

<body>
<div class="split">
    基本信息
</div>
<div class="content" id="app">
    <div class="input-box">
        <label>姓名</label>
        <input placeholder="请输入" />
    </div>
    <div class="input-box">
        <label>项目</label>
        <div class="selectBox" id="xm"></div>
    </div>
    <div class="input-box">
        <label>性别</label>
        <div class="selectBox" id="xb"></div>
    </div>

    <div class="input-box">
        <label>姓名</label>
        <input placeholder="请输入" />
    </div>

    <div class="input-box">
        <label>年龄（岁）</label>
        <input placeholder="请输入" />
    </div>

    <div class="input-box">
        <label>代表单位</label>
        <input placeholder="请输入" />
    </div>

    <div class="input-box">
        <label>第几次参加冬奥会</label>
        <input placeholder="请输入" />
    </div>

    <div class="input-box">
        <label>从什么项目跨选到本项</label>
        <input placeholder="请输入" />
    </div>

    <div class="input-box">
        <label>从事本项目几年</label>
        <input placeholder="请输入" />
    </div>

    <div class="input-box">
        <label>现执教教练</label>
        <input placeholder="请输入" />
    </div>
    <div class="input-box">
        <label>之前执教教练（选填）</label>
        <input placeholder="请输入" />
    </div>

</div>
<div class="split">
    获奖信息
</div>
<div class="content">
    <div class="input-box">
        <label>年度各单项最好成绩名次</label>
        <input placeholder="请输入" />
    </div>
    <div class="input-box">
        <label>最近一次世锦赛各单项名次</label>
        <input type="text" placeholder="请输入" />
    </div>
    <div class="input-box">
        <label>2016-17年度排名</label>
        <input placeholder="请输入" />
    </div>
    <button type="button" class="submitBtn" >保 存</button>
</div>
</body>
<script class="demo-script">
    new Vue({
        el: '#app',
        data: {
            athlete:{
                name:'',
                gender:'',
                age:'',
                behalf_unit:'',
                participant_count:'',
                from_item:'',
                engage_year:'',
                current_coach:'',
                pre_coach:'',
                item:'',
                highest_rank:'',
                latest_world_rank:'',
                yearly_rank:''
            }
        },
        methods:{
            fillItem:function () {
                this.getItem()
            },
            fillGender:function () {
                var that = this;
                new MobileSelect({
                    trigger: '#xb',
                    title: '选择性别',
                    wheels: [{
                        data: ['男', '女']
                    }],
                    position: [0], //初始化定位 打开时默认选中的哪个 如果不填默认为0
                    transitionEnd: function(indexArr, data) {
                    },
                    callback: function(indexArr, data) {
                        $("#xb").text(data);
                        console.log(indexArr[0]);
                        that.gender = indexArr[0];
                    }
                });
            },
            getItem:function () {
                axios.get('/items').then(function (response) {
                    new MobileSelect({
                        trigger: '#xm',
                        title: '选择项目',
                        wheels: [{
                            data: response.data
                        }],
                        position: [2], //初始化定位 打开时默认选中的哪个 如果不填默认为0
                        transitionEnd: function(indexArr, data) {
                        },
                        callback: function(indexArr, data) {
                            $("#xm").text(data);
                        }
                    })
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        mounted:function () {
            this.fillItem()
            this.fillGender()
        }
    })
</script>
</html>