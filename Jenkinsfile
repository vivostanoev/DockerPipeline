pipeline {
    agent any
    stages {
        stage('get docker image') {
            steps {
                sh 'docker-compose -f /var/jenkins_home/workspace/DockerPipeline_master/docker-compose.yml up --build'
            }
        }
         stage('Test') {

                    steps {
                        sh 'mvn clean install'
                    }
                }
    }
}