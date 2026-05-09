**************Java App CI/CD with Jenkins, Docker, and Kubernetes**************

🔹 Objective

Deploy a simple Java HTTP server (Hello from Jenkins CI/CD Pipeline!) using a Jenkins pipeline that builds a Docker image, pushes it to a registry, and deploys it on a Kubernetes cluster (kind).

**Pipeline Architecture**

Developer → GitHub → Jenkins → Maven Build → Docker Build → DockerHub -> k8s cluster

Stage 1: Checkout Source Code

Stage 2: Maven Build & UT

stage 3: SonarQube analysis

Stage 4: Docker Image Build & push

Stage 5: Deploy to application to k8s Cluster

stage 6: Application verfication


| Tool      | Purpose                |
| --------- | ---------------------- |
| GitHub    | Source code management |
| Jenkins   | CI/CD automation       |
| Maven     | Java build tool        |
| Docker    | Containerization       |
| DockerHub | Image registry         |
| k8s       | cluster for application|


****Final Outcome****

At the end of the pipeline:

Java application is successfully built
Docker image is created
Image is uploaded to DockerHub
Application becomes deployment-ready
Application deployed to k8s cluster using kubconfig data

********Issues Encountered & Fixes********

1.Pods not registered as endpoints

Cause: Missing RBAC for endpoint-slice controller.

Fix: Applied ClusterRole + ClusterRoleBinding for system:controller:endpoint-slice-controller.

2.Unauthorized errors in events

Cause: ClusterRoleBinding pointed to non‑existent ClusterRole.

Fix: Created ClusterRole with permissions on endpoints and endpointslices.

3.Port-forward conflict

Cause: Jenkins already using local port 8080.

Fix: Used alternative local port (e.g., 9090:80) in kubectl port-forward.

4.NodePort unreachable in kind

Cause: Kind cluster doesn’t expose NodePort to host by default.

Fix: Either use kubectl port-forward or recreate kind cluster with extraPortMappings.
