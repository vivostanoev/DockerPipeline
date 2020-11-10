pipeline {
    agent any
    stages {
        stage('get docker image') {
            steps {
                sh 'var/jenkins_home/workspace/DockerPipeline_master/docker-compose.yml up'
            }
        }
         stage('Test') {

                    steps {
                        sh 'mvn clean install'
                    }
                }
    }
}