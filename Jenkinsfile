pipeline {
    agent any

     environment {
            PATH = "/var/jenkins_home/workspace/DockerPipeline_master/docker-compose.yml"
        }
    stages {
        stage('get docker image') {
            steps {
                sh 'docker-compose up'
            }
        }
         stage('Test') {

                    steps {
                        sh 'mvn clean install'
                    }
                }
    }
}