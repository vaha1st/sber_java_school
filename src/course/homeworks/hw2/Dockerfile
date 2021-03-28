FROM alpine

# Copy Sber Course code package
COPY . /usr/src/sber/course/homeworks/hw2
WORKDIR /usr/src/sber

# Update alpine packages
RUN apk update

# Install openjdk11
RUN apk add openjdk11
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk
ENV PATH $PATH:$JAVA_HOME/bin

RUN javac course/homeworks/hw2/*.java

# Run GuessNum
# CMD java course.homeworks.hw2.GuessNum

# Run TextFrame
CMD java course.homeworks.hw2.TextFrame
