pipeline {
    agent any

    stages {

        stage('Build Frontend Image') {
            steps {
                sh 'docker build -t kaanak/full-frontend ./fullstack/frontend'
            }
        }

        stage('Build Backend Image') {
            steps {
                sh 'docker build -t kaanak/full-backend ./fullstack/demo'
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
