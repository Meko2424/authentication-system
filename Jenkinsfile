pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "meko2025/auth-system-backend"
    }

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/Meko2424/authentication-system.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh './mvnw clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t meko2025/auth-system-backend .'
            }
        }

        stage('Build & Run with Docker Compose') {
                    steps {
                        sh 'docker-compose down'
                        sh 'docker-compose up --build -d'
                    }
                }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }
    }
}