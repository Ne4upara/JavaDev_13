FROM postgres
ENV POSTGRES_USER javadev13
ENV POSTGRES_PASSWORD javadevPass
EXPOSE 5432:5432
ENV POSTGRES_DB java

#docker build -t pg/javadev13:v1 .
#docker run --name pg_javadev13 -d -p 5432:5432 pg/javadev13:v1
#docker run --name pg_javadev13 -d -p 5432:5432 -e POSTGRES_USER=javadev13 -e POSTGRES_PASSWORD=javadevPass pg/javadev13:v1