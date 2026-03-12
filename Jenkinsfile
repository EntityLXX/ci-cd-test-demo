pipeline {
   agent any

   tools {
       maven 'Maven3'
   }

   environment {
       DEPLOY_PATH = 'D:\\tomcat10\\webapps'
       APP_NAME = 'ci-cd-test-demo'
       WAR_FILE = 'ci-cd-test-demo.war'
   }

   stages {
       stage('Checkout') {
           steps {
               checkout scm
           }
       }

       stage('Run Tests') {
           steps {
               bat 'mvn clean test'
           }
       }

       stage('Package WAR') {
           steps {
               bat 'mvn package'
           }
       }

       stage('Deploy to Tomcat') {
           steps {
               bat """
               if exist "%DEPLOY_PATH%\\%APP_NAME%" rmdir /s /q "%DEPLOY_PATH%\\%APP_NAME%"
               if exist "%DEPLOY_PATH%\\%WAR_FILE%" del /f /q "%DEPLOY_PATH%\\%WAR_FILE%"
               copy /Y "target\\%WAR_FILE%" "%DEPLOY_PATH%\\%WAR_FILE%"
               """
           }
       }
   }

   post {
       success {
           echo 'Pipeline completed successfully. Application deployed.'
       }
       failure {
           echo 'Pipeline failed. Deployment was not performed.'
       }
   }
}
