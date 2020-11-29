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
                    'docker network create grid'
                    'docker run -d -p 4444:4444 --net grid --name selenium-hub selenium/hub:3.141.59-20201119'
                    'docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-20201119'
                    'docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-firefox:3.141.59-20201119'
                    'docker run -d --net grid -e HUB_HOST=selenium-hub -v /dev/shm:/dev/shm selenium/node-opera:3.141.59-20201119'
            }
        }
         stage('Test') {
                    steps {
                    'docker run -d --net grid --name maven maven:3.2-jdk-7 mvn -pom.xml clean install'
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