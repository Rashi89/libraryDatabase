package pl.agata.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    private static Statement statement;

    static {
        config.setJdbcUrl( "jdbc:mysql://localhost/library" );
        config.setUsername( "root" );
        config.setPassword( "" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    public DBService() {}

    private static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static Statement init() throws SQLException {
        Statement statementInit = DBService.getConnection().createStatement();
        statement = statementInit;
        return statement;
    }

    public static ResultSet query(String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public static void dml(String sql) throws SQLException {

        if(sql.startsWith("INSERT")){
            statement.executeUpdate(sql);
        } else if(sql.startsWith("DELETE")){
            statement.executeUpdate(sql);
        }
    }



}
