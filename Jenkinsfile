def network='jenkins-${BUILD_NUMBER}'
def seleniumHub='selenium-hub-${BUILD_NUMBER}'
def chrome='chrome-${BUILD_NUMBER}'
def firefox='firefox-${BUILD_NUMBER}'
def containertest='conatinertest-${BUILD_NUMBER}'

pipeline {
    agent any

    stages {
        stage('Compose up') {
            steps{
                        echo 'abv'
                         sh '/usr/local/bin/docker-compose up --build'
                    sh "docker-compose -f ${WORKSPACE}/docker-compose.yml up"
            }
        }
         stage('Compose down') {

                    steps {

                     sh "docker-compose -f ${WORKSPACE}/docker-compose.yml down"
                                      //sh "docker run --rm -e SELENIUM_HUB=${seleniumHub} -e BROWSER=chrome -e MODULE=order-module.xml -v ${WORKSPACE}/order:/usr/share/tag/test-output  --network ${network} vinsdocker/containertest"
                          // sh 'docker run --network ${network} -e HUB_PORT_4444_TCP_ADDR=${seleniumHub} maven:3-alpine mvn clean install -f ${WORKSPACE}/pom.xml'
                    }
                }
    }
}