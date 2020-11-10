pipeline {
    agent any
    stages {
        stage('get docker image') {
            steps {
                sh 'dockerfile up'
            }
        }
         stage('Test') {

                    steps {
                        sh 'mvn clean install'
                    }
                }
    }
}