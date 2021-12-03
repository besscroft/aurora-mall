# 该镜像需要依赖的基础镜像
FROM java:8
# 拷贝jar包，并重命名
COPY target/mall-log-1.0.jar /mall-log.jar
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","/mall-log.jar"]
# 指定维护者的名字
MAINTAINER besscroft