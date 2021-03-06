package pl.sidor.config.db;

import javax.sql.DataSource;
import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Profile("h2")
@Configuration
public class H2DataSource {

	// jdbc:h2:mem:testdb
	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("sql/create-db.sql").addScript("sql/insert-data.sql").build();
		return db;

	}


	// Start WebServer, access http://localhost:8082
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server startDBManager() throws SQLException {
		return Server.createWebServer();
	}

}