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
            cleanWs();
                        echo 'abv'
                        sh "docker network create ${network}"
                        sh "docker run -d -p 4446:4446 --name ${seleniumHub} --network ${network} selenium/hub"
                        sh "docker run -d -e HUB_PORT_4444_TCP_ADDR=${seleniumHub} -e HUB_PORT_4446_TCP_PORT=4446 --network ${network} --name ${chrome} selenium/node-chrome"
                        sh "docker run -d --network ${network} maven"
            }
        }
         stage('Test') {
                    steps {
                                      //sh "docker run --rm -e SELENIUM_HUB=${seleniumHub} -e BROWSER=chrome -e MODULE=order-module.xml -v ${WORKSPACE}/order:/usr/share/tag/test-output  --network ${network} vinsdocker/containertest"
                                      sh 'mvn clean test -Dwebdriver.type=remote -Dwebdriver.url=http://localhost:4446/wd/hub -Dwebdriver.cap.browserName=chrome'
                    }
                }
                 stage('Tearing Down Selenium Grid') {
                          steps {
                             //remove all the containers and volumes
                             sh "docker rm -vf ${chrome}"
                             sh "docker rm -vf ${firefox}"
                             sh "docker rm -vf ${seleniumHub}"
                             sh "docker network rm ${network}"
                          }
                        }
    }
}