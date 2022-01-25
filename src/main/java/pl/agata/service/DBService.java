package pl.agata.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import pl.agata.controller.BooksController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    private  Statement statement;

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

    public Statement init() throws SQLException {
        Statement statementInit = DBService.getConnection().createStatement();
        this.statement = statementInit;
        return statement;
    }

    public ResultSet query(String sql) throws SQLException {
        ResultSet resultSet = this.statement.executeQuery(sql);
        return resultSet;
    }

    public void dml(String sql) throws SQLException {

        if(sql.startsWith("INSERT")){
            statement.executeUpdate(sql);
        } else if(sql.startsWith("DELETE")){
            statement.executeUpdate(sql);
        } else if(sql.startsWith("UPDATE")){
            statement.executeUpdate(sql);
        }
    }

    public void select() throws SQLException {
        BooksController booksController = new BooksController();
        ResultSet resultSet = query("SELECT * FROM `books`");
        while(resultSet.next()){
            booksController.createAlbum(1, "album", "A", "B", "C", 2022);
            booksController.createComic(2, "comics", "A", "B", "C", 2022);
            booksController.createFairystyle(3, "fairytale", "A", "B", "C", 2022);
            booksController.createGuide(4, "guide", "A", "B", "C", 2022);
            booksController.createScience(5, "science", "A", "B", "C", 2022);

            int id = resultSet.getInt("id");
            String type = resultSet.getString("type");
            String title = resultSet.getString("title");
            String publisher = resultSet.getString("publisher");
            String  author = resultSet.getString("author");
            int publication_year = resultSet.getInt("publication_year");
            int pages = resultSet.getInt("pages");
            int idType = convertTypeToInt(type);

            booksController.getBook(idType).setInformation(id,type,author,title,publisher,publication_year,pages);
            System.out.println(booksController.getBook(id).toString());

        }

    }
    private int convertTypeToInt(String type){
        switch(type){
            case "album":
                return 1;
            case "comics":
                return 2;
            case "fairytale":
                return 3;
            case "guide":
                return 4;
            case "science":
                return 5;
            default:
                return 0;
        }
    }


}
