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
                        sh "docker run -d -p 4445:4445 --network ${network} --name ${seleniumHub} --host 0.0.0.0 --port 4445' selenium/hub:3.141.59-20201119"
                        sh "docker run -d --network ${network} -e HUB_HOST=${seleniumHub} e HUB_PORT=4445 --name ${chrome} -v /dev/shm:/dev/shm selenium/node-chrome"
            }
        }
         stage('Run maven tests Test') {
            steps {
                echo 'runing tests'
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