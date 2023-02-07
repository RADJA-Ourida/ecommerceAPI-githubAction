FROM openjdk:17
EXPOSE 3000
ADD target/ecommerce.jar ecommerce.jar
ENTRYPOINT ["java","-jar","/ecommerce.jar"]