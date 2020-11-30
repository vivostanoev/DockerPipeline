def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('run a grid') {
            steps{
                                    echo 'abv'
                                    sh "docker network create ${network}"
                                    sh "docker run -d -p 4444:4444 --name ${seleniumHub} --network ${network} selenium/hub"
                                    sh "docker run -d -e HUB_PORT_4444_TCP_ADDR=selenium-hub -e HUB_PORT_4444_TCP_PORT=4444 --network ${network} --name ${chrome} selenium/node-chrome"
                        }
        }
         stage('Test') {
                    steps {
                            sh 'mvn test -f ${WORKSPACE}'
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