pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = 'docker-hub-creds'
        IMAGE_NAME = 'hemanthn03/new_docker_image'
    }

    stages {

        stage('Build Java Application') {
            steps {
                bat 'javac app.java'
            }
        }

        stage('Run Java Program') {
            steps {
                bat 'java app'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:latest .'
            }
        }

        stage('Login to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                credentialsId: 'docker-hub-creds',
                usernameVariable: 'USER',
                passwordVariable: 'PASS')]) {

                    bat 'echo %PASS% | docker login -u %USER% --password-stdin'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                bat 'docker push %IMAGE_NAME%:latest'
            }
        }
    }
}
