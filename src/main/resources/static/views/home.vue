<template>
    <div class="index">
        <el-container>
            <!-- 侧边栏 -->
            <side-bar></side-bar>
            <el-container>
                <el-main>
                    <el-tabs v-model="activeTab" type="card" closable
                             @tab-remove="removeTab"
                             @tab-click="tabClick"
                    >
                        <el-tab-pane
                                v-for="(item, index) in tabs"
                                :key="item.route"
                                :label="item.title"
                                :name="item.route"
                        >
                        </el-tab-pane>
                    </el-tabs>
                    <transition name="el-fade-in">
                        <keep-alive>
                            <router-view></router-view>
                        </keep-alive>
                    </transition>
                </el-main>
            </el-container>
        </el-container>
    </div>

</template>

<script type="text/javascript">
    Vue.component('sideBar', httpVueLoader("/components/aside/sideBar.vue"))

    module.exports = {
        data() {
            return {
                activeTab: '2',
                tabs: [
                    {
                        title: '我的订单',
                        route: 'welcome',
                        content: '我的订单'
                    },
                    {
                        title: '公司订单',
                        route: 'sideBar',
                        content: '公司订单'
                    }
                ]
            }
        },
        created() {
            console.log('home')
            this.$store.state.count = 2
            console.log(this.$store.state.count)
            this.$store.commit("increment")
            console.log(this.$store.state.count)
        },
        methods: {
            tabClick() {
                let router = this.activeTab;
                this.$router.push({name: router})
            },
            removeTab(targetName) {
                let tabs = this.tabs;
                let activeName = this.activeTab;
                if (activeName === targetName) {
                    tabs.forEach((tab, index) => {
                        if (tab.route === targetName) {
                            let nextTab = tabs[index + 1] || tabs[index - 1];
                            if (nextTab) {
                                activeName = nextTab.route;
                            }
                        }
                    });
                }

                this.activeTab = activeName;
                this.tabs = tabs.filter(tab => tab.route !== targetName);
            }
        }
    }
</script>

<style>
    .index, .el-container {
        height: 100%;
    }
</style>