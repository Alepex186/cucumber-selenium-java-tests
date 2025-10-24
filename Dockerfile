FROM gradle:9.1-jdk21-noble

RUN apt-get update && apt-get install -y --no-install-recommends wget \
    && mkdir -p /usr/local/temp && cd /usr/local/temp \
    \
    # Descargar e instalar Google Chrome 141.0.7390.54-1
    && wget https://mirror.cs.uchicago.edu/google-chrome/pool/main/g/google-chrome-stable/google-chrome-stable_141.0.7390.54-1_amd64.deb \
    && apt-get install --no-install-recommends -y ./google-chrome-stable_141.0.7390.54-1_amd64.deb \
    \
    # Descargar e instalar Microsoft Edge 141.0.3537.85-1
    && wget https://packages.microsoft.com/repos/edge/pool/main/m/microsoft-edge-stable/microsoft-edge-stable_141.0.3537.85-1_amd64.deb \
    && apt-get install --no-install-recommends -y ./microsoft-edge-stable_141.0.3537.85-1_amd64.deb \
    \
    # Descargar e instalar Firefox 144.0
    && wget https://download-installer.cdn.mozilla.net/pub/firefox/releases/144.0/linux-x86_64/en-US/firefox-144.0.deb \
    && apt-get install --no-install-recommends -y ./firefox-144.0.deb \
    \
    # Limpieza
    && rm -rf /usr/local/temp \
    && apt-get autoremove -y \
    && apt-get clean \
    && apt-get autoclean \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /usr/local/app
