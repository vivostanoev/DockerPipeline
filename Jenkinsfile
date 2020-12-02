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
                        sh "docker run -d -p 4444:4444 --network ${network} --name ${seleniumHub} selenium/hub:3.141.59-20201119"
                        sh "docker run -d -e HUB_PORT_4444_TCP_ADDR=${seleniumHub} -e HUB_PORT_4444_TCP_PORT=4444 --network ${network} --name ${chrome} selenium/node-chrome"
            }
        }
         stage('Run maven tests Test') {
         agent {
                         docker {
                             image 'maven:3.6.3-ibmjava-8-alpine'
                         }
                     }

            steps {
                sh "mvn -DseleniumHubHost=${seleniumHub} -Dbrowser=chrome install"
            }
         }
         stage('Tearing Down Selenium Grid') {
            steps {
                echo 'finished'
                             //remove all the containers and volumes
                             //sh "docker rm -vf ${chrome}"
                             //sh "docker rm -vf ${seleniumHub}"
                             //sh "docker network rm ${network}"
            }
         }
    }
}