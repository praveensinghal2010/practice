# Use the official OpenJDK 17 slim image as the base image
FROM openjdk:17-jdk-slim

# Set the MAVEN_VERSION environment variable
ENV MAVEN_VERSION=3.9.6

# Define where to install Maven
ENV MAVEN_HOME=/usr/share/maven
ENV MAVEN_CONFIG="/root/.m2"

# Install dependencies and Maven
RUN apt-get update && \
    apt-get install -y curl tar gnupg wget unzip && \
    mkdir -p /usr/share/maven /usr/share/maven/ref && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xzC /usr/share/maven --strip-components=1 && \
    ln -s /usr/share/maven/bin/mvn /usr/bin/mvn && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Display Maven version to confirm installation
RUN mvn -v

RUN curl -sSL https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Display Chrome version to confirm installation
RUN google-chrome --version



# Set up the work directory
WORKDIR /app

# Copy the project files
COPY . /app

# Specify the command to run Maven build
CMD ["mvn", "clean", "install"]
