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
                    results: [[path: 'ukr-net-java/build/allure-results']]
                    ])
                        }

                    // junit 'ukr-net-java/build/test-results/test/*.xml'

                     }
            }
       }

  }
}