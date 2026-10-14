
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'EMS code checkout'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }
    }
}
