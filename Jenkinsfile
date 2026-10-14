
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    sudo systemctl stop ems-backend || true
                    sudo cp target/ems-backend-0.0.1-SNAPSHOT.jar /opt/ems-backend/ems-backend.jar
                    sudo systemctl start ems-backend
                '''
            }
        }
    }
}
