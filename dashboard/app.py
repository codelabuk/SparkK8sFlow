import CORS
from flask import Flask
import os
import re
from kubernetes import client, config

app = Flask(__name__)
CORS(app)

# Load Kubernetes Config
try:
    config.load_incluster_config()
except:
    config.load_kube_config()
v1 = client.CoreV1Api()
batch_v1 = client.BatchV1Api()

NAMESPACE = os.environ.get("SPARK_NAMESPACE", "spark")


def get_pods():
    try:
        pods = v1.list_namespaced_pod(namespace=NAMESPACE)
        result = []
    #    for pods in pods.items:




