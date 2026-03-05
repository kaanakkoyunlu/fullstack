pipeline {
    agent any

    stages {

	stage('Build Backend') {
            steps {
                dir('demo') {
                    sh 'mvn clean package -DskipTests'
                }
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
