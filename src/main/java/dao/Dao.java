package dao;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public abstract class Dao {
    protected DataSource dataSource = new MysqlDataSource();
    protected String user = "root";
    protected String password = "yfgjktjy1813";
}
