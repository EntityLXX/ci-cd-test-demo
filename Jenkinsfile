pipeline {
   agent any

   tools {
       maven 'Maven3'
   }

   environment {
       DEPLOY_PATH = 'D:\\truetomcat\\webapps'
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
               if exist "${env.DEPLOY_PATH}\\${env.APP_NAME}" rmdir /s /q "${env.DEPLOY_PATH}\\${env.APP_NAME}"
               if exist "${env.DEPLOY_PATH}\\${env.WAR_FILE}" del /f /q "${env.DEPLOY_PATH}\\${env.WAR_FILE}"
               copy /Y "target\\${env.WAR_FILE}" "${env.DEPLOY_PATH}\\${env.WAR_FILE}"
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
