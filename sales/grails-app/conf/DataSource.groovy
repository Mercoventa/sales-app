dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            url = "jdbc:mysql://127.0.0.1:8889/sales?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true"
          username = "root"
          password = "root"
          dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''

          driverClassName = "com.mysql.jdbc.Driver"
          dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
          pooled = true
          
          properties {
            maxActive = 20
            maxIdle = 10
            minIdle = 5
            initialSize = 10
            
            timeBetweenEvictionRunsMillis = 1000 * 60 * 1 // 1 minutes
            numTestsPerEvictionRun = 10
            minEvictableIdleTimeMillis = 1000 * 60 * 10 // To prevent instances to sit idle in the pool more than 10 mintures
                     
            // Remove abandoned connections (not closed)
            removeAbandoned = true
            removeAbandonedTimeout = 60 * 15 // 15 minutes
     
            maxWait = 100l
            
            validationQuery = "select 1 from dual"
            testOnBorrow = false
            testOnReturn = false
            testWhileIdle = true
           }
        }
    }
    test {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            dbCreate = "create-drop"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            properties {
               // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
               jmxEnabled = true
               initialSize = 5
               maxActive = 50
               minIdle = 5
               maxIdle = 25
               maxWait = 10000
               maxAge = 10 * 60000
               timeBetweenEvictionRunsMillis = 5000
               minEvictableIdleTimeMillis = 60000
               validationQuery = "SELECT 1"
               validationQueryTimeout = 3
               validationInterval = 15000
               testOnBorrow = true
               testWhileIdle = true
               testOnReturn = false
               jdbcInterceptors = "ConnectionState"
               defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
