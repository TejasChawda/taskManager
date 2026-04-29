pipeline {
    agent any

    environment {
        IMAGE_NAME = "vagrant25/my-java-app"
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build & Push Docker Image') {
            when {
                anyOf {
                    changeset "src/**"
                    changeset "test/**"
                }
            }
            steps {
                script {
                    def tag = "${env.BUILD_NUMBER}"

                    // Build image
                    sh "docker build -t ${IMAGE_NAME}:${tag} ."

                    // Login + Push
                    withCredentials([usernamePassword(
                            credentialsId: 'DOCKER_CREDS',
                            usernameVariable: 'DOCKER_USER',
                            passwordVariable: 'DOCKER_PASS'
                    )]) {
                        sh """
                        echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
                        docker push ${IMAGE_NAME}:${tag}
                        """
                    }
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}