ARG COMPILE_IMAGE
ARG EXECUTE_IMAGE
ARG APPLICATION_NAME

FROM $COMPILE_IMAGE AS compile
ENV BUILD_DIRECTORY /workdir
ENV APPLICATION_CODE src/main

RUN mkdir -p $BUILD_DIRECTORY
COPY --chown=gradle:gradle build.gradle $BUILD_DIRECTORY
COPY --chown=gradle:gradle settings.gradle $BUILD_DIRECTORY

RUN mkdir -p $BUILD_DIRECTORY/$APPLICATION_CODE
COPY --chown=gradle:gradle ./$APPLICATION_CODE $BUILD_DIRECTORY/$APPLICATION_CODE

WORKDIR $BUILD_DIRECTORY
RUN gradle clean assemble --no-daemon

FROM $EXECUTE_IMAGE
ENV EXECUTE_DIRECTORY /app
ENV ARTIFACT_NAME $APPLICATION_NAME.jar
ENV HOME_DIRECTORY $EXECUTE_DIRECTORY
ENV USER_NAME $APPLICATION_NAME
ENV GROUP_NAME $APPLICATION_NAME

# See libsDirName in https://docs.gradle.org/current/userguide/java_plugin.html#sec:jar
COPY --from=compile $BUILD_DIRECTORY/build/libs/$ARTIFACT_NAME $EXECUTE_DIRECTORY/$ARTIFACT_NAME
#RUN addgroup -g 1016 $GROUP_NAME
#RUN adduser -u 1016 -G $GROUP_NAME -h $HOME_DIRECTORY -D $APPLICATION_NAME
#USER $USER_NAME
#WORKDIR $EXECUTE_DIRECTORY
#ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar $ARTIFACT_NAME"]
