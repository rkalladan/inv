1.Add Maven dependencies in the deployment assembly of project properties to avoid class not found exception of
dispatcher  servlet.
2.@Generated Value will create primary key auto increment.
3./WEB-INF/database.properties to put in property placeholder.
Due to exception "Caused by: org.springframework.expression.spel.SpelEvaluationException" downgraded spring security
to 3.2.8 from 4.0.1 and code is working fine.
http://www.studytrails.com/frameworks/spring/spring-security-custom-login-page.jsp===reference.
http://www.mkyong.com/spring-security/spring-security-form-login-using-database/
http://www.mkyong.com/spring-security/spring-security-hibernate-xml-example/===http://www.mkyong.com/spring-security/spring-security-hibernate-annotation-example/
5.exception is java.lang.IllegalArgumentException: Unsupported configuration attributes: [hasRole('admin')]===add use-expression=true in <http /> tag. so that u can use any expression.