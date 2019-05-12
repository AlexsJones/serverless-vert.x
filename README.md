## Serverless vert.x on kubernetes


A very simple vert.x on knative/istio example

## Steps

- `https://github.com/cppforlife/knctl` install knative and istio on your cluster

```
knctl install
kubectl label namespace default istio-injection=enabled
kubectl apply -f kubernetes/knative-service.yaml 
kubectl get svc -n istio-system
curl -H "Host: helloworld-vertx.default.example.com" http://35.202.175.104
❯ kubectl get pods
NAME                                                 READY   STATUS    RESTARTS   AGE
helloworld-vertx-00001-deployment-54c447448b-smvs8   3/3     Running   0          1m

```

### Optional

```
If you would like to use gravitywell to deploy your kubernetes cluster please
use kubernetes/gravitywell/test-cluster.yaml
```

More info on how to interpolate and deploy [here](https://github.com/AlexsJones/gravitywell#running)

e.g.

```
vortex --output kubernetes/gravitywell/deployment --template kubernetes/gravitywell/cluster/ --set "projectname=alex-example" --set "projectregion=us-east4" --set "clustername=testcluster"
```
