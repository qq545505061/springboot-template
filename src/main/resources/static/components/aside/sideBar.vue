<template>
    <el-aside ref="sideBar">
        <el-menu>
            <el-submenu :index="`${item.id}`" v-for="item in menuList">
                <template slot="title">
                    <i :class="item.icon"></i>
                    <span>{{item.name}}</span>
                </template>
                <el-menu-item :index="`${tag}`" v-for="tag in item.subMenu">
                    <router-link :to="tag.path">
                        <div><span>{{tag.name}}</span></div>
                    </router-link>
                </el-menu-item>
            </el-submenu>
        </el-menu>
    </el-aside>
</template>

<script>
    module.exports = {
        data() {
            return {
                menuList: []
            }
        },
        created() {
            this.getMenus()
        },
        methods: {
            getMenus() {
                get("/system/getMenus")
                    .then(res => {
                        this.menuList = res.data;
                    })
            }
        }
    }

</script>

<style scoped>
    .el-aside {
        width: 240px !important;
    }
    .el-aside ul {
        height: 100%;
        color: #ffffff;
        background-color: #21212c;
    }
    .el-aside span {
        color: #f0f0f0;
    }
    a:link {
        text-decoration: none;
    }
    ul li {
        background: none;
    }
    li:hover, li:hover div {
        background: none;
    }
</style>