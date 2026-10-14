
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out EMS Backend code'
            }
        }

        stage('Build') {
            steps {
                echo 'Building EMS Backend'
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying EMS Backend to EC2'

                sh '''
                    sudo systemctl stop ems-backend || true

                    sudo cp /var/lib/jenkins/workspace/EMS-Backend-Pipeline/target/ems-backend-0.0.1-SNAPSHOT.jar /opt/ems-backend/ems-backend.jar

                    sudo systemctl start ems-backend
                '''
            }
        }
    }
}
