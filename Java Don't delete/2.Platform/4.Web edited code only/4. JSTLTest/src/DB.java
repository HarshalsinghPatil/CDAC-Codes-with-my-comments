package classic.web.app;

import java.sql.*;
import com.mysql.cj.jdbc.*;
//import oracle.jdbc.pool.*;

class DB {
// if you are using the sqlLite then it don't support connection pool and because it don't have username and password .It don't have the centralised data .It directly fetch the data using driver manager.
	private static MysqlConnectionPoolDataSource pool;
	//private static OracleConnectionPoolDataSource pool;

	public static Connection connect() throws SQLException {
		if(pool == null){//if pool is not initialised  then create object of the pool and using that object set the url 
			pool = new MysqlConnectionPoolDataSource();
			//pool = new OracleConnectionPoolDataSource();
			//if your database is on the internet  then its important to encrypt the unama and pwd because it passes through ISP and other can know your details.
			pool.setURL("jdbc:mysql://localhost/sales?useSSL=false"); //jdbc:oracle:thin:@//localhost/xe
			pool.setUser("darshan"); //scott
			pool.setPassword("patil"); //tiger
		}
		return pool.getConnection();
	}

}

