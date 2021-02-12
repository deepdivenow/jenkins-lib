def call (){
    echo "Stop ${env.SERVICES}"
    env.SERVICES.tokenize(" ").each { s ->
        env.SERVICE_NAME=s
        try{
            echo "Library Stop ${SERVICE_NAME}"
                sh '''
                    helm uninstall ${SERVICE_NAME}-${BUILD_HASH} -n "jenkins"
                '''
        } catch(e) {
            echo e.toString()
        }
    }
}