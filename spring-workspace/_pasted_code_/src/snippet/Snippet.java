package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
		xmlns:aop="http://www.springframework.org/schema/aop" xmlns:context="http://www.springframework.org/schema/context"
		xmlns:jee="http://www.springframework.org/schema/jee" xmlns:tx="http://www.springframework.org/schema/tx"
		xmlns:task="http://www.springframework.org/schema/task"
		xsi:schemaLocation="http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.2.xsd http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.2.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.2.xsd http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-3.2.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.2.xsd http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-3.2.xsd">
	
		<context:annotation-config />
	
		<context:component-scan base
		package="com.techlabs" />
		     
		     <tx:annotation-driven />
		
		     <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
				destroy-method="close">
				<property name="driverClassName" value="com.mysql.jdbc.Driver" />
				<property name="url" value="jdbc:mysql://localhost:3306/techlabs" />
				<property name="username" value="root" />
				<property name="password" value="root" />
			</bean>
			
			<bean id="transactionManager"
				class="org.springframework.orm.hibernate4.HibernateTransactionManager">
				<property name="sessionFactory" ref="sessionFactory" />
			</bean>
			
			<bean id="sessionFactory"
				class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
				<property name="dataSource" ref="dataSource" />
				<property name="packagesToScan" value="com.techlabs.entity"></property>
				<property name="hibernateProperties">
					<props>
						<prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
						<prop key="hibernate.hbm2ddl.auto">update</prop>
						<prop key="hibernate.show_sql">true</prop>
					</props>
				</property>
			</bean>
		     
			
		
		</beans>
		
		-
}

