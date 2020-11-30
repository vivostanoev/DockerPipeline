def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('Set Up Selenium Grid') {
            steps{

             sh 'docker run -d -p 4444:4444 --name selenium-hub6 selenium/hub:3.141.59-20201119'
             sh 'docker run -d --link selenium-hub6:hub -v /dev/shm:/dev/shm selenium/node-chrome:3.141.59-20201119'

            }
        }
         stage('Run tests') {

                    steps {
                          sh 'docker run --link selenium-hub6:hub maven:3-alpine mvn clean install -f ${WORKSPACE}'
                    }
                }
    }
}