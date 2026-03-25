pipeline {
    agent any
    environment {
        // Change 'your-docker-id' to your actual Docker Hub username
        DOCKER_HUB_USER = 'docker-hub-creds'
        APP_NAME = 'my-java-app'
        REGISTRY_CREDS = 'docker-hub-creds' // The ID you set in Jenkins Credentials
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Image') {
            steps {
                script {
                    // Builds using the Dockerfile you just created
                    dockerImage = docker.build("${DOCKER_HUB_USER}/${APP_NAME}:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('', REGISTRY_CREDS) {
                        dockerImage.push()
                        dockerImage.push("latest")
                    }
                }
            }
        }
    }
}
