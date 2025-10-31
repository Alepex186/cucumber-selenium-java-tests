pipeline {
    agent {
        docker {
            image "alepex186/java-test-automation-kit:gradle9.1-jdk21-noble-chrome141.0.7390.54-1-edge141.0.3537.85-1-firefox144.0"
            args "-e HEADLESS=true -u 110:110 -v '${env.WORKSPACE}:/usr/local/app' --entrypoint=''"
        }
    }

    environment {
        REPO_URL = 'https://github.com/Alepex186/cucumber-selenium-java-tests.git'
        BRANCH = 'main'
        HOME = '/tmp'
        GRADLE_USER_HOME = "${HOME}/.gradle"
        HEADLESS = 'true'
        BROWSER = 'chrome'
    }

    stages {
        stage('Clonar repositorio') {
            steps {
                git branch: env.BRANCH, url: env.REPO_URL
            }
        }

        stage('Preparar workspace') {
            steps {
                sh 'chown -R 110:110 ${WORKSPACE}'
            }
        }

        stage('Iniciar servidor web') {
            steps {
                sh 'chmod +x run_parabank_webserver.sh'
                sh './run_parabank_webserver.sh &'
            }
        }

        stage('Verificar estado del servidor web') {
            steps {
                sh 'chmod +x verify_webserver_status.sh'
                sh './verify_webserver_status.sh'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean'
                sh './gradlew test --info --console=plain'
            }
        }

        stage('Publicar reporte HTML') {
            steps {
                publishHTML([
                    reportDir: 'app/target/cucumber-report',
                    reportFiles: 'cucumber.html',
                    reportName: 'Reporte Cucumber',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminado. Revisar resultados.'
        }
        success {
            echo 'Pipeline finalizó con éxito.'
        }
        failure {
            echo 'Pipeline falló. Revisar errores.'
        }
    }
}
