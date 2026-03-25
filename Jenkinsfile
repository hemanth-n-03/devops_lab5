pipeline {
    agent any

    environment {
        // Replace with your Docker Hub username and repo name
        DOCKER_IMAGE = "your-username/my-app"
        REGISTRY_CREDS = 'docker-hub-creds'
    }

    stages {
        stage('Checkout') {
            steps {
                // Pulls code from your Git repository
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Builds the image using the Dockerfile in your root directory
                    // Tags it with the Jenkins build number for versioning
                    dockerApp = docker.build("${DOCKER_IMAGE}:${env.BUILD_NUMBER}")
                }
            }
        }

        stage('Push to Registry') {
            steps {
                script {
                    // Uses the credentials we stored in Step 1
                    docker.withRegistry('', REGISTRY_CREDS) {
                        dockerApp.push()
                        dockerApp.push("latest") // Also tag as latest
                    }
                }
            }
        }
    }

    post {
        always {
            // Clean up the local image to save disk space on the Jenkins agent
            sh "docker rmi ${DOCKER_IMAGE}:${env.BUILD_NUMBER} || true"
        }
    }
}
