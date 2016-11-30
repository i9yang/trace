<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/vue.resource/1.0.3/vue-resource.min.js"></script>
    <script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>
</head>
<body>
<div id="title" style="text-align:center;">
    <h3>{{formatDate}} 검색 커버리지</h3>
</div>
<div id="coverage">
    <tableTemplate></tableTemplate>
</div>

<script type="x-template" id="tableTemplate">
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>집계기준일</th>
                <th>사이트 번호</th>
                <th>사이트 명</th>
                <th>전체쿼리 수</th>
                <th>성공쿼리 수</th>
                <th>검색 성공율</th>
                <th>실패쿼리 수</th>
                <th>실패쿼리2 수</th>
                <th>검색 실패율</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="i in items">
                <td>{{i.critn_dt}}</td>
                <td>{{i.site_no}}</td>
                <td>{{i.ssg_site.site_nm}}</td>
                <td>{{i.pv_count}}</td>
                <td>{{i.success_count}}</td>
                <td>{{(i.success_count / i.pv_count * 100).toFixed(2)}}</td>
                <td>{{i.nr1_count}}</td>
                <td>{{i.nr2_count}}</td>
                <td>{{(i.nr2_count / i.pv_count  * 100).toFixed(2)}}</td>
            </tr>
            </tbody>
        </table>
        <div style="text-align:center;">
            <button @click="prev" class="btn btn-default btn-sm">prev</button>
            <button @click="next" class="btn btn-default btn-sm">next</button>
        </div>
    </div>
</script>
<script type="text/javascript">
    var title = new Vue({
        el: '#title',
        data : {
            formatDate : '',
            date : ''
        },
        computed : {
            formatDate : function(){
                var pattern = /(\d{4})(\d{2})(\d{2})/;
                return this.date.replace(pattern, '$1 $2/$3');
            }
        }
    });

    var body = new Vue({
        el: '#coverage',
        template: '#tableTemplate',
        data : {
            items : [],
            page : 1,
            isNext : true
        },
        created : function(id){
            this.changePage(id || 1);
        },
        methods: {
            prev : function(){
                if(this.page != 1) {
                    this.page--;
                    this.changePage();
                }

                if(!this.isNext) {
                    this.isNext = true;
                }
            } ,
            next : function(){
                if(this.isNext) {
                    this.page++;
                    this.changePage();
                }
            } ,
            changePage : function(){
                this.$http.get('/coverage/' + this.page)
                        .then(function(response){
                            this.items = response.body;
                            var obj = response.body[0];
                            if(obj) {
                                title.date = obj.critn_dt;
                            } else {
                                title.date = '';
                                this.isNext = false;
                            }
                        });
            }
        }
    });
</script>
</body>
</html>
