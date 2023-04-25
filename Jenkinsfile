pipeline {
    agent any
    tools {
        maven 'M2_HOME' // Name of the Maven installation defined in Jenkins
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean'
                sh 'mvn clean package -DskipTests'

            }
        }
    }
}
