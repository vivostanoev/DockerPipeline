def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
       stage('docker-compose') {
                  steps {
                     sh "docker-compose build"
                     sh "docker-compose up -d"
                  }
              }
         stage('Run maven tests Test') {

           agent { docker 'maven:3-alpine' }
                     steps {
                         echo 'Hello, Maven'
                         sh 'mvn test'
                     }
                    //steps {
                                      //sh "docker run --rm -e SELENIUM_HUB=${seleniumHub} -e BROWSER=chrome -e MODULE=order-module.xml -v ${WORKSPACE}/order:/usr/share/tag/test-output  --network ${network} vinsdocker/containertest"
                      //     sh 'docker run maven:3.3-jdk-8 mvn clean install -f ${WORKSPACE}/pom.xml'
                    //}
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