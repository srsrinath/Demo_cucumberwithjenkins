pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                script {
                    git url: 'https://github.com/srsrinath/Demo_cucumberwithjenkins.git',
                        branch: 'master',
                        credentialsId: '83163479'
                }
            }
        }
        stage('Install Dependencies') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Run Cucumber Tests') {
            steps {
                script {
                    echo "Running Cucumber tests with the following parameters:"
                    echo "Environment: ${env}"
                    echo "Credentials file path: ${credsFilePath}"

                    bat 'mvn clean test -Denv=dev -DbrowserMode=headless -Dcucumber.filter.tags="@test" -DcredsFilePath="C:/Users/Admin/Desktop/credentials.properties.txt" -DthreadCount=10'
    
                }
            }
        }
    }
}
