def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('run a grid') {
            steps{
                sh 'docker network create --name ${network}'
               sh 'docker run -d -p 4444:4444 --network ${network} --name ${seleniumHub} selenium/hub:3.141.59-20201119'
               sh 'docker run -d --network ${network} -e HUB_HOST=selenium-hub --name ${chrome} -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-20201119'
               sh 'docker run -d --network ${network} --name maven maven:3-alpine'
            }
        }
         stage('Test') {
                    steps {
                            sh 'mvn test'
                    }
                }
                 stage('Tearing Down Selenium Grid') {
                          steps {
                             //remove all the containers and volumes
                             sh "docker rm -vf ${chrome}"
                             sh "docker rm -vf ${seleniumHub}"
                             sh "docker rm -vf maven"
                             sh "docker network rm ${network}"
                          }
                        }
    }
}