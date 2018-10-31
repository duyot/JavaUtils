package com.utils.common;

import com.smsmkt.workers.MNPSynJob;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.pool.HikariPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by duyot on 5/7/2017.
 */
public class DBUtils {
    private static HikariPool pool = null;
    public static Logger log = LoggerFactory.getLogger(MNPSynJob.class);

    public static HikariPool getDataSource() {
        return pool;
    }

    public static void init() {

        try {
            if (pool == null) {
                String configPath = "/hikari.properties";
                HikariConfig config = new HikariConfig(configPath);
                log.info("***********************:" + config.getJdbcUrl());
                pool = new HikariPool(config);
                log.info("Pool inited");
            } else {
                log.info("pool is not NULL");
                return;
            }
        } catch (Exception e) {
            log.error("Error in initPool: " + e);
        }
    }

    public static Connection getConnection() {
        if (pool == null) {
            log.info("pool is null, init it");
            init();
        }

        Connection conn = null;
        int retry = 0;
        try {
            while ((conn == null || conn.isClosed()) && retry < 1) {
                try {
                    conn = pool.getConnection();
                    log.trace(String.format("CONN: total=%d active=%d idle=%d ", pool.getTotalConnections(), pool.getActiveConnections(), pool.getIdleConnections()));
                } catch (Exception e) {
                    log.error("Error in get connection 1: " + e);
                }
                if (conn == null) {
                    try {
                        Thread.sleep(1000);
                        retry++;
                    } catch (Exception e) {
                        log.error("Error in get connection 2: " + e);
                    }
                }
            }
        } catch (SQLException e) {
            log.error("Get Connection fail:" + e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {

            log.error("Error in close connection: " + e);
        }
    }

    public static void closePool() throws InterruptedException {
        if (null != pool) {
            log.info("Shutdown pool connection");
            pool.shutdown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        init();
    closePool();
}

    public static void closeConnection(CallableStatement statement, Connection connection){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
