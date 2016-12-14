var ioc = {
		//数据源
		dataSource : {
			type : "com.alibaba.druid.pool.DruidDataSource",
			events : {
				depose : "close"
			},
			fields : {
				driverClassName : "com.mysql.jdbc.Driver",
				url : "jdbc:mysql://58.192.29.212:3306/nutz?autoReconnect=true",
				username : "root",
				password : "3+1+8=813",
				maxActive : 100,
				maxWait: 1500, // 若不配置此项,如果数据库未启动,druid会一直等可用连接,卡住启动过程,
				testWhileIdle : true, // 非常重要,预防mysql的8小时timeout问题
	            defaultAutoCommit : false // 提高fastInsert的性能
			}
		},
		//数据库访问
		dao : {
			type : "org.nutz.dao.impl.NutDao",
			args : [{refer : "dataSource"}]
		}
}