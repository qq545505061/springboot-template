

// 拦截路由
router.beforeEach((to, from, next) => {
    let user = sessionStorage.getItem("user")
    if(user) {
        next()
    } else {
        if(to.path != '/login') {
            next({path: '/login'})
        } else {
            next()
        }

    }
})




