FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy your Java file
COPY src/main/java/ .

# Compile it
RUN javac Main.java

# Run it
CMD ["java", "Main"]