pipeline {
    agent any

    tools {
        jdk 'JDK-24'
        maven 'Maven'
    }

    environment {
        IMAGE_NAME = "employee-management-compose"
        CONTAINER_NAME = "employeeapp"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/mukunthansk/EmployeeManagementCompose.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Stop Existing Containers') {
            steps {
                bat 'docker compose down || exit 0'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker compose build'
            }
        }

        stage('Start Containers') {
            steps {
                bat 'docker compose up -d'
            }
        }

        stage('Verify Running Containers') {
            steps {
                bat 'docker ps'
            }
        }

    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check the console output for details.'
        }

        always {
            echo 'Pipeline execution finished.'
        }
    }
}
