package https.github.com.GabrielPCdS.libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    /**
     * QUANDO USAR: Ideal apenas para ambientes de testes locais (como testes unitários/integrados rápidos),
     * scripts de automação isolados ou provas de conceito (PoC) extremamente simples.
     *
     * MOTIVO: Como ele abre e fecha uma conexão física com o banco de dados a cada nova requisição,
     * o custo de processamento é muito alto. Em aplicações reais ou APIs Web com múltiplos acessos
     * simultâneos, essa abordagem causaria lentidão extrema e derrubaria o banco de dados rapidamente.
     */

    //    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        return ds;
    }

    /**
     * configuracao Hikary
     * https://github.com/brettwooldridge/HikariCP
     * @return
     */

    /**
     * QUANDO USAR: OBRIGATÓRIO para ambientes de Produção, APIs REST e aplicações Web reais.
     *
     * MOTIVO: Ele cria um "Pool" (uma piscina de conexões reutilizáveis que já ficam abertas).
     * Quando uma requisição chega, ela pega uma conexão pronta instantaneamente e a devolve ao final,
     * sem o custo de criar uma nova do zero. É a melhor escolha para sistemas que precisam de alta
     * performance, escalabilidade e controle rígido para que o banco de dados não sofra sobrecarga.
     */

    @Bean
    public DataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);

        config.setMaximumPoolSize(10); // maximo de conexões liberadas
        config.setMinimumIdle(1); // tamanho inicial do pool
        config.setPoolName("library-db-pool");
        config.setMaxLifetime(600000); // 600 mil ms (10 minutos)
        config.setConnectionTimeout(100000); // timeout para conseguir uma conexão
        config.setConnectionTestQuery("select 1"); // query de teste

        return new HikariDataSource(config);
        }
    }