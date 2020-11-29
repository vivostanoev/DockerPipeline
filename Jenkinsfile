def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('run a grid') {
            steps{
                        echo 'abv'
                    sh 'docker network create ${network}'
                    sh 'docker run -d -p 4444:4444 --net grid --name ${seleniumHub}selenium/hub:3.141.59-20201119'
                    sh 'docker run -d --net grid -e HUB_HOST=selenium-hub --name ${chrome} -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-20201119'
                    sh 'docker run -d --net grid --name maven maven:3-alpine'
            }
        }
         stage('Test') {
                    steps {
                    sh 'mvn clean install'
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