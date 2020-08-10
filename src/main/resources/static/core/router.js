
const router = new VueRouter({
	routes: [
		{
			path: "/",
			redirect: {path: '/login'}
		},
		{
			path: '/login',
			name: 'login',
			component: httpVueLoader('/views/login.vue')
		},
		{
			path: '/home',
			name: 'home',
			component: httpVueLoader('/views/home.vue'),
			children: [
				{
					path: '/welcome',
					name: 'welcome',
					component: httpVueLoader('/views/welcome.vue')
				},
				{
					path: '/sideBar',
					name: 'sideBar',
					component: httpVueLoader('/views/login.vue')
				}
			]
		}
	]
})


