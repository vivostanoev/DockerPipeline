pipeline {
    agent any

     environment {
            PATH = "$PATH:/var/jenkins_home/workspace/DockerPipeline_master"
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