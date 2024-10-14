
COPY target/app-opera.jar /app.jar

ENTRYPOINT exec java ${JAVA_OPTS} -Dloader.path=/mnt/config/config-opera.zip -Djasypt.encryptor.password=${JASYPT_PWD} -jar app.jar
