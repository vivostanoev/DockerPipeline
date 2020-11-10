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
                        sh "docker network create ${network}"
                        sh "docker run -d -p 4444:4444 --name ${seleniumHub} --network ${network} selenium/hub"
                        sh "docker run -d -e HUB_PORT_4444_TCP_ADDR=${seleniumHub} -e HUB_PORT_4444_TCP_PORT=4444 --network ${network} --name ${chrome} selenium/node-chrome"
                        sh "docker run -d -e HUB_PORT_4444_TCP_ADDR=${seleniumHub} -e HUB_PORT_4444_TCP_PORT=4444 --network ${network} --name ${firefox} selenium/node-firefox"
            }
        }
         stage('Test') {
                    steps {
                        sh 'mvn clean install'
                    }
                }
    }
}