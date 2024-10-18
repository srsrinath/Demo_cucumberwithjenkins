pipeline {
    agent any
    environment {
        credsFilePath = "C:\Users\Admin\Desktop\credentials.properties.txt" // Ensure this path is accessible from Jenkins
    }
    stages {
        stage('Clone Repository') {
            steps {
                script {
                    // Clone the GitHub repository using the configured credentials
                    git url: 'https://github.com/srsrinath/Demo_cucumberwithjenkins.git',
                        branch: 'master',
                        credentialsId: '83163479' // Use the ID of your GitHub credentials
                }
            }
        }
        stage('Install Dependencies') {
            steps {
                // Run Maven to install dependencies
                bat 'mvn clean install' // This will clean the project and install dependencies
            }
        }
        stage('Run Cucumber Tests') {
            steps {
                script {
                    // Print the environment variable for debugging
                    echo "Running Cucumber tests with the following parameters:"
                    echo "Environment: ${env}"
                    echo "Credentials file path: ${credsFilePath}"

                    // Execute the Cucumber tests with Maven
                    bat "mvn clean test -Denv=dev -DbrowserMode=headless -Dcucumber.filter.tags='@test' -DcredsFilePath=\"${credsFilePath}\" -DthreadCount=10"
                }
            }
        }
    }
}
