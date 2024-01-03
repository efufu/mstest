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
    <!-- 添加/编辑学生表单 -->
    <form @submit.prevent="submitStudentForm">
        <label for="id">学生ID：</label>
        <input v-model="formData.id" required><br>

        <label for="name">学生姓名：</label>
        <input v-model="formData.name" required><br>

        <div v-for="(course, index) in formData.courses" :key="index">
            <label :for="'courseId' + index">课程ID：</label>
            <input v-model="course.id" :name="'courseId' + index" required><br>
            <label :for="'courseName' + index">课程名称：</label>
            <input v-model="course.name" :name="'courseName' + index" required><br>
        </div>
        <button @click.prevent="addCourse">添加课程</button>

        <button v-if="!editingStudent" type="submit">添加</button>
        <button v-else type="button" @click="updateStudent">更新</button>
    </form>

    <!-- 查询表单 -->
    <form @submit.prevent="searchStudents">
        <label for="search">查询学生：</label>
        <input v-model="searchId" placeholder="输入ID">
        <button type="submit">查询</button>
    </form>

    <br>
    <!-- 学生表格 -->
    <table v-if="students.length > 0">
        <thead>
        <tr>
            <th>学生ID</th>
            <th>学生姓名</th>
            <th>课程信息</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="student in students" :key="student.id">
            <td>{{ student.id }}</td>
            <td>{{ student.name }}</td>
            <td>
                <div v-for="(course, index) in student.courses" :key="index">
                    {{ course.id }} - {{ course.name }}
                </div>
            </td>
            <td>
                <button @click="editStudent(student)">编辑</button>
                <button @click="deleteStudent(student.id)">删除</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>

<script>
    const {ref, reactive, onMounted} = Vue;

    const app = Vue.createApp({
        setup() {
            const formData = reactive({
                id: null,
                name: '',
                courses: [
                    { id: null, name: '' }  // 初始的一个课程
                ]
            });

            const searchId = ref('');
            const students = ref([]);
            const editingStudent = ref(null);
            const showTable = ref(false);

            const submitStudentForm = () => {
                if (editingStudent.value) {
                    // 编辑学生
                    updateStudent();
                } else {
                    // 添加学生
                    addStudent();
                }
            };

            const addStudent = () => {
                axios.post('add', formData)
                    .then(response => {
                        fetchStudents();
                        clearForm();
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
            };

            const updateStudent = () => {
                axios.post(`update/${editingStudent.value.id}`, formData)
                    .then(response => {
                        fetchStudents();
                        clearForm();
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
            };

            const searchStudents = () => {
                if (searchId.value) {
                    // 按ID查询
                    axios.get(`findById/${searchId.value}`)
                        .then(response => {
                            students.value = response.data ? [response.data] : [];
                            showTable.value = true;
                        })
                        .catch(error => {
                            console.error('Error:', error);
                        });
                } else {
                    // 查询全部
                    fetchStudents();
                    showTable.value = true;
                }
            };

            const editStudent = (student) => {
                formData.id = student.id;
                formData.name = student.name;
                formData.courses = [...student.courses];
                editingStudent.value = student;
            };

            const deleteStudent = (studentId) => {
                axios.post(`delete/${studentId}`, formData)
                    .then(response => {
                        fetchStudents();
                        clearForm();
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
            };

            const fetchStudents = () => {
                axios.get('find')
                    .then(response => {
                        students.value = response.data;
                    })
                    .catch(error => {
                        console.error('Error:', error);
                    });
            };

            const clearForm = () => {
                formData.id = null;
                formData.name = '';
                formData.courses.id = null;
                formData.courses.name = '';
                editingStudent.value = null;
            };

            const addCourse = () => {
                formData.courses.push({ id: null, name: '' });
            };

            onMounted(() => {
                // 页面加载时默认不显示表格
                showTable.value = false;
            });

            return {
                formData,
                searchId,
                students,
                editingStudent,
                showTable,
                addCourse,
                submitStudentForm,
                searchStudents,
                editStudent,
                deleteStudent
            };
        }
    });

    app.mount('#app');
</script>
</body>
</html>