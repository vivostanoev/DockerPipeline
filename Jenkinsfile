pipeline {
    agent any
    stages {
        stage('get docker image') {
            steps {
            dir ('var/jenkins_home/workspace/DockerPipeline_master') {
                sh 'docker-compose up'
                }
            }
        }
         stage('Test') {

                    steps {
                        sh 'mvn clean install'
                    }
                }
    }
}