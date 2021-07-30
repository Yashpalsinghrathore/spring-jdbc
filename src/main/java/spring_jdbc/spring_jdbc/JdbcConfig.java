package spring_jdbc.spring_jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages={"com.spring.dao"})
public class JdbcConfig {

	@Bean(name={"ds"})
	public DataSource getDataSource()
	{
		
		DriverManagerDataSource dm = new DriverManagerDataSource();
		
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost:3306/springjdbc21");
		dm.setUsername("root");
		dm.setPassword("root");
		
		return dm;
		
		
	}
	
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getjdbcTemplate()
	{
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		 jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
}
