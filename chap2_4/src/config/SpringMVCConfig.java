package config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan("controller")
@ComponentScan("service")
@ComponentScan("dao")
@PropertySource(value={"classpath:jdbc.properties"},ignoreResourceNotFound=true) 
public class SpringMVCConfig implements WebMvcConfigurer {

	@Value("${jdbc.url}")//注入属性文件jdbc.properties中的jdbc.url
    private String jdbcUrl;
    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;
	
	/**
	 * 配置视图解析器
	 */
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	/**
	 * 配置静态资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/html/**").addResourceLocations("/html/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	}
	
	
    /**
     * 配置数据源
     */
    @Bean
    public DriverManagerDataSource dataSource() {
    	DriverManagerDataSource myDataSource  = new DriverManagerDataSource();
        // 数据库驱动
    	myDataSource.setDriverClassName(jdbcDriverClassName);;
        // 相应驱动的jdbcUrl
    	myDataSource.setUrl(jdbcUrl);
        // 数据库的用户名
    	myDataSource.setUsername(jdbcUsername);
        // 数据库的密码
    	myDataSource.setPassword(jdbcPassword);
        return myDataSource;
    }
    /**
     * 配置JdbcTemplate 
     */
    @Bean(value="jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
    	return new JdbcTemplate(dataSource());
    }
   
}
