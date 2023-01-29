## Usage

[Helm](https://helm.sh) must be installed to use the charts.  Please refer to
Helm's [documentation](https://helm.sh/docs) to get started.

Once Helm has been set up correctly, add the repo as follows:

  helm repo add Lab_WP_185025 https://damyzo.github.io/Lab_WP_185025/

If you had already added this repo earlier, run `helm repo update` to retrieve
the latest versions of the packages.  You can then run `helm search repo
Lab_WP_185025` to see the charts.

To install the spring-web-app chart:

    helm install my-spring-web-app Lab_WP_185025/spring-web-app

To uninstall the chart:

    helm delete my-spring-web-app
