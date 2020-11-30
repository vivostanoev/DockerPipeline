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

             sh 'cd ${WORKSPACE}'
                        echo 'abv'
                        sh '/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin docker-compose build'

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