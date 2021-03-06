def call (){
    echo "Start Services ${env.SERVICES}"
    echo "Services ConfigsDir ${env.SERVICES_DIR}"
    echo "Services HelmChart ${env.SERVICES_HELM}:${env.SERVICES_HELM_VERSION}"
    env.SERVICES.tokenize(" ").each { s ->
        env.SERVICE_NAME=s
            echo "Library Start ${SERVICE_NAME}"
            sh '''
                [[ "X${SERVICE_NAME}" = "Xclickhouse" ]] && sed -i "s/ZOOKEEPER_HOST/zookeeper-${BUILD_HASH}-j/" ./${SERVICES_DIR}/clickhouse-values.yaml
                helm install --atomic -f ./${SERVICES_DIR}/${SERVICE_NAME}-values.yaml ${SERVICE_NAME}-${BUILD_HASH} \
                  --set nameOverride="j" -n "jenkins" carrotquest/${SERVICES_HELM} --version ${SERVICES_HELM_VERSION}
            '''
    }
}