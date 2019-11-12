pipeline{
 agent any

  stages {

       stage('preparation') {
            steps {
               echo "Test Started"
            }
       }

       stage('MailTest') {
       when {
                branch 'master'
            }
            steps {
                sh 'gradlew clean :ukr-net-java:test --tests net.ukr.automation.selenium.pages.MailCreateDeleteTest -Dukr.net.user=user -Dukr.net.password=password'
            }
            post {
            always{
                   script {
                    allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                    ])
                        }

                     junit 'reports/*.xml'

                     }
            }
       }

  }
}