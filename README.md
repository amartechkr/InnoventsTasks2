# InnoventsTasks2
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring:
  datasource: 
    url: mysql://localhost:3306/sales
    username: root
    password: ****

# Hibernate

# The SQL dialect makes Hibernate generate better SQL for the chosen database

  jpa:
    properties:
      hibernate: 
      dialect : org.hibernate.dialect.MySQL5InnoDBDialect
      # Hibernate ddl auto (create, create-drop, validate, update)
    hibernate:
       ddl-auto: update
