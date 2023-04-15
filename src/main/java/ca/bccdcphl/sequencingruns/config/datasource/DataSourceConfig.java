package ca.bccdcphl.sequencingruns.config.datasource;

import liquibase.integration.spring.SpringLiquibase;
import liquibase.integration.spring.SpringResourceAccessor;

import org.hibernate.cfg.AvailableSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * Configuration for IRIDA's JDBC Datasource
 */
@Configuration
@EntityScan(basePackages = {
        "ca.bccdc-phl.sequencingruns.domain.model",
})
public class DataSourceConfig {

    @Autowired
    Environment environment;

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    /**
     * Custom implementation of the SpringLiquibase bean (for doing liquibase on spring startup) that
     * exposes the application context so that we can have access to the application context in custom
     * java changesets.
     *
     */
    public static class ApplicationContextAwareSpringLiquibase extends SpringLiquibase {
        private final ApplicationContext applicationContext;

        public ApplicationContextAwareSpringLiquibase(final ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }

        @Override
        protected SpringResourceAccessor createResourceOpener() {
            return new ApplicationContextSpringResourceOpener(getResourceLoader());
        }

        /**
         * Custom SpringResourceOpener that gives access to the application context.
         *
         */
        public class ApplicationContextSpringResourceOpener extends SpringResourceAccessor {
            public ApplicationContextSpringResourceOpener(final ResourceLoader resourceLoader) {
                super(resourceLoader);
            }

            public ApplicationContext getApplicationContext() {
                return ApplicationContextAwareSpringLiquibase.this.applicationContext;
            }
        }
    }

    /**
     * Create an instance of {@link SpringLiquibase} to update the database
     * schema with liquibase change sets. This bean should only be invoked in a
     * production/dev environment and should *not* be invoked if Hibernate is
     * going to be creating the database schema. The scenario should not come
     * up, however we will test to see if Hibernate is set to generate a schema
     * before executing.
     *
     * @param dataSource         the connection to use to migrate the database
     * @param applicationContext the Spring Application Context
     * @return an instance of {@link SpringLiquibase}.
     */
    @Bean
    public SpringLiquibase springLiquibase(final DataSource dataSource, final ApplicationContext applicationContext) {

        final ApplicationContextAwareSpringLiquibase springLiquibase = new ApplicationContextAwareSpringLiquibase(applicationContext);
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:db.changelog-master.xml");

        Boolean liquibaseShouldRun = environment.getProperty("liquibase.update.database.schema", Boolean.class, false);

        springLiquibase.setShouldRun(liquibaseShouldRun);

        return springLiquibase;
    }
}