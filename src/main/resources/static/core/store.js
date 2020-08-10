const store = new Vuex.Store({
    state: {
        count: 0,
        userInfo: {},
        options: [],
        activeIndex: ''
    },
    mutations: {
        // 存储用户信息
        SAVE_USER (state, user) {
            state.userInfo = user
        },
        // 添加tab
        ADD_TAB(state, tab) {
            state.options.push(tab)
        },
        // 删除tab
        DEL_TAB(state, route) {
            let index = 0
            for(let option of state.options) {
                if(option.route === route) {
                    break
                }
                index++
            }
            state.options.splice(index, 1)
        },
        // 存储当前激活状态的tab index
        SAVE_ACTIVE_INDEX(state, index) {
            state.activeIndex = index
        }
    }
})