pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/kaanakkoyunlu/fullstack.git'
            }
        }

        stage('Build Frontend Image') {
            steps {
                sh 'docker build -t kaanak/full-frontend ./frontend'
            }
        }

        stage('Build Backend Image') {
            steps {
                sh 'docker build -t kaanak/full-backend ./demo'
            }
        }

        stage('Push Images') {
            steps {
                sh 'docker push kaanak/full-frontend'
                sh 'docker push kaanak/full-backend'
            }
        }

    }
}
