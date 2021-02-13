def call (){
    echo "Update helm repos"
    sh '''
      helm repo update
    '''
}