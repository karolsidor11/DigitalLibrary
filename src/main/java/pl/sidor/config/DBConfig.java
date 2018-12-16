package pl.sidor.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(value = "pl.sidor", transactionManagerRef = "db")
@EnableTransactionManagement
public class DBConfig {


//    @Bean
//    public DataSource dataSource() {
//        BasicDataSource ds = new BasicDataSource();
//        ds.setDriverClassName("org.h2.Driver");
//        ds.setUrl("jdbc:h2:~/test");
//        ds.setUsername("sa");
//        ds.setPassword("");
//        ds.setInitialSize(5);
//        ds.setMaxActive(10);
//        return ds;
//    }

//    @Bean
//    public DataSource dataSource() {
//
//
//        return ds;
//    }


    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/data");
        ds.setUsername("root");
        ds.setPassword("admin");
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(/*DataSource dataSource, JpaVendorAdapter jpaVendorAdapter*/) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
//        emfb.setPackagesToScan("pl.sidor");
//        emfb.setPersistenceUnitName("persistance.xml");
//        emfb.setDataSource(dataSource);
//        emfb.setJpaVendorAdapter(jpaVendorAdapter);
//        emfb.setPersistenceXmlLocation("META-INF/persistence.xml");
        emfb.setPersistenceUnitName("library");

        return emfb;
    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        return adapter;
    }


    @Bean(name = "db")
    public PlatformTransactionManager dbTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
