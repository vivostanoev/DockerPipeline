def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('Set up grid and maven') {
            steps{
                        echo 'abv'
                        sh "docker network create ${network}"
                        sh "docker run -d -p 4444:4444 --name ${seleniumHub} --network ${network} selenium/hub"
                        sh "docker run -d -e HUB_PORT_4444_TCP_ADDR=${seleniumHub} -e HUB_PORT_4444_TCP_PORT=4444 --network ${network} --name ${chrome} selenium/node-chrome"
            }
        }
         stage('Run maven tests Test') {

                    steps {
                                      //sh "docker run --rm -e SELENIUM_HUB=${seleniumHub} -e BROWSER=chrome -e MODULE=order-module.xml -v ${WORKSPACE}/order:/usr/share/tag/test-output  --network ${network} vinsdocker/containertest"
                           sh 'docker run --network ${network} maven:3-alpine mvn clean install -f ${WORKSPACE}/pom.xml'
                    }
                }
                 stage('Tearing Down Selenium Grid') {
                          steps {
                             //remove all the containers and volumes
                             sh "docker rm -vf ${chrome}"
                             sh "docker rm -vf ${seleniumHub}"
                             sh "docker network rm ${network}"
                          }
                        }
    }
}