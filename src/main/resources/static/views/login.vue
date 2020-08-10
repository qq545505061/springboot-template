<template>
	<div class="login">
		<el-container>
			<el-header>
				<div class="title">
					<h1>卓晟后台管理系统</h1>
				</div>
			</el-header>
			<el-main>
				<div class="input-suffix">
					<el-input placeholder="输入账号或手机号码" v-model="username">
						<template slot="prepend">用户名：</template>
					</el-input>

				</div>
				<div class="input-suffix">
					<el-input placeholder="密码...">
						<template slot="prepend">密<span style="margin-left:1em">码：</template>
					</el-input>
				</div>
				<div>
					<el-button type="primary" round @click="submit()">登录</el-button>
				</div>
			</el-main>
		</el-container>
	<div>
</template>

<script >
	module.exports = {
		data() {
			return {
				username: ''
			}
		},
		created() {
			console.log("create......")
		},
		methods: {
			submit() {
				console.log("login.........")
				console.log(this.$store.state.count)
				get("/user/getUserById", {id: 1})
				.then(res => {
					sessionStorage.setItem("user", res.data)
					this.$router.push({name: 'home'})
				})
			}
		}
	}
</script>

<style scoped>
	.login {
		position: absolute;
		left: 35%;
		top: 25%;
		width: 30%;
		height: 50%;
		text-align: center;
	}
	.title {
		margin-bottom: 50px;
	}
	.input-suffix {
		margin-bottom: 15px;
	}
	.input-suffix :first-child {
        background-color: #fff;
    }
	button {
		width: 60%;
	}
</style>