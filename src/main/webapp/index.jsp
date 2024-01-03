<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>
<body>
<div id="app">

    <form>
        <!-- 文本输入框 -->
        <label for="name">name:</label>
        <input type="text" id="name" name="name" value="fufu" required v-model="form.name"/>

        <br>

        <!-- 单选按钮 -->
        <label>sex:</label>
        <input type="radio" id="boy" value="boy" checked v-model="form.sex"/>
        <label for="boy">男</label>
        <input type="radio" id="girl" value="girl" v-model="form.sex"/>
        <label for="girl">女</label>

        <br>

        <!-- 复选框 -->
        <label>msg:</label>
        <input type="checkbox" id="msg1" value="msg1" v-model="form.msg"/>
        <label for="msg1">msg1</label>
        <input type="checkbox" id="msg2" value="msg2" v-model="form.msg"/>
        <label for="msg2">msg2</label>
        <input type="checkbox" id="msg3" value="msg3" v-model="form.msg"/>
        <label for="msg3">msg3</label>

        <br>

        <!-- 下拉列表 -->
        <label for="num">grade:</label>
        <select id="num" name="num" v-model="form.grade">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>

        <br>

        <label for="fileInput">file：</label>
        <input type="file" id="fileInput" ref="fileInput" accept="image/png,image/jpeg,image/gif" @change="handleFileUpload"/>


        <br>

        <button type="button" @click="add">添加</button>
        <button type="button" @click="update">更新</button>
    </form>

<%--    <!-- 查询表单 -->--%>
<%--    <form @submit.prevent="searchStudents">--%>
<%--        <label for="search">查询学生：</label>--%>
<%--        <input v-model="searchId" placeholder="输入ID">--%>
<%--        <button type="submit">查询</button>--%>
<%--    </form>--%>

<%--    <br>--%>
<%--    <!-- 学生表格 -->--%>
<%--    <table v-if="students.length > 0">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>学生ID</th>--%>
<%--            <th>学生姓名</th>--%>
<%--            <th>课程信息</th>--%>
<%--            <th>操作</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <tr v-for="student in students" :key="student.id">--%>
<%--            <td>{{ student.id }}</td>--%>
<%--            <td>{{ student.name }}</td>--%>
<%--            <td>--%>
<%--                <div v-for="(course, index) in student.courses" :key="index">--%>
<%--                    {{ course.id }} - {{ course.name }}--%>
<%--                </div>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <button @click="editStudent(student)">编辑</button>--%>
<%--                <button @click="deleteStudent(student.id)">删除</button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>
</div>

<script>
    const {ref, reactive} = Vue;

    const app = Vue.createApp({
        data() {
            return {
                form: {
                    name: 'fufu',
                    sex: 'boy',
                    msg: ref([]),
                    grade:'1',
                    file: null  // 存储上传的头像文件
                }
            };
        },
        methods: {
            handleFileUpload() {
                this.form.file = this.$refs.fileInput.files[0];
            },
            add() {
                const formData = new FormData();
                formData.append('name', this.form.name);
                formData.append('sex', this.form.sex);
                formData.append('msg', this.form.msg);
                formData.append('grade',this.form.grade)
                formData.append('file', this.form.file);

                axios.post('add', formData)
                    .then(response => {
                        console.log('上传成功:', response.data);
                    })
                    .catch(error => {
                        console.error('上传错误:', error);
                    });
            }
        }
    });
    app.mount('#app');
</script>
</body>
</html>